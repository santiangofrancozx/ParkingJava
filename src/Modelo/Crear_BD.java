/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.*;
import Vista.DataBase.*;
import java.awt.*;
import java.util.ArrayList;
import Controlador.*;

public class Crear_BD extends Conexion{
    
    ArrayList<String> nombresBD = new ArrayList<>();
    public boolean createDB(DataBase db){
        System.out.println("hello");
        String nombreData = db.getNameBD();
        String userDB = db.getUserDB();
        String passw = db.getPasswordDB();
        Connection con = connect();
        
        try {
            String sql = "CREATE DATABASE " + nombreData;
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            CrearArchivo createFile = new CrearArchivo(nombreData);
            nombresBD.add(nombreData);
            
            con.setCatalog(nombreData);
            String sql1 = "CREATE USER '" + userDB + "'@'localhost' IDENTIFIED BY '" + passw + "'";
            preparedStatement = con.prepareStatement(sql1);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
            
            con.setCatalog(nombreData); // Seleccionar la base de datos recién creada
            String sql2 = "CREATE TABLE Usuarios (codigo INT PRIMARY KEY AUTO_INCREMENT, nombre VARCHAR(50), correo VARCHAR(50), password VARCHAR(50), nivel INT)";
            preparedStatement = con.prepareStatement(sql2);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
            System.out.println("Base de datos creada exitosamente");
            return true;
            
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
        finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    public ArrayList<String> getNombresBD(){
        return nombresBD;
    }
}
