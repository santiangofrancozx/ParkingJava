package Vista.Vehicles;

import javax.swing.*;
import java.awt.*;

public class DetalleIngreso extends JDialog {

    JLabel vehiculo, placa, horaEntrada, minutoEntrada, nombreCliente;
    JTextField vehicle, plate, hour, min, nameClient;
    JButton guardar, cancelar;


    public DetalleIngreso(Frame papa, boolean modal){

        setTitle("Detalle Ingreso");
        //labels
        vehiculo = new JLabel("Vehiculo");
        vehiculo.setBounds(20, 30, 100, 20);

        placa = new JLabel("Placa");
        placa.setBounds(20, 60, 100, 20);

        horaEntrada = new JLabel("Hora entrada");
        horaEntrada.setBounds(20, 90, 100, 20);

        minutoEntrada = new JLabel("Minuto entrada");
        minutoEntrada.setBounds(20, 120, 100, 20);

        nombreCliente = new JLabel("Nombre Cliente");
        nombreCliente.setBounds(20, 150, 100, 20);

        //text fields
        vehicle = new JTextField(10);
        vehicle.setBounds(150, 30, 150, 20);

        plate = new JTextField(10);
        plate.setBounds(150, 60, 150, 20);

        hour = new JTextField(10);
        hour.setBounds(150, 90, 150, 20);

        min = new JTextField(10);
        min.setBounds(150, 120, 150, 20);

        nameClient = new JTextField(10);
        nameClient.setBounds(150, 150, 150, 20);
        //buttons
        guardar = new JButton("Guardar");
        guardar.setBounds(80, 180, 100, 30);

        cancelar = new JButton("Cancelar");
        cancelar.setBounds(190, 180, 100, 30);

        //add ventana
        add(vehiculo);
        add(vehicle);
        add(placa);
        add(plate);
        add(horaEntrada);
        add(hour);
        add(minutoEntrada);
        add(min);
        add(nombreCliente);
        add(nameClient);
        add(guardar);
        add(cancelar);




    }

   
}
