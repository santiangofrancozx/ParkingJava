package Vista.Users;

import javax.swing.*;
import java.awt.*;

public class Eliminar extends JDialog {

    JLabel LabelUsuarios, LabelCodigo;
    JButton bbuscar, beliminarSeleccionados, bcancelar;
    JTextField textCodigo;
    JTable tablaUsuarios;
    JComboBox<String> nivelesUsuarios;



    public Eliminar(Frame papa, boolean modal){
        super(papa, modal);
        String []niveles = {"Todos", "Nivel 1", "Nivel 2", "Nivel 3"};
        setTitle("Eliminar Usuario");

        LabelUsuarios = new JLabel("Usuarios:");
        LabelUsuarios.setBounds(50, 30, 100, 30);

        LabelCodigo = new JLabel("Codigo:");
        LabelCodigo.setBounds(260, 30, 100, 30);

        bbuscar = new JButton("Buscar");
        bbuscar.setBounds(560, 30, 100, 30);

        beliminarSeleccionados = new JButton("Eliminar Seleccionados");
        beliminarSeleccionados.setBounds(80, 280, 200, 30);

        bcancelar = new JButton("Cancelar");
        bcancelar.setBounds(400, 280, 200, 30);

        textCodigo = new JTextField(20);
        textCodigo.setBounds(350, 30, 200, 30);

        tablaUsuarios = new JTable();
        tablaUsuarios.setBounds(50, 100, 600, 150);

        nivelesUsuarios = new JComboBox<>(niveles);
        nivelesUsuarios.setBounds(140, 30, 100, 30);


        add(LabelUsuarios);
        add(nivelesUsuarios);
        add(LabelCodigo);
        add(textCodigo);
        add(bbuscar);
        add(tablaUsuarios);
        add(beliminarSeleccionados);
        add(bcancelar);




        /*setSize(700,370);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);*/



    }

}
