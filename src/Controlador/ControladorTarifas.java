package Controlador;


import Modelo.*;
import Vista.Vehicles.hourValue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorTarifas implements ActionListener {
    hourValue vista;
    ConsultasTarifas consu = new ConsultasTarifas();
    ConsultasIngresoVehiculos consuIngreso = new ConsultasIngresoVehiculos();
    ConsultasFactura fact = new ConsultasFactura();
    ObjetoTarifas modelo = new ObjetoTarifas();
    public ControladorTarifas(hourValue vista){
        this.vista = vista;
        vista.bGuardar.addActionListener(this);
        vista.bCancelar.addActionListener(this);
    }

    public boolean esConvertibleADouble(String valor) {
        try {
            Double.parseDouble(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.bCancelar){
            vista.dispose();
        }
        if (e.getSource() == vista.bGuardar){
            if(esConvertibleADouble(vista.caja_hBicicleta.getText())){
                modelo.setTipo("b");
                modelo.setValor(Double.parseDouble(vista.caja_hBicicleta.getText()));
                consu.update(modelo);
                fact.update(modelo, "b");
                //consuIngreso.update(modelo);

            }

            if(esConvertibleADouble(vista.caja_hCarro.getText())){
                modelo.setTipo("c");
                modelo.setValor(Double.parseDouble(vista.caja_hCarro.getText()));
                consu.update(modelo);
                fact.update(modelo, "c");
                //consuIngreso.update(modelo);
            }

            if(esConvertibleADouble(vista.caja_hMoto.getText())){
                modelo.setTipo("m");
                modelo.setValor(Double.parseDouble(vista.caja_hMoto.getText()));
                consu.update(modelo);
                fact.update(modelo, "m");
                //consuIngreso.update(modelo);
            }

            vista.caja_hMoto.setText("");
            vista.caja_hCarro.setText("");
            vista.caja_hBicicleta.setText("");
            vista.setVisible(true);

        }

    }

}
