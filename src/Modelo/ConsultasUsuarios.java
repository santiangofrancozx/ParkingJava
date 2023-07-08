package Modelo;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasUsuarios extends Conexion {
    
    public ConsultasUsuarios(){

    }

    public void insert(Usuario usu){
        
        try
        {
            connect();
            String sql = "INSERT INTO Usuarios(nombre, correo, password, nivel) VALUES(?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, usu.getNombre());
            preparedStatement.setString(2, usu.getCorreo());
            preparedStatement.setString(3, usu.getContraseña());
            preparedStatement.setInt(4, usu.getNivel());
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se agrego el cliente:\n" +
                    "Nombre: " + usu.getNombre() + "\n"+
                    "Correo: " + usu.getCorreo() + "\n"+
                    "Password " + usu.getContraseña() + "\n"+
                    "Nivel: " + usu.getNivel() + "\n");
            preparedStatement.close();
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error al insertar en cliente: " + e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
        } finally {
            disconnect();
        }
        
        

    }

    //

    public Usuario find(int codigo){
        Usuario usu =  new Usuario();
        try
        {
            connect();
            String sql = "SELECT * FROM usuarios WHERE codigo = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, codigo);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                usu.setNombre(resultSet.getString("nombre"));
                usu.setCorreo(resultSet.getString("correo"));
                usu.setContraseña(resultSet.getString("password"));
                usu.setNivel(resultSet.getInt("nivel"));
            }
            preparedStatement.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar cliente: " + e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
        } finally {
            disconnect();
        }
        return usu;
    }

    public void update(Usuario usu, int code){

        try
        {
            connect();
            String sql = "UPDATE usuarios SET nombre = ?, correo = ?, password = ?, nivel = ? WHERE codigo = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, usu.getNombre());
            preparedStatement.setString(2, usu.getCorreo());
            preparedStatement.setString(3, usu.getContraseña());
            preparedStatement.setInt(4, usu.getNivel());
            preparedStatement.setInt(5, code);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se actualizo el cliente:\n");
            preparedStatement.close();
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error al actualizar cliente: " + e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
        } finally {
            disconnect();
        }

    }


}

