package Controlador.Users;

import java.awt.event.*;
import Vista.Login.*;
import Vista.PrincipalMenu;
import Modelo.*;
import java.sql.*;
import java.util.ArrayList;
import Controlador.Users.*;
import javax.swing.JOptionPane;

public class ControladorLogeo implements ActionListener {

    Login vista;
    PrincipalMenu menu;
    ConsultasUsuarios modelo;
    Usuario usu;
    Conexion con = null;
    ArrayList<Usuario> listUsu = new ArrayList<>();
    ConsultasUsuarios cUsu = new ConsultasUsuarios();

    public ControladorLogeo(Login vista, PrincipalMenu menu, Usuario usu, ConsultasUsuarios modelo) {
        this.vista = vista;
        this.menu = menu;
        this.usu = usu;
        this.modelo = modelo;

        this.vista.aceptar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.aceptar) {
            System.out.println("hoola");
            if (vista.email.getText().equals("admin") && vista.password.getText().equals("admin")) {
                menu.bd.setEnabled(true);
                menu.usuario.setEnabled(true);
                menu.login.setEnabled(true);
                menu.vehiculo.setEnabled(true);
                menu.vehiculo.setEnabled(true);
                menu.buscarRe.setEnabled(true);
                menu.modificarRe.setEnabled(true);
                menu.buscarF.setEnabled(true);
                menu.valorHora.setEnabled(true);
                vista.email.setText("");
                vista.password.setText("");
            } else {
                ArrayList<Usuario> usuarios = modelo.findAll();
                for (int i = 0; i< usuarios.size();i++) {
                    String correo = usuarios.get(i).getCorreo();
                    int nivel = usuarios.get(i).getNivel();
                    String password = usuarios.get(i).getContraseña();

                    System.out.println(usuarios.get(i).getCorreo());
                    System.out.println(usuarios.get(i).getNivel());
                    System.out.println(usuarios.get(i).getNivel());

                    if (vista.email.getText().equals(correo) && vista.password.getText().equals(password) && nivel == 1) {
                        System.out.println("encontré el nivel 1");
                        menu.bd.setEnabled(true);
                        menu.usuario.setEnabled(true);
                        menu.login.setEnabled(true);
                        menu.vehiculo.setEnabled(true);
                        menu.buscarRe.setEnabled(true);
                        menu.modificarRe.setEnabled(true);
                        menu.buscarF.setEnabled(true);
                        menu.valorHora.setEnabled(true);
                        vista.email.setText("");
                        vista.password.setText("");
                        break;
                        // Opcional: salir del bucle si se encuentra el usuario con nivel 1

                    } else if (vista.email.getText().equals(correo) && vista.password.getText().equals(password) && nivel == 2) {
                        System.out.println("encontre el nivel 2");
                        menu.bd.setEnabled(false);
                        menu.usuario.setEnabled(false);
                        menu.ingresarVe.setEnabled(true);
                        menu.vehiculo.setEnabled(true);
                        menu.salidaVe.setEnabled(true);
                        menu.buscarRe.setEnabled(false);
                        menu.modificarRe.setEnabled(false);
                        menu.buscarF.setEnabled(false);
                        menu.valorHora.setEnabled(false);
                        vista.email.setText("");
                        vista.password.setText("");
                        //menu.login1.setEnabled(false);

                    } else if (vista.email.getText().equals(correo) && vista.password.getText().equals(password) && nivel == 3) {
                        System.out.println("encontre el nivel 3");
                        menu.bd.setEnabled(false);
                        menu.usuario.setEnabled(false);
                        menu.ingresarVe.setEnabled(true);
                        menu.vehiculo.setEnabled(true);
                        menu.salidaVe.setEnabled(false);
                        menu.buscarRe.setEnabled(false);
                        menu.modificarRe.setEnabled(false);
                        menu.buscarF.setEnabled(false);
                        menu.valorHora.setEnabled(false);
                        vista.email.setText("");
                        vista.password.setText("");
                        //menu.login1.setEnabled(false);

                    }
                }
            }
        }
        vista.dispose();
    }
}

