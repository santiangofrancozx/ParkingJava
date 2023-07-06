package Vista.Vehicles;

import javax.swing.*;
import java.awt.*;

public class IngresoVehiculo extends JDialog {

    JLabel LabelUsuarios, placaFormat;
    JButton bMostrarTodos, bMostrar, bValidar, bCancelar;
    JTextField textPlacaFormat;
    JTextArea areaCupos;
    JComboBox<String> nivelesUsuarios;
    JScrollPane scrollBar;




    public IngresoVehiculo(Frame papa, boolean modal){
        super(papa, modal);
        String []niveles = {"Todos", "Nivel 1", "Nivel 2", "Nivel 3"};
        setTitle("Ingreso vehiculos");


        areaCupos = new JTextArea(10, 20);
        areaCupos.setBounds(50, 100, 600, 150);
        scrollBar = new JScrollPane(areaCupos, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollBar.setBounds(50, 100, 600, 150);

        bMostrar = new JButton("Mostrar");
        bMostrar.setBounds(300, 30, 100, 30);

        LabelUsuarios = new JLabel("Usuarios:");
        LabelUsuarios.setBounds(50, 30, 100, 30);


        bMostrarTodos = new JButton("Mostrar Todos");
        bMostrarTodos.setBounds(400, 30, 200, 30);

        bValidar = new JButton("Validar");
        bValidar.setBounds(450, 280, 100, 30);

        bCancelar = new JButton("Cancelar");
        bCancelar.setBounds(280, 330, 100, 30);

        textPlacaFormat = new JTextField(10);
        textPlacaFormat.setBounds(220, 280, 200, 30);


        nivelesUsuarios = new JComboBox<>(niveles);
        nivelesUsuarios.setBounds(140, 30, 100, 30);

        placaFormat = new JLabel("V-P-PLACA-HE-ME");
        placaFormat.setBounds(80, 280, 200, 30);


        add(LabelUsuarios);
        add(nivelesUsuarios);
        add(bMostrar);
        add(bMostrarTodos);
        add(scrollBar);
        add(bValidar);
        add(bCancelar);
        add(placaFormat);
        add(textPlacaFormat);




        setSize(700,400);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);


    }

    /*public static void main(String[] args) {
        new IngresoVehiculo(null, true);
    }*/

}
