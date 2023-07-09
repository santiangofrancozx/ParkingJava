package Controlador.Users;

import Modelo.ConsultasUsuarios;
import Modelo.Usuario;
import Vista.Users.Crear_Usuario;

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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == user.jbCrear){
            usuario.setNombre(user.caja_name.getText());
            usuario.setCorreo(user.caja_correo.getText());
            usuario.setContraseña(user.caja_password.getText());
            usuario.setNivel(user.combo.getSelectedIndex()+1);
            ConsultasUsuarios insert = new ConsultasUsuarios();
            insert.insert(usuario);
            System.out.println(usuario.getNivel());
        }
        if(e.getSource() == user.jbCancelar){
            user.dispose();
        }
    }
}
