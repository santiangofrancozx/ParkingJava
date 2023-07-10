package Modelo;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConsultasFactura extends Conexion{

    public ConsultasFactura(){

    }

    public void insert(ObjetoIngreso usu){
        LeerNombreDB nameDb = new LeerNombreDB();
        try
        {
            connect();
            String sql = "INSERT INTO factura(tipo, placa, codigo, Hora_Entrada, Minuto_Entrada) " +
                    "VALUES(?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, usu.getTipo());
            preparedStatement.setString(2, usu.getPlaca());
            preparedStatement.setInt(3, usu.getCodigo());
            preparedStatement.setInt(4, usu.getHe());
            preparedStatement.setInt(5, usu.getMe());
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

    public ArrayList<ObjetoFactura> findAll(){

        ArrayList<ObjetoFactura> results = new ArrayList<>();

        try
        {
            connect();
            String sql = "SELECT * FROM factura";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                ObjetoFactura ingreso = new ObjetoFactura();
                ingreso.setPlaca(resultSet.getString("placa"));
                ingreso.setTipo(resultSet.getString("tipo"));
                ingreso.setHe(resultSet.getInt("Hora_Entrada"));
                ingreso.setMe(resultSet.getInt("inuto_entrada"));
                ingreso.setCodigo(resultSet.getInt("codigo"));
                ingreso.setCodigio_factura(resultSet.getInt("codigo_factura"));
                ingreso.setHe(resultSet.getInt("Hora_Salida"));
                ingreso.setMe(resultSet.getInt("minuto_salida"));
                ingreso.setHoras(resultSet.getInt("horas"));
                ingreso.setTotal(resultSet.getDouble("Total"));
            }
            resultSet.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar todoas las facturas: " + e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
        } finally {
            disconnect();
        }
        return results;
    }

    public ObjetoFactura findByCode(int code){
        ObjetoFactura ingreso = new ObjetoFactura();
        try
        {
            connect();
            String sql = "SELECT * FROM factura WHERE codigo_factura = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, code);
            ResultSet resultSet = preparedStatement.executeQuery();


            if(resultSet.next()){
                ingreso.setPlaca(resultSet.getString("placa"));
                ingreso.setTipo(resultSet.getString("tipo"));
                ingreso.setHe(resultSet.getInt("Hora_Entrada"));
                ingreso.setMe(resultSet.getInt("inuto_entrada"));
                ingreso.setCodigo(resultSet.getInt("codigo"));
                ingreso.setCodigio_factura(resultSet.getInt("codigo_factura"));
                ingreso.setHe(resultSet.getInt("Hora_Salida"));
                ingreso.setMe(resultSet.getInt("minuto_salida"));
                ingreso.setHoras(resultSet.getInt("horas"));
                ingreso.setTotal(resultSet.getDouble("Total"));
            }
            resultSet.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar todoas las facturas: " + e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
        } finally {
            disconnect();
        }
        return ingreso;
    }
}
