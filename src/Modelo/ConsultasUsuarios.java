package Modelo;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ConsultasUsuarios extends Conexion {
    
    public ConsultasUsuarios(){

    }

    public void insert(Usuario usu){
        LeerNombreDB nameDb = new LeerNombreDB();
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
            JOptionPane.showMessageDialog(null, "Se agrego el usuario:\n" +
                    "Nombre: " + usu.getNombre() + "\n"+
                    "Correo: " + usu.getCorreo() + "\n"+
                    "Password: " + usu.getContraseña() + "\n"+
                    "Nivel: " + usu.getNivel() + "\n" +
                    "En base de datos: " + nameDb.leerNombreDBMethod("nameDB.txt"));
            preparedStatement.close();
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error al insertar en usuario: " + e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
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
                usu.setCodigo(resultSet.getInt("codigo"));
            }
            preparedStatement.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar usuario: " + e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
        } finally {
            disconnect();
        }
        return usu;
    }


    public ArrayList<Usuario> findByNivel(int nivel){

        ArrayList<Usuario> results = new ArrayList<>();

        try
        {
            connect();
            String sql = "SELECT * FROM usuarios WHERE nivel = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, nivel);
            ResultSet resultSet = preparedStatement.executeQuery();


            while(resultSet.next()){
                Usuario us = new Usuario();
                us.setCodigo(Integer.parseInt(resultSet.getString("codigo")));
                us.setNombre(resultSet.getString("nombre"));
                us.setCorreo(resultSet.getString("correo"));
                us.setContraseña(resultSet.getString("password"));
                us.setNivel(Integer.parseInt(resultSet.getString("nivel")));
                results.add(us);
            }
            resultSet.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar usuarios por nivel: " + e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
        } finally {
            disconnect();
        }
        return results;
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
            JOptionPane.showMessageDialog(null, "Se actualizo el usuario:\n");
            preparedStatement.close();
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error al actualizar usuario: " + e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
        } finally {
            disconnect();
        }

    }

    public ArrayList<Usuario> findAll(){

        ArrayList<Usuario> results = new ArrayList<>();

        try
        {
            connect();
            String sql = "SELECT * FROM usuarios";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                Usuario us = new Usuario();
                us.setCodigo(Integer.parseInt(resultSet.getString("codigo")));
                us.setNombre(resultSet.getString("nombre"));
                us.setCorreo(resultSet.getString("correo"));
                us.setContraseña(resultSet.getString("password"));
                us.setNivel(Integer.parseInt(resultSet.getString("nivel")));
                results.add(us);
            }
            resultSet.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar todos los usuarios: " + e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
        } finally {
            disconnect();
        }
        return results;
    }

    public void DeleteCheck(Usuario usu){
        
        try {
            connect();
            String sql = "DELETE FROM usuarios WHERE codigo = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, usu.getCodigo());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            System.out.println(usu.getCodigo());
            
        } catch (Exception e) {
        }
        finally{
            disconnect();
        }
    }
    
    public ArrayList<String[]> findUsuario() {
    ResultSet resultSet = null;
    ArrayList<String[]> usuarios = new ArrayList<>();
    
    try {
        connect();
        String sql = "SELECT correo, nivel, password FROM usuarios";
        statement = connection.createStatement();
        resultSet = statement.executeQuery(sql);
        
        while (resultSet.next()) {
            String correo = resultSet.getString("correo");
            String nivel = String.valueOf(resultSet.getInt("nivel"));
            String passw = resultSet.getString("password");
            String[] usuario = {correo, nivel, passw};
            usuarios.add(usuario);
            //System.out.println("Correo: " + correo + ", nivel: " + nivel + ", password: " + passw);
        }
        resultSet.close();
    } catch (SQLException e) {
        System.err.println("Error al ejecutar la consulta: " + e.getMessage());
    } finally {
        disconnect();
    }
    
    return usuarios;
}
    
}
