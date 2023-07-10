package Modelo;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConsultasIngresoVehiculos extends Conexion {


    public ConsultasIngresoVehiculos(){

    }


    public void insert(ObjetoIngreso usu){
        LeerNombreDB nameDb = new LeerNombreDB();
        try
        {
            connect();
            String sql = "INSERT INTO ingreso(placa, tipo, puesto, Hora_Entrada, Minuto_Entrada, codigo) " +
                    "VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, usu.getPlaca());
            preparedStatement.setString(2, usu.getTipo());
            preparedStatement.setInt(3, usu.getPuesto());
            preparedStatement.setInt(4, usu.getHe());
            preparedStatement.setInt(5, usu.getMe());
            preparedStatement.setInt(6, usu.getCodigo());
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se agrego el usuario:\n" +
                    "Placa: " + usu.getPlaca() + "\n"+
                    "Tipo " + usu.getTipo() + "\n"+
                    "Puesto: " + usu.getPuesto() + "\n"+
                    "Hora entrada: " + usu.getHe() + "\n" +
                    "Minuto entrada: " + usu.getMe() +
                    "En base de datos: " + nameDb.leerNombreDBMethod("nameDB.txt"));
            preparedStatement.close();
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error al insertar en usuario: " + e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
        } finally {
            disconnect();
        }
    }

    public ArrayList<ObjetoIngreso>  findAll(){

        ArrayList<ObjetoIngreso> results = new ArrayList<>();

        try
        {
            connect();
            String sql = "SELECT * FROM ingreso";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                ObjetoIngreso ingreso = new ObjetoIngreso();
                ingreso.setPlaca(resultSet.getString("placa"));
                ingreso.setTipo(resultSet.getString("tipo"));
                ingreso.setPuesto(resultSet.getInt("puesto"));
                ingreso.setHe(resultSet.getInt("Hora_Entrada"));
                ingreso.setMe(resultSet.getInt("Minuto_Entrada"));
                ingreso.setCodigo(resultSet.getInt("codigo"));
                results.add(ingreso);
            }
            resultSet.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar todos los imgresos de vehiculos: " + e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
        } finally {
            disconnect();
        }
        return results;
    }

    public ArrayList<ObjetoIngreso> findByTipo(String tipo){

        ArrayList<ObjetoIngreso> results = new ArrayList<>();

        try
        {
            connect();
            String sql = "SELECT * FROM ingreso WHERE tipo = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tipo);
            ResultSet resultSet = preparedStatement.executeQuery();


            while(resultSet.next()){
                ObjetoIngreso ingreso = new ObjetoIngreso();
                ingreso.setPlaca(resultSet.getString("placa"));
                ingreso.setTipo(resultSet.getString("tipo"));
                ingreso.setPuesto(resultSet.getInt("puesto"));
                ingreso.setHe(resultSet.getInt("Hora_Entrada"));
                ingreso.setMe(resultSet.getInt("Minuto_Entrada"));
                ingreso.setCodigo(resultSet.getInt("codigo"));
                results.add(ingreso);
            }
            resultSet.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar usuarios por tipo: " + e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
        } finally {
            disconnect();
        }
        return results;
    }
    
    public ArrayList<ObjetoIngreso> findByPos(){
        ArrayList<ObjetoIngreso> results = new ArrayList<>();
        
        try {
            connect();
            String sql = "SELECT puesto FROM ingreso";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                ObjetoIngreso ingreso = new ObjetoIngreso();
                
                ingreso.setPuesto(resultSet.getInt("puesto"));
                
                results.add(ingreso);
            }
            resultSet.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar los puestos: " + e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
        }
        finally{
            disconnect();
        }
        return results;
    }

}
