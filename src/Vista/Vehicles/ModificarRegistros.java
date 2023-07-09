/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.Vehicles;

import javax.swing.*;
import java.awt.*;

public class ModificarRegistros extends JDialog {

    JLabel LabelUsuarios;
    JButton bbuscar, bcancelar, bmodificarSele;
    JTextField testSearch;
    JTable tablaUsuarios;
    JComboBox<String> nivelesUsuarios;

    public ModificarRegistros(Frame papa, boolean modal){
        super(papa, modal);
        String []niveles = {"Placa", "Factura", "Todos", "Empleados"};
        setTitle("Eliminar Usuario");

        LabelUsuarios = new JLabel("Usuarios:");
        LabelUsuarios.setBounds(50, 30, 100, 30);


        bbuscar = new JButton("Buscar");
        bbuscar.setBounds(410, 30, 100, 30);

        bmodificarSele = new JButton("Modificar Seleccionados");
        bmodificarSele.setBounds(180, 270, 200, 30);

        bcancelar = new JButton("Cancelar");
        bcancelar.setBounds(410, 270, 100, 30);



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
        add(bmodificarSele);



    }
}