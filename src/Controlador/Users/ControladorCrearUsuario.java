package Controlador.Users;

import Modelo.ConsultasUsuarios;
import Modelo.Usuario;
import Vista.Users.Crear_Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControladorCrearUsuario implements ActionListener {
    Crear_Usuario user;
    Usuario usuario;



    public ControladorCrearUsuario(Usuario usuario, Crear_Usuario user){
        this.user = user;
        this.usuario = usuario;
        this.user.jbCrear.addActionListener(this);
        this.user.jbCancelar.addActionListener(this);
    }

    public static boolean validarFormatoCorreoElectronico(String correo) {
        // Expresión regular para validar el formato de correo electrónico
        String patron = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        boolean formatoValido = correo.matches(patron);
        return formatoValido;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == user.jbCrear){
            if (validarFormatoCorreoElectronico(user.caja_correo.getText())){
                usuario.setNombre(user.caja_name.getText());
                usuario.setCorreo(user.caja_correo.getText());
                usuario.setContraseña(user.caja_password.getText());
                usuario.setNivel(user.combo.getSelectedIndex()+1);
                ConsultasUsuarios insert = new ConsultasUsuarios();
            insert.insert(usuario);
            }
            else {
                JOptionPane.showMessageDialog(null, "Correo No valido");
            }

        }
        if(e.getSource() == user.jbCancelar){
            user.dispose();
        }
    }
}
