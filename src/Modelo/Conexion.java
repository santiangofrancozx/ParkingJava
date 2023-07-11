/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Controlador.ControladorDB;
import java.sql.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Conexion {
    ObtenerDB obtDB = new ObtenerDB();
    Connection connection = null;
    LeerNombreDB modelo = new LeerNombreDB();
    String namedata = obtDB.ObtenerDB();
    String url = "jdbc:mysql://localhost:3306";
    String rutaArchivo = "nameDB.txt";

    public static Statement statement;

    String user = "root";
    String password = "";

    public Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String nombreBD = modelo.leerNombreDBMethod("nameDB.txt"); // Leer el nombre de la BD desde el archivo
            if (nombreBD != null && !nombreBD.isEmpty()) {
                namedata = nombreBD;
            }

            connection = DriverManager.getConnection(url + "/" +namedata, user, password);
            System.out.println("Conectado...");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
        }
        return connection;
    }

    public void disconnect() {
        try {
            if (statement != null) {
                statement.close();
            }

            if (connection != null) {
                connection.close();
            }

            System.out.println("Desconectando...");

        } catch (SQLException e) {
            System.out.println("Error desconexion en base de datos..." + e.getMessage());
        }
    }

}
