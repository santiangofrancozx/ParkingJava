/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.Vehicles;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class ModificarRegistros extends JDialog {

    JLabel LabelUsuarios;
    public JButton bbuscar, bcancelar, bmodificarSele;
    public JTextField testSearch;
    public JTable tablaUsuarios;
    public JScrollPane scroll;
    public DefaultTableModel modelo;

    public JComboBox<String> nivelesUsuarios;

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
        tablaUsuarios.setDefaultEditor(Object.class, new DefaultCellEditor(new JTextField()));
        tablaUsuarios.setBounds(50, 100, 600, 150);

        nivelesUsuarios = new JComboBox<>(niveles);
        nivelesUsuarios.setBounds(140, 30, 100, 30);



        modelo = new DefaultTableModel();
        modelo.addColumn("Factura");
        modelo.addColumn("Vehiculo");
        modelo.addColumn("Placa");
        modelo.addColumn("Cliente");
        modelo.addColumn("H_Entrada");
        modelo.addColumn("H_Salida");
        modelo.addColumn("Horas");
        modelo.addColumn("Valor_Horas");
        modelo.addColumn("Total");
        modelo.addColumn("Empleado");
        modelo.addColumn("Modificar");

        tablaUsuarios = new JTable(modelo) {
            public Class<?> getColumnClass(int column) {
                if (column == 10) {
                    return Boolean.class;
                }
                return super.getColumnClass(column);
            }

            public TableCellRenderer getCellRenderer(int row, int column) {
                if (column == 10) {
                    return getDefaultRenderer(Boolean.class);
                }
                return super.getCellRenderer(row, column);
            }

            public boolean isCellEditable(int row, int column) {
                return column == 10;

            }
        };



        //tablaUsuarios.setEditingRow(1);


        scroll = new JScrollPane(tablaUsuarios, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(50, 100, 650, 150);

        add(LabelUsuarios);
        add(nivelesUsuarios);
        add(testSearch);
        add(bbuscar);
        add(scroll);
        add(bcancelar);
        add(bmodificarSele);



    }
}