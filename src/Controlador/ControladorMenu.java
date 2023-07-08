/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.*;
import Vista.*;
import Vista.Login.Login;
import Vista.Users.*;
import Vista.DataBase.*;
import java.awt.event.*;

public class ControladorMenu implements ActionListener{
    PrincipalMenu menu;
    Crear_Usuario cu;
    Crear_DataBase crearDB;
    Delete_DB dDB;
    EditarU editUsu;
    Login log;
    
    public ControladorMenu(PrincipalMenu menu, Crear_Usuario cu, Crear_DataBase crearDB, Delete_DB dDB, EditarU editUsu, Login log){
        this.menu = menu;
        this.editUsu = editUsu;
        this.cu = cu;
        this.crearDB = crearDB;
        this.dDB = dDB;
        this.log = log;
        this.menu.modificarU.addActionListener(this);
        this.menu.crearU.addActionListener(this);
        this.menu.crearBD.addActionListener(this);
        this.menu.eliminarBD.addActionListener(this);
        this.menu.login1.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == menu.crearU){
            inicioCU();
        }
        if(e.getSource() == menu.crearBD){
            inicioCrearDB();
        }
        if(e.getSource() == menu.eliminarBD){
            dDB.delete();
        }
        if(e.getSource() == menu.modificarU){
            inicioEditarU();
        }
        if(e.getSource() == menu.login1){
            inicioLogin();
        }

    }
    
    public void inicioCU(){
        cu.setTitle("Crear Usuario");
        cu.setSize(300, 300);
        cu.setLocationRelativeTo(null);
        cu.setVisible(true);
    }
    
    public void inicioCrearDB(){
        crearDB.setTitle("                      Creacion Base de Datos");
        crearDB.setSize(330,270);
        crearDB.setLayout(null);
        crearDB.setLocationRelativeTo(null);
        crearDB.setVisible(true);   
    }

    public void inicioEditarU(){
        editUsu.setSize(300, 300);
        editUsu.setLocationRelativeTo(null);
        editUsu.setVisible(true);
    }

    public void inicioLogin(){
        log.setTitle("LOGIN");
        log.setSize(350,200);
        log.setLayout(null);
        log.setLocationRelativeTo(null);
        log.setResizable(false);
        log.setVisible(true);
    }
   
            
}
