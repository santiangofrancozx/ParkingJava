package Vista.Vehicles;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class BuscarRegistros extends JDialog {

    JLabel LabelUsuarios, total;
    public JButton bbuscar, bcancelar;
    public JTextField testSearch, totalText;
    public JTable tablaUsuarios;
    public JComboBox<String> nivelesUsuarios;
    public DefaultTableModel modelo;
    public JScrollPane scroll;
    public Object fila[] = new Object[10];

    public BuscarRegistros(Frame papa, boolean modal){
        super(papa, modal);
        String []niveles = {"Placa", "Factura", "Todos", "Empleados"};
        setTitle("Buscar Registros");

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
        
        //tablaUsuarios.setBounds(50, 100, 600, 150);

        nivelesUsuarios = new JComboBox<>(niveles);
        nivelesUsuarios.setBounds(140, 30, 100, 30);

        modelo = new DefaultTableModel();
        modelo.addColumn("Factura");
        modelo.addColumn("Vehiculo");
        modelo.addColumn("Placa");
        modelo.addColumn("Cliente");
        modelo.addColumn("Hora Entrada");
        modelo.addColumn("Hora Salida");
        modelo.addColumn("Horas");
        modelo.addColumn("Valor Hora");
        modelo.addColumn("Total");
        modelo.addColumn("Empleado");

        tablaUsuarios = new JTable(modelo);


        scroll = new JScrollPane(tablaUsuarios, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(50, 100, 600, 150);


        add(LabelUsuarios);
        add(nivelesUsuarios);
        add(testSearch);
        add(bbuscar);
        add(scroll);
        add(bcancelar);
        add(total);
        add(totalText);
    }

}