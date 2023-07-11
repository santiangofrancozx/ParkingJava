/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.*;
import Vista.Vehicles.ModificarRegistros;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.*;

public class ControladorModificarRegistros implements ActionListener {

    ModificarRegistros vista;
    ConsultasFactura modelo = new ConsultasFactura();
    ConsultasFactura models = new ConsultasFactura();
    ConsultasUsuarios modeloUs = new ConsultasUsuarios();
    ConsultasTarifas tar = new ConsultasTarifas();
    Usuario us = new Usuario();
    ObjetoFactura obj = new ObjetoFactura();
    ArrayList<ObjetoFactura> objS = new ArrayList<>();

    public ControladorModificarRegistros(ModificarRegistros vista) {
        this.vista = vista;
        this.vista.bbuscar.addActionListener(this);
        this.vista.bcancelar.addActionListener(this);
        this.vista.bmodificarSele.addActionListener(this);

    }

    public void cleanTable() {
        vista.modelo.setRowCount(0);
    }

    public void enableEditableColumns() {
        // Especificar las columnas editables
        int[] editableColumns = {1, 2, 3, 4, 5, 7};
        for (int col : editableColumns) {
            vista.tablaUsuarios.getColumn(vista.tablaUsuarios.getColumnName(col)).setCellEditor(new DefaultCellEditor(new JTextField()));
        }
    }

    public void tableSearcher(ObjetoFactura obj) {
        Object filaPlate[] = new Object[11];
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
        enableEditableColumns();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.bcancelar) {
            vista.dispose();
        }

        if (e.getSource() == vista.bbuscar) {
            Buscar();
            enableEditableColumns();
        }
        if (e.getSource() == vista.bmodificarSele) {
            modificarCheckbox();
        }
    }

    public void Buscar() {
        us = modeloUs.find(obj.getCodigo());
        if (vista.nivelesUsuarios.getSelectedIndex() == 0) {
            System.out.println("entre 0");
            cleanTable();
            obj = modelo.findByPlate2(vista.testSearch.getText());
            tableSearcher(obj);

        } else if (vista.nivelesUsuarios.getSelectedIndex() == 1) {
            System.out.println("entre 1");
            cleanTable();
            obj = modelo.findByCode(Integer.parseInt(vista.testSearch.getText()));
            tableSearcher(obj);

        } else if (vista.nivelesUsuarios.getSelectedIndex() == 2) {
            System.out.println("entre 2");
            objS = modelo.findAll();
            System.out.println("Tamaño de objS: " + objS.size());
            cleanTable();
            for (int i = 0; i < objS.size(); i++) {
                Object filaPlate[] = new Object[11];
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

    public void Modificar() {
        int ContadorFila = vista.modelo.getRowCount();
        int ContadorColumna = vista.modelo.getColumnCount();
        for (int i = 0; i < vista.modelo.getRowCount(); i++) {
            boolean cond = (boolean) vista.modelo.getValueAt(i, 10);
            if (cond) {
                /*us.setCodigo((int)vista.modelo.getValueAt(i, 0)) ;
                    modelo.DeleteCheck(us);*/
                System.out.println("selecciono bien");

            }
        }
    }

    public ArrayList<ObjetoFactura> modificarCheckbox() {
        ObjetoFactura objFact = new ObjetoFactura();
        ArrayList<ObjetoFactura> arr = new ArrayList();

        for (int i = 0; i < vista.modelo.getRowCount(); i++) {
            Object value = vista.modelo.getValueAt(i, 10);
            boolean cond = (value != null) && (boolean) value;
            if (cond) {
                if (cond) {
                    String tipo = vista.modelo.getValueAt(i, 1).toString();
                    String placa = vista.modelo.getValueAt(i, 2).toString();
                    String horaEntrada = vista.modelo.getValueAt(i, 4).toString();
                    String horaSalida = vista.modelo.getValueAt(i, 5).toString();

                    // Verificar formato de placa
                    if (placa.matches("[A-Za-z]{3}[0-9]{3}") || placa.matches("[A-Za-z]{3}[0-9]{3}[A-Za-z]{1}") || placa.equals("0000")) {
                        // Verificar tipo y placa
                        if ((tipo.equals("b") && placa.equals("0000")) || (tipo.equals("c") && placa.matches("[A-Za-z]{3}[0-9]{3}")) || (tipo.equals("m") && placa.matches("[A-Za-z]{3}[0-9]{1}[A-Za-z]{1}"))) {
                            // Verificar formato de hora
                            if (horaEntrada.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]") && horaSalida.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]")) {
                                // Verificar horaSalida mayor que horaEntrada
                                if (horaSalida.compareTo(horaEntrada) > 0) {
                                    System.out.println("Placa, tipo y horas válidas");
                                    obj.setTipo(tipo);
                                    obj.setPlaca(placa);
                                    obj.setHe(Integer.parseInt(horaEntrada.split(":")[0]));
                                    obj.setHs(Integer.parseInt(horaSalida.split(":")[0]));
                                    obj.setMe(Integer.parseInt(horaEntrada.split(":")[1]));
                                    obj.setMs(Integer.parseInt(horaSalida.split(":")[1]));
                                    obj.setHoras(Integer.parseInt(horaSalida.split(":")[0]) - Integer.parseInt(horaEntrada.split(":")[0]));
                                  
                                    //
                                    int minutosSalida = Integer.parseInt(horaSalida.split(":")[1]);
                                    double horas = (obj.getHs() - obj.getHe()) + (obj.getMs() - obj.getMe()) / 60.0;
                                    DecimalFormat formato = new DecimalFormat("#.##");

                                    double truncado = Double.parseDouble(formato.format(horas).replace(",", "."));

                                    //
                                    
                                    double tarifa = tar.findTarifa(obj.getTipo());
                                    obj.setTotal(tarifa * truncado);
                                    System.out.println(obj.getPlaca());
                                    models.update3(obj, Integer.parseInt(vista.modelo.getValueAt(i, 0).toString()));
                                } else {
                                    System.out.println("La hora de salida debe ser mayor a la hora de entrada");

                                }
                            } else {
                                System.out.println("Formato de horas no válido iteracion no." + i);
                            }
                        } else {
                            System.out.println("El tipo no coincide con el formato de la placa iteracion no. " + i);
                        }
                    } else {
                        System.out.println("Formato de placa no válido iteracion no. " + i);
                    }
                }

            }

        }
        return arr;
    }

}
