/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.Users;

import java.awt.*;
import javax.swing.*;

public class EditarU extends JDialog{
    JLabel name, correo, password, nivel, codigoB;
    JTextField caja_name, caja_correo, caja_password, caja_nivel, caja_codigoB;
    JButton jbModificar, jbCancelar, jbBuscar;
    JComboBox combo;
    
    public EditarU(Frame e, boolean modal){
        //super(e, modal);
        setTitle("Modificar Usuario");
        setLayout(null);
        
        codigoB = new JLabel("Codigo");
        codigoB.setBounds(30, 16, 100, 20);
        add(codigoB);
        
        caja_codigoB = new JTextField();
        caja_codigoB.setBounds(110, 17, 60, 18);
        add(caja_codigoB);
        
        jbBuscar = new JButton("Buscar");
        jbBuscar.setBounds(180, 15, 80, 20);
        add(jbBuscar);
        
        
        name = new JLabel("Nombre");
        name.setBounds(30, 46, 100, 20);
        add(name);
        
        caja_name = new JTextField();
        caja_name.setBounds(110, 46, 130, 18);
        add(caja_name);
        
        correo = new JLabel("Correo");
        correo.setBounds(30, 80, 100, 20);
        add(correo);
        
        caja_correo = new JTextField();
        caja_correo.setBounds(110, 81, 130, 18);
        add(caja_correo);
        
        password = new JLabel("Contraseña");
        password.setBounds(30, 112, 100, 20);
        add(password);
        
        caja_password = new JTextField();
        caja_password.setBounds(110, 113, 130, 18);
        add(caja_password);
        
        nivel = new JLabel("Nivel");
        nivel.setBounds(30, 155, 100, 20);
        add(nivel);
        
        combo = new JComboBox();
        combo.addItem("1");
        combo.addItem("2");
        combo.addItem("3");
        combo.setRenderer(new EditarU.CenteredComboBoxRenderer());
        caja_nivel = new JTextField();
        combo.setBounds(110, 156, 50, 18);
        add(combo); 
        
        jbModificar = new JButton("Crear");
        jbModificar.setBounds(60, 200, 67, 20);
        add(jbModificar);
        
        jbCancelar = new JButton("Cancelar");
        jbCancelar.setBounds(155, 200, 90, 20);
        add(jbCancelar);
        
        setSize(300, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    //METODO PARA CENTRAR EL TEXTO INTERNO DEL JCOMBOBOX
    private class CenteredComboBoxRenderer extends DefaultListCellRenderer {
        public CenteredComboBoxRenderer() {
            setHorizontalAlignment(SwingConstants.CENTER);
        }
    }
}
