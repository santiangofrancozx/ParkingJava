package Controlador;

import Modelo.ConsultasIngresoVehiculos;
import Modelo.ObjetoIngreso;
import Vista.Vehicles.DetalleIngreso;
import Vista.Vehicles.IngresoVehiculo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class COntroladorIngresoVehiculo implements ActionListener {
    IngresoVehiculo vista;
    ObjetoIngreso vehiculo = new ObjetoIngreso();
    ConsultasIngresoVehiculos ingC = new ConsultasIngresoVehiculos();
    public String[] carros2 = {" 1", "  2", "  3", "  4", "  5", "  6", "  7", "  8", "  9", "10"};
    public String[] motos2 = {"11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
    public String[] bicicletas2 = {"21", "22", "23", "24", "25"};


    public String updateMM(){

        String M = "";
        for(int i = 0; i < carros2.length; i++){
            M += carros2[i] + "    ";
        }
        M += "\n\n";
        for(int i = 0; i < motos2.length; i++){
            M += motos2[i] + "    ";
        }
        M += "\n\n";
        for(int i = 0; i < bicicletas2.length; i++){
            M += bicicletas2[i] + "    ";
        }
        return M;
    }



    public COntroladorIngresoVehiculo(IngresoVehiculo vista){

        this.vista = vista;
        this.vista.bValidar.addActionListener(this);
        this.vista.bMostrarTodos.addActionListener(this);
        this.vista.bMostrar.addActionListener(this);
        this.vista.bCancelar.addActionListener(this);
    }

    public ObjetoIngreso ValidarFormato() {
        System.out.println("entro");
        String[] bloques = vista.textPlacaFormat.getText().split("-");
        ObjetoIngreso obj = new ObjetoIngreso();

        if (bloques.length == 5) {
            String tVehiculo = bloques[0];
            String puesto = bloques[1];
            String placa = bloques[2];
            int horaEntrada = Integer.parseInt(bloques[3]);
            int minutosEntrada = Integer.parseInt(bloques[4]);
            obj.setPlaca(placa);
            obj.setTipo(tVehiculo);
            obj.setHe(horaEntrada);
            obj.setMe(minutosEntrada);
            obj.setPuesto(Integer.parseInt(puesto));

            boolean formatoPlaca = false;
            if (tVehiculo.equals("c") || tVehiculo.equals("C")) {
                if(Integer.parseInt(puesto) > 0 && Integer.parseInt(puesto) <= 10){
                    formatoPlaca = placa.matches("[A-Za-z]{3}\\d{3}");
                }

            } else if (tVehiculo.equals("m")|| tVehiculo.equals("M")) {
                if(Integer.parseInt(puesto) > 10 && Integer.parseInt(puesto) <= 20){
                    formatoPlaca = placa.matches("[A-Za-z]{3}\\d{2}[A-Za-z]");
                }

            } else if (tVehiculo.equals("b") || tVehiculo.equals("B")) {
                if(Integer.parseInt(puesto) > 20 && Integer.parseInt(puesto) <= 25){
                    formatoPlaca = placa.equals("0000");
                }
            }

            boolean horaValida = horaEntrada >= 0 && horaEntrada <= 23;
            boolean minutosValidos = minutosEntrada >= 0 && minutosEntrada <= 59;

            boolean retu = ingC.isPuestoOcupado(Integer.parseInt(puesto));
            System.out.println(!retu);


            if (formatoPlaca && horaValida && minutosValidos && !retu) {
                vista.dispose();
                DetalleIngreso vistaIngreso = new DetalleIngreso(null, true);
                ControladorDetallaIngreso cdIng = new ControladorDetallaIngreso(vistaIngreso, obj);
                return obj;

            } else {
                JOptionPane.showMessageDialog(null, "formato incorrecto");
                vista.textPlacaFormat.setText("");
            }
        }
        return obj;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.bMostrarTodos) {
            System.out.println("detecte mostrar todos");
            ConsultasIngresoVehiculos consul = new ConsultasIngresoVehiculos();
            ArrayList<ObjetoIngreso> vehiculos = consul.findAll();

            for (ObjetoIngreso vehiculo : vehiculos) {
                System.out.println("entre al bucle");
                int puesto = vehiculo.getPuesto();

                if (puesto >= 1 && puesto <= 10) {
                    vista.carros[puesto - 1] = "c";
                    vista.areaCupos.setText(vista.updateM());
                } else if (puesto > 10 && puesto <= 20) {
                    vista.motos[puesto - 11] = "m";
                    vista.areaCupos.setText(vista.updateM());
                } else if (puesto > 20 && puesto <= 25) {
                    vista.bicicletas[puesto - 21] = "b";
                    vista.areaCupos.setText(vista.updateM());
                }

                System.out.println(puesto);
            }
            vista.setVisible(true);
        }

        if(e.getSource() == vista.bMostrar){
            //motos
            if(vista.nivelesUsuarios.getSelectedIndex() == 0){
                System.out.println(updateMM());
                System.out.println("detecte mostrar nivel m");
                ConsultasIngresoVehiculos consul = new ConsultasIngresoVehiculos();
                ArrayList<ObjetoIngreso> vehiculos = consul.findByTipo("m");

                for (ObjetoIngreso vehiculo : vehiculos) {
                    System.out.println("entre al bucle");
                    int puesto = vehiculo.getPuesto();

                    if (puesto > 10 && puesto <= 20) {
                        //vista.motos[puesto - 11] = "m"

                        motos2[puesto - 11] = "m";
                        carros2 = vista.carros;
                        bicicletas2 = vista.bicicletas;
                        vista.areaCupos.setText(updateMM());
                        break;
                    }
                }
                //carros
            } else if(vista.nivelesUsuarios.getSelectedIndex() == 1){
                System.out.println(updateMM());
                System.out.println("detecte mostrar nivel c");
                ConsultasIngresoVehiculos consul = new ConsultasIngresoVehiculos();
                ArrayList<ObjetoIngreso> vehiculos = consul.findByTipo("c");

                for (ObjetoIngreso vehiculo : vehiculos) {
                    System.out.println("entre al bucle");
                    int puesto = vehiculo.getPuesto();

                    if (puesto >= 1 && puesto <= 10) {
                        //vista.carros[puesto - 1] = "c";
                        carros2[puesto - 1] = "c";
                        bicicletas2 = vista.bicicletas;
                        motos2 = vista.motos;
                        vista.areaCupos.setText(updateMM());
                        break;
                    }
                }
                //bicicletas
            } else if(vista.nivelesUsuarios.getSelectedIndex() == 2){
                System.out.println(updateMM());
                System.out.println("detecte mostrar nivel b");
                ConsultasIngresoVehiculos consul = new ConsultasIngresoVehiculos();
                ArrayList<ObjetoIngreso> vehiculos = consul.findByTipo("b");

                for (ObjetoIngreso vehiculo : vehiculos) {
                    System.out.println("entre al bucle");
                    int puesto = vehiculo.getPuesto();

                    if (puesto > 20 && puesto <= 25) {
                        //vista.bicicletas[puesto - 21] = "b";
                        bicicletas2[puesto - 22] = "b";
                        carros2 = vista.carros;
                        motos2 = vista.motos;
                        vista.areaCupos.setText(updateMM());
                        break;
                    }
                }
            }
            vista.setVisible(true);
        }

        if(e.getSource() == vista.bCancelar){
            vista.dispose();
        }

        if (e.getSource() == vista.bValidar) {
            ObjetoIngreso obj = ValidarFormato();
        }

    }
}