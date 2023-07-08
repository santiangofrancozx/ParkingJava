package Controlador.Users;

import java.awt.event.*;
import Vista.Login.*;
import Vista.PrincipalMenu;
import Modelo.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControladorLogeo implements ActionListener {

    Login vista;
    PrincipalMenu menu;
    Usuario usu;
    Conexion con = null;
    ArrayList<Usuario> listUsu = new ArrayList<>();
    ConsultasUsuarios cUsu = new ConsultasUsuarios();
    

    public ControladorLogeo(Login vista, PrincipalMenu menu, Usuario usu) {
        this.vista = vista;
        this.menu = menu;
        this.usu = usu;


        this.vista.aceptar.addActionListener(this);
    }

    @Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == vista.aceptar) {
        System.out.println("hola");

        if (vista.email.getText().equals("admin") && vista.password.getText().equals("admin")) {
            // Iniciar sesión como administrador
            habilitarOpcionesAdmin();
        } else {
            boolean usuarioEncontrado = false;

            for (int i = 0; i < listUsu.size(); i++) {
                if (vista.email.getText().equals(listUsu.get(i).getCorreo())
                        && vista.password.getText().equals(listUsu.get(i).getContraseña())) {
                    usuarioEncontrado = true;

                    if (listUsu.get(i).getNivel() == 1) {
                        // Iniciar sesión como usuario de nivel 1
                        habilitarOpcionesNivel1();
                    } else if (listUsu.get(i).getNivel() == 2) {
                        // Iniciar sesión como usuario de nivel 2
                        habilitarOpcionesNivel2();
                    }
                }
            }

            if (!usuarioEncontrado) {
                JOptionPane.showMessageDialog(null, "Credenciales inválidas");
            }
        }

        vista.dispose();
    }
}

private void habilitarOpcionesAdmin() {
    menu.bd.setEnabled(true);
    menu.usuario.setEnabled(true);
    menu.login.setEnabled(true);
    menu.vehiculo.setEnabled(true);
}

private void habilitarOpcionesNivel1() {
    menu.bd.setEnabled(true);
    menu.usuario.setEnabled(true);
    menu.ingresarVe.setEnabled(false); // Opciones específicas para nivel 1
    menu.salidaVe.setEnabled(false); // Opciones específicas para nivel 1
    menu.buscarRe.setEnabled(false); // Opciones específicas para nivel 1
    menu.modificarRe.setEnabled(false); // Opciones específicas para nivel 1
    menu.buscarF.setEnabled(false); // Opciones específicas para nivel 1
    menu.valorHora.setEnabled(false); // Opciones específicas para nivel 1
    menu.login1.setEnabled(false); // Opciones específicas para nivel 1
}

private void habilitarOpcionesNivel2() {
    menu.bd.setEnabled(false);
    menu.usuario.setEnabled(false);
    menu.ingresarVe.setEnabled(true); // Opciones específicas para nivel 2
    menu.salidaVe.setEnabled(true); // Opciones específicas para nivel 2
    menu.buscarRe.setEnabled(false); // Opciones específicas para nivel 2
    menu.modificarRe.setEnabled(false); // Opciones específicas para nivel 2
    menu.buscarF.setEnabled(false); // Opciones específicas para nivel 2
    menu.valorHora.setEnabled(false); // Opciones específicas para nivel 2
    menu.login1.setEnabled(false); // Opciones específicas para nivel 2
}


}