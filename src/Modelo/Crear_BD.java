/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.*;
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
        System.out.println(db.getUserDB());
        String passw = db.getPasswordDB();
        Connection con = connect();

        //
        
        //
        
        try {
            String sql = "CREATE DATABASE " + nombreData;
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            CrearArchivo createFile = new CrearArchivo(nombreData);
            String rutaArchivo = "nameDB.txt";
        try {
            // Crea un objeto File con la ruta del archivo
            File archivo = new File(rutaArchivo);

            // Crea un objeto FileWriter para escribir en el archivo
            FileWriter escritor = new FileWriter(archivo);

            // Escribe contenido en el archivo
            escritor.write(db.getNameBD());

            // Cierra el FileWriter
            escritor.close();

            System.out.println("El archivo se ha creado correctamente.");
            System.out.println(db.getNameBD());
        } catch (IOException e) {
            System.out.println("Ocurrió un error al crear el archivo: " + e.getMessage());
        }

            
            nombresBD.add(nombreData);
            
            con.setCatalog(nombreData); // Seleccionar la base de datos recién creada
            String sql2 = "CREATE TABLE Usuarios (codigo INT PRIMARY KEY AUTO_INCREMENT not null, nombre VARCHAR(50), correo VARCHAR(50), password VARCHAR(50), nivel INT)";
            preparedStatement = con.prepareStatement(sql2);
            preparedStatement.executeUpdate();
            preparedStatement.close();

            //tarifas
            con.setCatalog(nombreData); // Seleccionar la base de datos recién creada
            String sql3 = "CREATE TABLE tarifas (tipo char primary key, valor double)";
            preparedStatement = con.prepareStatement(sql3);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            //definido por defecto
            con.setCatalog(nombreData); // Seleccionar la base de datos recién creada
            String sqlInsert = "INSERT INTO tarifas(tipo, valor) VALUES('b', 0),('c', 0),('m', 0)";
            preparedStatement = con.prepareStatement(sqlInsert);
            preparedStatement.executeUpdate();
            preparedStatement.close();

            //ingreso
            con.setCatalog(nombreData); // Seleccionar la base de datos recién creada
            String sql4 = "CREATE TABLE ingreso (placa VARCHAR (50), tipo VARCHAR(50), puesto INT PRIMARY KEY, Hora_Entrada INT, Minuto_Entrada INT, codigo INT," +
                            "FOREIGN KEY (codigo) REFERENCES usuarios(codigo)," +
                            "FOREIGN KEY (tipo) REFERENCES tarifas(tipo) ON DELETE CASCADE ON UPDATE CASCADE)";
            preparedStatement = con.prepareStatement(sql4);
            preparedStatement.executeUpdate();
            preparedStatement.close();

            //factura
            con.setCatalog(nombreData); // Seleccionar la base de datos recién creada
            String sql5 = "CREATE TABLE factura (codigo_factura INT PRIMARY KEY AUTO_INCREMENT not null, tipo VARCHAR(50), placa VARCHAR (50), codigo INT, Hora_Entrada INT, minuto_entrada INT, Hora_Salida INT, minuto_salida INT, horas DOUBLE, Valor_Hora INT, Total DOUBLE, puesto INT,\n" +
                    "FOREIGN KEY (tipo) REFERENCES tarifas(tipo) ON DELETE CASCADE ON UPDATE CASCADE," +
                    "FOREIGN KEY (codigo) REFERENCES usuarios(codigo) ON DELETE CASCADE ON UPDATE CASCADE," +
                    "FOREIGN KEY (puesto)  REFERENCES ingreso(puesto) ON DELETE CASCADE ON UPDATE CASCADE)";
            preparedStatement = con.prepareStatement(sql5);
            preparedStatement.executeUpdate();
            preparedStatement.close();




            System.out.println("Base de datos creada exitosamente");
            
            con.setCatalog(nombreData);
            String sql1 = "CREATE USER '" + userDB + "'@'localhost' IDENTIFIED BY '" + passw + "'";
            preparedStatement = con.prepareStatement(sql1);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            
            
            
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
