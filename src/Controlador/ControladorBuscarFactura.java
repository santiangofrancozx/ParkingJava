package Controlador;

import Modelo.ConsultasFactura;
import Modelo.ConsultasUsuarios;
import Modelo.ObjetoFactura;
import Modelo.Usuario;
import Vista.Vehicles.BuscarFactura;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorBuscarFactura implements ActionListener {
    BuscarFactura vista;
    ConsultasFactura modelo = new ConsultasFactura();
    ConsultasUsuarios modelUs = new ConsultasUsuarios();
    ObjetoFactura obj = new ObjetoFactura();

    public ControladorBuscarFactura(BuscarFactura vista){
        this.vista = vista;
        this.vista.buscar.addActionListener(this);
        this.vista.cancelar.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("algo paxo");
        if (e.getSource() == vista.cancelar){
            System.out.println("cancelar");
            vista.dispose();
        }

        /*if(e.getSource() == vista.buscar){
            System.out.println("entre en buscar");
            int codeFactura;
            if (esConvertibleADouble(vista.NoFacturaText.getText())){
                codeFactura = Integer.parseInt(vista.NoFacturaText.getText());
                ObjetoFactura objFac = modelo.findByCode(codeFactura);
                vista.vehiculoText.setText(objFac.getTipo());
                Usuario user = modelUs.find(objFac.getCodigo());
                vista.nombreClienteText.setText(user.getCodigo()+"");
                vista.placaText.setText(objFac.getPlaca());
                vista.horaEntradaText.setText(objFac.getHe()+"");
                vista.minEntradaText.setText(objFac.getMe()+"");
                vista.horaSalidaText.setText(objFac.getHs()+"");
                vista.minSalidaText.setText(objFac.getMs()+"");
                vista.valorHoraText.setText(objFac.getValorHoras()+"");
                vista.horasText.setText(objFac.getHoras()+"");
                vista.totalPagarText.setText(objFac.getTotal()+"");
            }
        }*/
    }

    public boolean esConvertibleADouble(String valor) {
        try {
            Double.parseDouble(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }



}
