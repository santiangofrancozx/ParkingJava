package Vista.Users;

import javax.swing.*;
import java.awt.*;

public class BuscarRegistros extends JDialog {

    JLabel LabelUsuarios, total;
    JButton bbuscar, bcancelar;
    JTextField testSearch, totalText;
    JTable tablaUsuarios;
    JComboBox<String> nivelesUsuarios;

    public BuscarRegistros(Frame papa, boolean modal){
        super(papa, modal);
        String []niveles = {"Placa", "Factura", "Todos", "Empleados"};
        setTitle("Eliminar Usuario");

        LabelUsuarios = new JLabel("Usuarios:");
        LabelUsuarios.setBounds(50, 30, 100, 30);


        bbuscar = new JButton("Buscar");
        bbuscar.setBounds(410, 30, 100, 30);

        total = new JLabel("Total:");
        total.setBounds(450, 270, 100, 30);

        bcancelar = new JButton("Cancelar");
        bcancelar.setBounds(300, 300, 100, 30);

        totalText = new JTextField(10);
        totalText.setBounds(550, 270, 100, 30);

        testSearch = new JTextField(20);
        testSearch.setBounds(300, 30, 100, 30);

        tablaUsuarios = new JTable();
        tablaUsuarios.setBounds(50, 100, 600, 150);

        nivelesUsuarios = new JComboBox<>(niveles);
        nivelesUsuarios.setBounds(140, 30, 100, 30);


        add(LabelUsuarios);
        add(nivelesUsuarios);
        add(testSearch);
        add(bbuscar);
        add(tablaUsuarios);
        add(bcancelar);
        add(total);
        add(totalText);




        setSize(700,370);
        setLayout(null);
        setLocationRelativeTo(null);
        //setResizable(false);
        setVisible(true);



    }

    /*public static void main(String[] args) {
        new BuscarRegistros(null, true);
    }*/
}
