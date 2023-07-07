package Vista.Vehicles;

import javax.swing.*;
import java.awt.*;

public class ValorHora extends JDialog {
    JLabel horaCarro, horaMoto, horaBicicleta;
    JTextField horaCarroText, horaMotoText, horaBicicletaText;
    JButton guardar, cancelar;

    public ValorHora(Frame papa, boolean modal){

        setTitle("Valor Hora");

        //labels
        horaCarro = new JLabel("Hora Carro");
        horaCarro.setBounds(20, 20, 100, 20);

        horaMoto = new JLabel("Hora Moto");
        horaMoto.setBounds(20, 50, 100, 20);

        horaBicicleta = new JLabel("Hora Bicicleta");
        horaBicicleta.setBounds(20, 80, 100, 20);

        //text fields

        horaCarroText = new JTextField(10);
        horaCarroText.setBounds(140,20,120,20);

        horaMotoText = new JTextField(10);
        horaMotoText.setBounds(140,50,120,20);

        horaBicicletaText = new JTextField(10);
        horaBicicletaText.setBounds(140,80,120,20);


        //buttons
        guardar = new JButton("Guardar");
        guardar.setBounds(40, 120, 80, 20);

        cancelar = new JButton("Cancelar");
        cancelar.setBounds(150, 120, 80, 20);

        //add

        add(horaCarro);
        add(horaCarroText);
        add(horaMoto);
        add(horaMotoText);
        add(horaBicicleta);
        add(horaBicicletaText);
        add(guardar);
        add(cancelar);







        setLayout(null);
        //setResizable(false);
        setLocationRelativeTo(null);
        setSize(300, 200);
        setVisible(true);


    }

    /*public static void main(String[] args) {
        new ValorHora(null, true);
    }*/
}
