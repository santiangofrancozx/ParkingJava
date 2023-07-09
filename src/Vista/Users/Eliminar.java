package Vista.Users;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Eliminar extends JDialog {

    JLabel LabelUsuarios, LabelCodigo;
    public JButton bbuscar, beliminarSeleccionados, bcancelar;
    public JTextField textCodigo;
    public JTable tablaUsuarios;
    public JScrollPane scroll;

    public JComboBox<String> nivelesUsuarios;
    public Object fila[] = new Object[6];
    public DefaultTableModel modelo;



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


        nivelesUsuarios = new JComboBox<>(niveles);
        nivelesUsuarios.setBounds(140, 30, 100, 30);

        modelo = new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Nivel");
        modelo.addColumn("Nombre");
        modelo.addColumn("Correo");
        modelo.addColumn("Contraseña");
        modelo.addColumn("Eliminar");
        tablaUsuarios = new JTable(modelo);

        scroll = new JScrollPane(tablaUsuarios, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(50, 100, 600, 150);




        add(LabelUsuarios);
        add(nivelesUsuarios);
        add(LabelCodigo);
        add(textCodigo);
        add(bbuscar);
        add(scroll);
        add(beliminarSeleccionados);
        add(bcancelar);


    }

}
