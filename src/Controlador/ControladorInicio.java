/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.PrincipalMenu;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Lopez
 */
public class ControladorInicio {
    
    PrincipalMenu menu;
    public ControladorInicio(PrincipalMenu menu){
        this.menu = menu;
    }
    public void inicio(){
        menu.setTitle("Menu Principal");
        menu.setSize(300,400);
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(EXIT_ON_CLOSE);
        menu.setVisible(true);
    }
}
