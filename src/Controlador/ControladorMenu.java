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
import Vista.Vehicles.BuscarFactura;
import Vista.Vehicles.BuscarRegistros;
import Vista.Vehicles.IngresoVehiculo;
import Vista.Vehicles.ModificarRegistros;
import Vista.Vehicles.SalidaVehiculo;
import Vista.Vehicles.hourValue;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.event.*;
import java.awt.Component;

public class ControladorMenu implements ActionListener{
    PrincipalMenu menu;
    Crear_Usuario cu;
    Crear_DataBase crearDB;
    Delete_DB dDB;
    EditarU editUsu;
    Login log;
    Eliminar eliminVis;
    IngresoVehiculo ingVh;
    SalidaVehiculo salVh;
    BuscarRegistros buscRe;
    ModificarRegistros modRe;
    BuscarFactura buscF;
    hourValue hourV;


    //

    public class CheckboxRenderer extends DefaultTableCellRenderer {
        private JCheckBox checkBox = new JCheckBox();

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (value != null && value instanceof Boolean) {
                checkBox.setSelected((Boolean) value);
            } else {
                checkBox.setSelected(false);
            }
            return checkBox;
        }
    }

    //

    public ControladorMenu(PrincipalMenu menu, Crear_Usuario cu, Crear_DataBase crearDB, Delete_DB dDB, EditarU editUsu, Login log, Eliminar eliminVis, IngresoVehiculo ingVh, SalidaVehiculo salVh, BuscarRegistros buscRe, ModificarRegistros modRe, BuscarFactura buscF, hourValue hourV){
        this.menu = menu;
        this.editUsu = editUsu;
        this.cu = cu;
        this.crearDB = crearDB;
        this.dDB = dDB;
        this.log = log;
        this.eliminVis = eliminVis;
        this.ingVh = ingVh;
        this.salVh = salVh;
        this.buscRe = buscRe;
        this.modRe = modRe;
        this.buscF = buscF;
        this.hourV = hourV;
        this.menu.modificarU.addActionListener(this);
        this.menu.crearU.addActionListener(this);
        this.menu.crearBD.addActionListener(this);
        this.menu.eliminarBD.addActionListener(this);
        this.menu.login1.addActionListener(this);
        this.menu.verU.addActionListener(this);
        this.menu.ingresarVe.addActionListener(this);
        this.menu.salidaVe.addActionListener(this);
        this.menu.buscarRe.addActionListener(this);
        this.menu.modificarRe.addActionListener(this);
        this.menu.buscarF.addActionListener(this);
        this.menu.valorHora.addActionListener(this);

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
        if (e.getSource() == menu.verU){
            inicioEliminarVisualizar();
        }
        if(e.getSource() == menu.ingresarVe){
            ingresarVehiculo();
        }
        if(e.getSource() == menu.salidaVe){
            salidaVehiculo();
        }
        if(e.getSource() == menu.buscarRe){
            buscarRegistros();
        }
        if(e.getSource() == menu.modificarRe){
            modificarRegistros();
        }
        if(e.getSource() == menu.buscarF){
            buscarFactura();
        }
        if(e.getSource() == menu.valorHora){
            valorHora();
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

    public void  inicioEliminarVisualizar(){
        eliminVis.setSize(700,370);
        eliminVis.setLayout(null);
        eliminVis.setLocationRelativeTo(null);
        eliminVis.setResizable(false);
        eliminVis.setVisible(true);
    }

    public void ingresarVehiculo(){
        ingVh.setSize(700,400);
        ingVh.setLayout(null);
        ingVh.setLocationRelativeTo(null);
        ingVh.setResizable(false);
        ingVh.setVisible(true);
    }

    public void salidaVehiculo(){
        salVh.setLayout(null);
        salVh.setSize(320, 200);
        salVh.setLocationRelativeTo(null);
        salVh.setResizable(true);
        salVh.setVisible(true);
    }

    public void buscarRegistros(){
        buscRe.setSize(700,370);
        buscRe.setLayout(null);
        buscRe.setLocationRelativeTo(null);
        buscRe.setResizable(false);
        buscRe.setVisible(true);
    }

    public void modificarRegistros(){
        modRe.setSize(700,370);
        modRe.setLayout(null);
        modRe.setLocationRelativeTo(null);
        modRe.setResizable(false);
        modRe.setVisible(true);
    }

    public void buscarFactura(){
        buscF.setSize(320, 450);
        buscF.setLayout(null);
        buscF.setResizable(false);
        buscF.setLocationRelativeTo(null);
        buscF.setVisible(true);
    }

    public void valorHora(){
        hourV.setSize(300,240);
        hourV.setLayout(null);
        hourV.setLocationRelativeTo(null);
        hourV.setResizable(false);
        hourV.setVisible(true);
    }
}