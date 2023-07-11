package Controlador;

import Modelo.*;
import Vista.Vehicles.BuscarRegistros;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControladorBuscarRegistros implements ActionListener {
    BuscarRegistros vista;
    ConsultasFactura modelo = new ConsultasFactura();
    ConsultasUsuarios modeloUs = new ConsultasUsuarios();
    Usuario us = new Usuario();
    ObjetoFactura obj = new ObjetoFactura();
    ArrayList<ObjetoFactura> objS = new ArrayList<>();

    public ControladorBuscarRegistros(BuscarRegistros vista) {
        this.vista = vista;
        this.vista.bbuscar.addActionListener(this);
        this.vista.bcancelar.addActionListener(this);

    }

    public void cleanTable(){
        vista.modelo.setRowCount(0);
    }

    public void tableSearcher(ObjetoFactura obj){
        Object filaPlate[] = new Object[10];
        filaPlate[0] = obj.getCodigio_factura();
        System.out.println(obj.getCodigio_factura());
        filaPlate[1] = obj.getTipo();
        filaPlate[2] = obj.getPlaca();
        filaPlate[3] = us.getNombre();
        filaPlate[4] = obj.getHe() + ":" + obj.getMe();
        filaPlate[5] = obj.getHs() + ":" + obj.getMs();
        filaPlate[6] = obj.getHoras();
        filaPlate[7] = obj.getValorHoras();
        filaPlate[8] = obj.getTotal();
        //filaPlate[9] = "Arreglar el empleado";
        //filaPlate[10] = "check box";
        vista.modelo.addRow(filaPlate);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.bcancelar) {
            vista.dispose();
        }

        if (e.getSource() == vista.bbuscar) {
            us = modeloUs.find(obj.getCodigo());
            if (vista.nivelesUsuarios.getSelectedIndex() == 0) {
                System.out.println("entre 0");
                cleanTable();
                obj = modelo.findByPlate2(vista.testSearch.getText());
                tableSearcher(obj);

            } else if (vista.nivelesUsuarios.getSelectedIndex() == 1){
                System.out.println("entre 1");
                cleanTable();
                obj = modelo.findByCode(Integer.parseInt(vista.testSearch.getText()));
                tableSearcher(obj);

            } else if (vista.nivelesUsuarios.getSelectedIndex() == 2){
                System.out.println("entre 2");
                objS = modelo.findAll();
                System.out.println("Tamaño de objS: " + objS.size());
                cleanTable();
                for (int i  = 0; i <objS.size(); i++){
                    Object filaPlate[] = new Object[10];
                    filaPlate[0] = objS.get(i).getCodigio_factura();
                    System.out.println(obj.getCodigio_factura());
                    filaPlate[1] = objS.get(i).getTipo();
                    filaPlate[2] = objS.get(i).getPlaca();
                    us = modeloUs.find(objS.get(i).getCodigo());
                    filaPlate[3] = us.getNombre();
                    filaPlate[4] = objS.get(i).getHe() + ":" + obj.getMe();
                    filaPlate[5] = objS.get(i).getHs() + ":" + obj.getMs();
                    filaPlate[6] = objS.get(i).getHoras();
                    filaPlate[7] = objS.get(i).getValorHoras();
                    filaPlate[8] = objS.get(i).getTotal();
                    //filaPlate[9] = "Arreglar el empleado";
                    //filaPlate[10] = "check box";
                    vista.modelo.addRow(filaPlate);
                }
            } else {
                JOptionPane.showMessageDialog(null, "busqueda aun no habil");
            }
        }
    }
}
