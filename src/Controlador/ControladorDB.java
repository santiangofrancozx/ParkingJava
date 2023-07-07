/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.*;
import Vista.*;
import Vista.DataBase.Crear_DataBase;
import java.awt.event.*;


public class ControladorDB implements ActionListener{
    DataBase modelo;
    Crear_DataBase vista;
    Crear_BD crear;
    
    public ControladorDB (DataBase modelo, Crear_DataBase vista, Crear_BD crear){
        this.modelo = modelo;
        this.vista = vista;
        this.crear = crear;
        this.vista.bGuardar.addActionListener(this);
        this.vista.bCancelar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == vista.bGuardar){
            modelo.setNameBD(vista.caja_nombreBD.getText());
            modelo.setUserDB(vista.caja_UserBD.getText());
            System.out.println("hola");
            System.out.println(modelo.getNameBD());
            vista.caja_nombreBD.setText("");
            vista.caja_passBD.setText("");
            vista.caja_UserBD.setText("");
            vista.caja_IP.setText("");
        } 
        
        if(e.getSource() == vista.bCancelar){
            System.out.println("entre en cancelar");
            vista.setVisible(false);
        }
        
        if(crear.createDB(modelo)){
            System.out.println("Guardado");
        }else{
            System.out.println("No se guardo");
        }
        
        
    }
    
}
