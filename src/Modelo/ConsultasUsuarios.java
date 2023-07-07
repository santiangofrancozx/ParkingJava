package Modelo;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConsultasUsuarios extends Conexion {

    public ConsultasUsuarios(){

    }

    public void insert(String nombre, String contraseña, String correo, int nivel){

        try
        {
            connect();
            String sql = "INSERT INTO Usuarios(nombre, correo, password, nivel) VALUES(?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, correo);
            preparedStatement.setString(3, password);
            preparedStatement.setInt(4, nivel);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se agrego el cliente:\n" +
                    "Nombre: " + nombre + "\n"+
                    "Correo: " + correo + "\n"+
                    "Password " + password + "\n"+
                    "Nivel: " + nivel + "\n");
            preparedStatement.close();
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error al insertar en cliente: " + e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
        } finally {
            disconnect();
        }

    }


}

