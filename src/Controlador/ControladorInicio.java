/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.PrincipalMenu;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import Modelo.*;

public class ControladorInicio {
    Usuario usu;
    PrincipalMenu menu;
    public ControladorInicio(PrincipalMenu menu){
        this.menu = menu;
        this.usu = usu;
    }
    public void inicio(){
        menu.bd.setEnabled(false);
        menu.usuario.setEnabled(false);
        menu.vehiculo.setEnabled(false);
        menu.setTitle("Menu Principal");
        menu.setSize(400,250);
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(EXIT_ON_CLOSE);
        menu.setVisible(true);

    }
}