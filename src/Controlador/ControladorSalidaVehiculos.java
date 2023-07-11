/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.*;
import Vista.Vehicles.BuscarFactura;
import Vista.Vehicles.DetalleIngreso;
import Vista.Vehicles.SalidaVehiculo;
import Vista.Vehicles.ValidarSalida;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorSalidaVehiculos implements ActionListener {

    SalidaVehiculo salidave;
    ObjetoFactura objF = new ObjetoFactura();
    ValidarSalida valSal;
    ConsultasUsuarios conUsu = new ConsultasUsuarios();
    ConsultasIngresoVehiculos conIngreV = new ConsultasIngresoVehiculos();
    ConsultasFactura consFac = new ConsultasFactura();

    public ControladorSalidaVehiculos(SalidaVehiculo salidave, ValidarSalida valSal) {
        this.salidave = salidave;
        this.valSal = valSal;
        this.salidave.validar.addActionListener(this);
        this.salidave.cancelar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == salidave.validar) {
            ValidarFormato();
        }
        if (e.getSource() == salidave.cancelar) {
            salidave.dispose();
        }
    }

    public void ValidarFormato() {
        int totalHoras,  totalMinu;

        System.out.println("entro");
        String[] bloques = salidave.formatoIngresar.getText().split("-");
        ObjetoFactura objF = new ObjetoFactura();

        if (bloques.length == 4) {
            String tVehiculo = bloques[0];
            String placa = bloques[1];
            int horaSalida = Integer.parseInt(bloques[2]);
            int minutosSalida = Integer.parseInt(bloques[3]);

            objF = consFac.findByPlate2(placa);
            objF.setHs(horaSalida);
            objF.setMs(minutosSalida);



            if (objF.getHs() > objF.getHe()) {
                System.out.println("cumple horas");
                if (objF.getMs() >= objF.getMe()) {
                    objF.setHoras(objF.getHs() - objF.getHe());
                    totalMinu = objF.getMs() - objF.getMe();
                    System.out.println("cumple");
                    System.out.println(objF.getHoras());

                } else {
                    totalHoras = objF.getHs() - objF.getMs() - 1;
                    totalMinu = 60 - objF.getMs() - objF.getMe();

                }

                //objF.setHoras(totalHoras);
                objF.setMinutos(totalMinu);

            }

            consFac.update2(objF, placa);

            boolean formatoPlaca = false;
            boolean placaAsignada = false;

            //CARRO
            if (tVehiculo.equals("c") || tVehiculo.equals("C")) {
                for (int i = 0; i < conIngreV.findByPlate().size(); i++) {
                    System.out.println(conIngreV.findByPlate().get(i).getPlaca());

                    if (placa.equals(conIngreV.findByPlate().get(i).getPlaca())) {
                        placaAsignada = true;
                        break;
                    }
                }

                if (placaAsignada) {
                    formatoPlaca = placa.matches("[A-Za-z]{3}\\d{3}");

                } else {
                    System.out.println("error");
                }

                //MOTOS
            } else if (tVehiculo.equals("m") || tVehiculo.equals("M")) {
                formatoPlaca = placa.matches("[A-Za-z]{3}\\d{2}[A-Za-z]");

                //BICICLETA
            } else if (tVehiculo.equals("b") || tVehiculo.equals("B")) {
                formatoPlaca = placa.equals("0000");

            }

            boolean horaValida = horaSalida >= 0 && horaSalida <= 23;
            boolean minutosValidos = minutosSalida >= 0 && minutosSalida <= 59;

            if (formatoPlaca && horaValida && minutosValidos) {
                salidave.dispose();

                System.out.println(conUsu.find(objF.getCodigo()).getNombre());
                System.out.println(objF.getCodigo());
                valSal.vehiculoText.setText(objF.getTipo());
                valSal.nombreClienteText.setText(conUsu.find(objF.getCodigo()).getNombre());
                valSal.placaText.setText(objF.getPlaca());
                valSal.horaEntradaText.setText(objF.getHe() + "");
                valSal.minEntradaText.setText(objF.getMe() + "");
                valSal.horaSalidaText.setText(objF.getHs() + "");
                valSal.minSalidaText.setText(objF.getMs() + "");

                /*
                objF.getTotal() + ""
                */
                double valorHoras = objF.getValorHoras();
                int horas = objF.getHoras();
                objF.setTotal(horas*valorHoras);
                System.out.println(objF.getTotal());
                System.out.println(horas*valorHoras);

                valSal.horasText.setText(horas*valorHoras+"");
                System.out.println(objF.getHoras());
                valSal.totalPagarText.setText(objF.getHoras() + "");
                valSal.valorHoraText.setText(objF.getValorHoras() + "");

                DetalleSalida();
                System.out.println("melo");


            } else {
                JOptionPane.showMessageDialog(null, "formato incorrecto");
                salidave.formatoIngresar.setText("");
            }
        }

    }

    public void DetalleSalida() {
        valSal.setSize(320, 450);
        valSal.setLayout(null);
        valSal.setResizable(false);
        valSal.setLocationRelativeTo(null);
        valSal.setVisible(true);
    }

}
