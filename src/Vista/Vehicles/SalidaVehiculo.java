package Vista.Vehicles;

import javax.swing.*;
import java.awt.*;

public class SalidaVehiculo extends JDialog {

    JLabel format;
    JTextField formatoIngresar;
    JButton validar, cancelar;

    public SalidaVehiculo(Frame papa, boolean modal){
        super(papa, modal);

        setTitle("Salida Vehiculo");

        format = new JLabel("V-PLACA-HS-MS");
        format.setBounds(20, 20, 150, 30);
        formatoIngresar = new JTextField(20);
        formatoIngresar.setBounds(150, 20, 150, 30);
        validar = new JButton("Validar");
        validar.setBounds(40, 70, 100, 30);
        cancelar = new JButton("Cancelar");
        cancelar.setBounds(180, 70, 100, 30);

        add(format);
        add(formatoIngresar);
        add(validar);
        add(cancelar);




        setLayout(null);
        setSize(320, 200);
        setLocationRelativeTo(null);
        //setResizable(true);
        setVisible(true);


    }

    /*public static void main(String[] args) {
        new SalidaVehiculo(null, true);
    }*/
}
