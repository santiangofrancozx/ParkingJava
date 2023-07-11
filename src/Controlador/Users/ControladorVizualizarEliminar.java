package Controlador.Users;

import Modelo.ConsultasUsuarios;
import Modelo.Usuario;
import Vista.Users.Eliminar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

public class ControladorVizualizarEliminar implements ActionListener {


    Eliminar vista;
    ConsultasUsuarios modelo;
    Usuario us = new Usuario();
    ArrayList<Usuario> uss = new ArrayList<>();
    public ControladorVizualizarEliminar(Eliminar vista, ConsultasUsuarios modelo){
        this.vista = vista;
        this.modelo = modelo;
        this.vista.bbuscar.addActionListener(this);
        this.vista.beliminarSeleccionados.addActionListener(this);
        this.vista.bcancelar.addActionListener(this);
    }



    ///
    public void cleanTable(){
        vista.modelo.setRowCount(0);
    }



    public void searchByIndexNivel(){
        vista.modelo.setRowCount(0);
        uss = modelo.findByNivel(vista.nivelesUsuarios.getSelectedIndex());
        Object filanivel2[] = new Object[6];
        for (int i = 0; i < uss.size(); i++) {
            filanivel2[0] = uss.get(i).getCodigo();
            filanivel2[1] = uss.get(i).getNivel();
            filanivel2[2] = uss.get(i).getNombre();
            filanivel2[3] = uss.get(i).getCorreo();
            filanivel2[4] = uss.get(i).getContraseña();
            filanivel2[5] = false;
            vista.modelo.addRow(filanivel2);
        }
    }

    ///

    public boolean tryParseInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.bbuscar) {
            if(!tryParseInt(vista.textCodigo.getText())){
                switch (vista.nivelesUsuarios.getSelectedIndex()){
                    case 0:
                        vista.modelo.setRowCount(0);
                        uss = modelo.findAll();
                        System.out.println(uss.get(0).getCodigo());
                        Object fila[] = new Object[6];
                        for (int i = 0; i < uss.size(); i++) {
                            fila[0] = uss.get(i).getCodigo();
                            fila[1] = uss.get(i).getNivel();
                            fila[2] = uss.get(i).getNombre();
                            fila[3] = uss.get(i).getCorreo();
                            fila[4] = uss.get(i).getContraseña();
                            fila[5] = false;
                            vista.modelo.addRow(fila);
                        }
                        break;
                    case 1:
                        searchByIndexNivel();
                        break;
                    case 2:
                        searchByIndexNivel();
                        break;
                    case 3:
                        searchByIndexNivel();
                        break;
                    default:
                        System.out.println("esta accion es imposible broder");
                        break;

                }
            } else {
                vista.modelo.setRowCount(0);
                Usuario usur= modelo.find(Integer.parseInt(vista.textCodigo.getText()));
                Object fila[] = new Object[6];
                fila[0] = usur.getCodigo();
                fila[1] = usur.getNivel();
                fila[2] = usur.getNombre();
                fila[3] = usur.getCorreo();
                fila[4] = usur.getContraseña();
                fila[5] = false;
                vista.modelo.addRow(fila);

            }

        }
        if(e.getSource() == vista.beliminarSeleccionados){
            eliminarCheckbox();
            cleanTable();
            
        }
        if(e.getSource() == vista.bcancelar){
            vista.dispose();
        }
    }

    public void eliminarCheckbox(){

        for(int i = 0; i < vista.modelo.getRowCount(); i++){
            boolean cond = (boolean)vista.modelo.getValueAt(i, 5);
            if(cond){
                us.setCodigo((int)vista.modelo.getValueAt(i, 0)) ;
                modelo.DeleteCheck(us);

            }
        }


    }

}
