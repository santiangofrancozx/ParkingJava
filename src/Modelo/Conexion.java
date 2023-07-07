/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.*;


public class Conexion {
    Connection connection = null;
    public static Statement statement;
    String url = "jdbc:mysql://localhost:3306";
    String user = "root";
    String password = "safraxval";
    
    public Connection connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado...");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
        }
        return connection;
    }
    
    public void disconnect(){
        try {
            if(statement != null)
            {
                statement.close();
            }

            if(connection != null)
            {
                connection.close();
            }

            System.out.println("Desconectando...");

        } catch (SQLException e) {
            System.out.println("Error desconexion en base de datos..." + e.getMessage());
        }
    }
}
