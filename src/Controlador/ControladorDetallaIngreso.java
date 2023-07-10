package Controlador;

import Modelo.ConsultasFactura;
import Modelo.ConsultasIngresoVehiculos;
import Modelo.ConsultasTarifas;
import Modelo.ObjetoIngreso;
import Vista.Vehicles.DetalleIngreso;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorDetallaIngreso implements ActionListener {
    DetalleIngreso vista;
    ObjetoIngreso obj = new ObjetoIngreso();
    ConsultasIngresoVehiculos modelo = new ConsultasIngresoVehiculos();
    ConsultasFactura modelo2 = new ConsultasFactura();
    ConsultasTarifas modeloT = new ConsultasTarifas();

    public ControladorDetallaIngreso(DetalleIngreso vista, ObjetoIngreso obj){
        this.obj = obj;
        this.vista = vista;

        this.vista.guardar.addActionListener(this);
        this.vista.cancelar.addActionListener(this);

        this.vista.setSize(300, 300);
        this.vista.setLayout(null);
        this.vista.setLocationRelativeTo(null);


        this.vista.plate.setText(obj.getPlaca());
        this.vista.vehicle.setText(obj.getTipo());
        this.vista.hour.setText(obj.getHe()+"");
        this.vista.min.setText(obj.getMe()+"");

        this.vista.setVisible(true);

    }

    public boolean convertirAInt(String valor) {
        try {
            Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.cancelar)
            vista.dispose();
        if(e.getSource() == vista.guardar){
            if(convertirAInt(vista.nameClient.getText())){
                obj.setCodigo(Integer.parseInt(vista.nameClient.getText()));
                obj.setValorHora(modeloT.findTarifa(obj.getTipo()));
                System.out.println(obj.getValorHora());

                modelo.insert(obj);
                modelo2.insert(obj);
            }
        }
    }
}
