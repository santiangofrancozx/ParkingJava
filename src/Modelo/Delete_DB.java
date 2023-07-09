/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.File;
import java.io.FileWriter;
import java.sql.*;
import Vista.DataBase.*;

public class Delete_DB extends Conexion{
    Crear_DataBase vista;
    DataBase db = new DataBase();
    LeerNombreDB nameDb = new LeerNombreDB();

    ObtenerDB obDB = new ObtenerDB();
    public boolean delete(){
        String nombreData = nameDb.leerNombreDBMethod("nameDB.txt");
        Connection con = connect();
        try {
            String sql = "DROP DATABASE " + nombreData;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            System.out.println("Base de datos eliminada exitosamente");
            try {
                File archivo = new File(rutaArchivo);
                FileWriter escritor = new FileWriter(archivo);
                escritor.write("");
                escritor.close();
                System.out.println("Se ha borrado el contenido del archivo correctamente.");
            } catch (Exception e) {
                System.out.println("Ocurrió un error al borrar el contenido del archivo: " + e.getMessage());
            }
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
}
