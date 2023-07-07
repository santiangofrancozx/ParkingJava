/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.Users;

import java.awt.*;
import javax.swing.*;


public class Crear_Usuario extends JDialog{
    public JLabel name, correo, password, nivel;
    public JTextField caja_name, caja_correo, caja_password, caja_nivel;
    public JButton jbCrear, jbCancelar;
    public JComboBox combo;
    
    
    public Crear_Usuario(Frame e, boolean modal){
        super(e, modal);
        setTitle("Crear Usuario");
        setLayout(null);
        
        name = new JLabel("Nombre");
        name.setBounds(40, 10, 100, 20);
        add(name);
        
        caja_name = new JTextField();
        caja_name.setBounds(130, 12, 130, 18);
        add(caja_name);
        
        correo = new JLabel("Correo");
        correo.setBounds(40, 40, 100, 20);
        add(correo);
        
        caja_correo = new JTextField();
        caja_correo.setBounds(130, 42, 130, 18);
        add(caja_correo);
        
        password = new JLabel("Contraseña");
        password.setBounds(40, 70, 100, 20);
        add(password);
        
        caja_password = new JTextField();
        caja_password.setBounds(130, 72, 130, 18);
        add(caja_password);
        
        nivel = new JLabel("Nivel");
        nivel.setBounds(40, 115, 100, 20);
        add(nivel);
        
        combo = new JComboBox();
        combo.addItem("1");
        combo.addItem("2");
        combo.addItem("3");
        combo.setRenderer(new CenteredComboBoxRenderer());
        caja_nivel = new JTextField();
        combo.setBounds(130, 117, 50, 18);
        add(combo); 
        
        jbCrear = new JButton("Crear");
        jbCrear.setBounds(70, 200, 67, 20);
        add(jbCrear);
        
        jbCancelar = new JButton("Cancelar");
        jbCancelar.setBounds(155, 200, 90, 20);
        add(jbCancelar);
        
        
    }  
    
    //METODO PARA CENTRAR EL TEXTO INTERNO DEL JCOMBOBOX
    private class CenteredComboBoxRenderer extends DefaultListCellRenderer {
        public CenteredComboBoxRenderer() {
            setHorizontalAlignment(SwingConstants.CENTER);
        }
    }
}
