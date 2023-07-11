package Controlador;

import Modelo.ConsultasFactura;
import Modelo.ConsultasIngresoVehiculos;
import Modelo.ConsultasUsuarios;
import Modelo.ObjetoFactura;
import Vista.Vehicles.ValidarSalida;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorValidarSalida implements ActionListener {
    ValidarSalida vista;
    ConsultasFactura modelo =new ConsultasFactura();
    ConsultasUsuarios modelu = new ConsultasUsuarios();
    ConsultasIngresoVehiculos consuIng = new ConsultasIngresoVehiculos();
    ObjetoFactura obj = new ObjetoFactura();


    public ControladorValidarSalida(ValidarSalida vista){
        this.vista = vista;
        this.vista.cancelar.addActionListener(this);
        this.vista.guardar.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.cancelar){
            vista.dispose();
        }

        if (e.getSource() == vista.guardar){
            obj.setTipo(vista.vehiculoText.getText());
            obj.setPlaca(vista.placaText.getText());
            //obj.setCodigo(modelu.find());
            obj.setHe(Integer.parseInt(vista.horaEntradaText.getText()));
            obj.setMe(Integer.parseInt(vista.minEntradaText.getText()));
            obj.setHs(Integer.parseInt(vista.horaSalidaText.getText()));
            obj.setMs(Integer.parseInt(vista.minSalidaText.getText()));
            obj.setValorHoras(Double.parseDouble(vista.valorHoraText.getText()));
            vista.totalPagarText.getText().split(":");
            String[] tarifasString = vista.totalPagarText.getText().split(":");
            //int horas = Integer.parseInt(tarifasString[0]);
            //obj.setHoras(horas);
            obj.setTotal(Double.parseDouble(vista.horasText.getText()));
            System.out.println("total a enviar a db: " + vista.horasText.getText());
            modelo.updateByPlaca(obj, obj.getPlaca());
            consuIng.deleteByPlate(obj.getPlaca());

            vista.dispose();
        }

    }
}
