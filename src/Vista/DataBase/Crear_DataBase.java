
package Vista.DataBase;

import java.awt.*;
import javax.swing.*;

public class Crear_DataBase extends JDialog{
    public JTextField caja_nombreBD, caja_IP, caja_UserBD, caja_passBD;
    JLabel nombreBD, IP, UserBD, passBD;
    public JButton bGuardar, bCancelar;
    
    public Crear_DataBase(Frame e, boolean modal){
        super(e, modal);
        
        nombreBD = new JLabel("Nombre Base de Datos");
        nombreBD.setBounds(15, 10, 130, 30);
        add(nombreBD);
        
        caja_nombreBD = new JTextField();
        caja_nombreBD.setBounds(160, 16, 130, 20);
        add(caja_nombreBD);
        
        IP = new JLabel("Direccion IP");
        IP.setBounds(15, 50, 100, 30);
        add(IP);
        
        caja_IP = new JTextField();
        caja_IP.setBounds(160, 56, 130, 20);
        add(caja_IP);
        
        UserBD = new JLabel("Usuario");
        UserBD.setBounds(15, 90, 100, 30);
        add(UserBD);
        
        caja_UserBD = new JTextField();
        caja_UserBD.setBounds(160, 96, 130, 20);
        add(caja_UserBD);
        
        passBD = new JLabel("Contraseña");
        passBD.setBounds(15, 130, 100, 30);
        add(passBD);
        
        caja_passBD = new JTextField();
        caja_passBD.setBounds(160, 136, 130, 20);
        add(caja_passBD);
        
        bGuardar = new JButton("Guardar");
        bGuardar.setBounds(60, 180, 80, 20);
        add(bGuardar);
        
        bCancelar = new JButton("Cancelar");
        bCancelar.setBounds(160, 180, 100, 20);
        add(bCancelar);
        
    }
}
