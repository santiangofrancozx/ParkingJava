/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Users;

import Modelo.ConsultasUsuarios;
import Modelo.Usuario;
import Vista.Users.EditarU;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author safra
 */
public class ControladorModificarUsuario implements ActionListener {

    EditarU vista;
    Usuario usu = new Usuario();
    
    public ControladorModificarUsuario(EditarU vista, Usuario usu){
        this.vista = vista;
        this.usu = usu;
        this.vista.jbBuscar.addActionListener(this);
        this.vista.jbModificar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Usuario us = new Usuario();
        if (e.getSource() == vista.jbBuscar){
            ConsultasUsuarios search = new ConsultasUsuarios();
            us = search.find(Integer.parseInt(vista.caja_codigoB.getText()));
            vista.caja_name.setText(us.getNombre());
            vista.caja_correo.setText(us.getCorreo());
            vista.caja_password.setText(us.getContraseña());
            vista.combo.setSelectedIndex(us.getNivel());
            JOptionPane.showMessageDialog(null, us.getNombre());
        }
        if (e.getSource() == vista.jbModificar){
            ConsultasUsuarios update = new ConsultasUsuarios();
            us.setNombre(vista.caja_name.getText());
            us.setCorreo(vista.caja_correo.getText());
            us.setContraseña(vista.caja_password.getText());
            us.setNivel(vista.combo.getSelectedIndex());
            update.update(us, Integer.parseInt(vista.caja_codigoB.getText()));
        }

    }
}
