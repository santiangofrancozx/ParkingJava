/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import javax.swing.JMenu;
import javax.swing.*;
import javax.swing.JMenuItem;


public class PrincipalMenu extends JFrame{
    public JMenuBar barra;
    public JMenu bd, login, usuario, vehiculo; 
    public JMenuItem crearBD, eliminarBD, login1, logout, crearU, modificarU, verU, ingresarVe, salidaVe, buscarRe, modificarRe, buscarF, valorHora;
    
    public PrincipalMenu(){
        barra = new JMenuBar();
        
        bd = new JMenu("Base de Datos");
        crearBD = new JMenuItem("Crear Base de Datos");
        eliminarBD = new JMenuItem("Eliminar Base de Datos");
        
        login = new JMenu("Login");
        login1 = new JMenuItem("Iniciar Sesion");
        logout = new JMenuItem("Cerrar Sesion");
        
        usuario = new JMenu("Usuario");
        crearU = new JMenuItem("Crear");
        modificarU = new JMenuItem("Modificar");
        verU = new JMenuItem("Visualizar/Eliminar");

        vehiculo = new JMenu("Vehiculos");
        ingresarVe = new JMenuItem("Ingresar");
        salidaVe = new JMenuItem("Salida");
        buscarRe = new JMenuItem("Buscar Registros");
        modificarRe = new JMenuItem("Modificar Registros");
        buscarF = new JMenuItem("Buscar Factura");
        valorHora = new JMenuItem("Valor Hora");
        
        setJMenuBar(barra);
        barra.add(bd);
        barra.add(login);
        barra.add(usuario);
        barra.add(vehiculo);
        
        bd.add(crearBD);
        bd.add(eliminarBD);
        
        login.add(login1);
        login.add(logout);
        
        usuario.add(crearU);
        usuario.add(modificarU);
        usuario.add(verU);
        
        vehiculo.add(ingresarVe);
        vehiculo.add(salidaVe);
        vehiculo.add(buscarRe);
        vehiculo.add(modificarRe);
        vehiculo.add(buscarF);
        vehiculo.add(valorHora);
    }
}
