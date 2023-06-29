/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.*;
import Vista.Users.Crear_Usuario;
import java.awt.event.*;

public class ControladorMenu implements ActionListener{
    PrincipalMenu menu;
    Crear_Usuario cu;
    public ControladorMenu(PrincipalMenu menu, Crear_Usuario cu){
        this.menu = menu;
        this.cu = cu;
        this.menu.crearU.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == menu.crearU){
            inicioCU();
        }
    }
    
    public void inicioCU(){
        cu.setTitle("Crear Usuario");
        cu.setSize(300, 300);
        cu.setLocationRelativeTo(null);
        cu.setVisible(true);;
    }
            
}
