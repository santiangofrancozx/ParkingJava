package Controlador.Users;

import java.awt.event.*;
import Vista.Login.*;
import Vista.PrincipalMenu;
import Modelo.*;
import java.sql.*;

public class ControladorLogeo implements ActionListener {

    Login vista;
    PrincipalMenu menu;
    Usuario usu;
    Conexion con = null;

    public ControladorLogeo(Login vista, PrincipalMenu menu, Usuario usu) {
        this.vista = vista;
        this.menu = menu;
        this.usu = usu;

        this.vista.aceptar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("hoola");
        if (vista.email.getText().equals("admin") && vista.password.getText().equals("admin")) {
            menu.bd.setEnabled(true);
            menu.usuario.setEnabled(true);
            menu.login.setEnabled(true);
            menu.vehiculo.setEnabled(true);
        } else {
            if (vista.email.getText().equals(usu.getCorreo()) && vista.password.getText().equals(usu.getContraseña())) {
                if(usu.getNivel() == 1){
                    menu.bd.setEnabled(true);
                    menu.usuario.setEnabled(true);
                }else{
                    if(usu.getNivel() == 2){
                        menu.bd.setEnabled(false);
                        menu.usuario.setEnabled(false);
                        menu.ingresarVe.setEnabled(true);
                        menu.salidaVe.setEnabled(true);
                        menu.buscarRe.setEnabled(false);
                        menu.modificarRe.setEnabled(false);
                        menu.buscarF.setEnabled(false);
                        menu.valorHora.setEnabled(false);
                        menu.login1.setEnabled(false);
                    }
                }
            }
        }

        vista.dispose();
    }


}