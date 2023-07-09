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
        if(e.getSource() == vista.aceptar){
            System.out.println("hoola");
            /*listUsu = cUsu.findAll();
            String m = "";
            for(int i = 0; i < listUsu.size(); i++){
                m += "Correo:"+listUsu.get(i).getCorreo() + "    Contraseña:" + listUsu.get(i).getContraseña() + "\n";
            }
            JOptionPane.showMessageDialog(null, m);*/
       
        if (vista.email.getText().equals("admin") && vista.password.getText().equals("admin")) {
            menu.bd.setEnabled(true);
            menu.usuario.setEnabled(true);
            menu.login.setEnabled(true);
            menu.vehiculo.setEnabled(true);
        } else {
            for (int i = 0; i < listUsu.size(); i++) {
                if (vista.email.getText().equals(listUsu.get(i).getCorreo()) && vista.password.getText().equals(listUsu.get(i).getContraseña())) {
                    if (listUsu.get(i).getNivel() == 1) {
                        System.out.println("encontre el nivel 1");
                        menu.bd.setEnabled(true);
                        menu.usuario.setEnabled(true);
                        
                    } else if(listUsu.get(i).getNivel() == 2){
                        System.out.println("encontre el nivel 2");
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
                System.out.println(listUsu.get(i).getCorreo());
                System.out.println(listUsu.get(i).getContraseña());
            }
        }
            
        

        vista.dispose();
        }
    }


}