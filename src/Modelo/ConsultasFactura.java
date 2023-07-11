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
            String sql = "INSERT INTO factura(tipo, placa, codigo, Hora_Entrada, Minuto_Entrada, Valor_Hora) " +
                    "VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, usu.getTipo());
            preparedStatement.setString(2, usu.getPlaca());
            preparedStatement.setInt(3, usu.getCodigo());
            preparedStatement.setInt(4, usu.getHe());
            preparedStatement.setInt(5, usu.getMe());
            preparedStatement.setDouble(6, usu.getValorHora());
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

    public double sumTotal() {
        double retorno = 0;
        try {
            connect();
            String sql = "SELECT SUM(Total) AS suma_total FROM factura";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                retorno = resultSet.getDouble("suma_total");
            }
            resultSet.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error" + e);
        } finally {
            // Cierra la conexión y los recursos
            disconnect();
        }
        return retorno;
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
                ingreso.setMe(resultSet.getInt("minuto_entrada"));
                ingreso.setCodigo(resultSet.getInt("codigo"));
                ingreso.setCodigio_factura(resultSet.getInt("codigo_factura"));
                ingreso.setHs(resultSet.getInt("Hora_Salida"));
                ingreso.setMs(resultSet.getInt("minuto_salida"));
                ingreso.setHoras(resultSet.getInt("horas"));
                ingreso.setTotal(resultSet.getDouble("Total"));
                ingreso.setValorHoras(resultSet.getDouble("Valor_Hora"));
                results.add(ingreso);
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
                ingreso.setMe(resultSet.getInt("minuto_entrada"));
                ingreso.setCodigo(resultSet.getInt("codigo"));
                ingreso.setCodigio_factura(resultSet.getInt("codigo_factura"));
                ingreso.setHs(resultSet.getInt("Hora_Salida"));
                ingreso.setMs(resultSet.getInt("minuto_salida"));
                ingreso.setHoras(resultSet.getInt("horas"));
                ingreso.setValorHoras(resultSet.getDouble("Valor_Hora"));
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

    public void update(ObjetoTarifas obj, String tipo){

        try
        {
            connect();
            String sql = "UPDATE factura SET Valor_Hora = ?  WHERE tipo = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, obj.getValor());
            preparedStatement.setString(2, tipo);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se actualizo la factura:\n");
            preparedStatement.close();
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error al actualizar factura " + e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
        } finally {
            disconnect();
        }

    }

    public void updateByPlaca(ObjetoFactura obj, String placa){

        try
        {
            connect();
            String sql = "UPDATE factura\n" +
                    "SET tipo = ?,\n" +
                    "    Hora_Entrada = ?,\n" +
                    "    minuto_entrada = ?,\n" +
                    "    Hora_Salida = ?,\n" +
                    "    minuto_salida = ?,\n" +
                    "    horas = ?,\n" +
                    "    Valor_Hora = ?,\n" +
                    "    Total = ?\n" +
                    "WHERE placa = ?;\n";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, obj.getTipo());
            //preparedStatement.setInt(1, obj.getCodigo());//empleado
            preparedStatement.setInt(2, obj.getHe());
            preparedStatement.setInt(3, obj.getMe());
            preparedStatement.setInt(4, obj.getHs());
            preparedStatement.setInt(5, obj.getMe());
            preparedStatement.setInt(6, obj.getHoras());
            System.out.println("------------\n");
            System.out.println(obj.getValorHoras());
            System.out.println("------------\n");
            preparedStatement.setDouble(7, obj.getValorHoras());
            preparedStatement.setDouble(8, obj.getTotal());
            preparedStatement.setString(9, obj.getPlaca());
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se actualizo la factura:\n");
            preparedStatement.close();
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error al actualizar factura " + e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
        } finally {
            disconnect();
        }

    }

    public ObjetoFactura findByPlate2(String placa){

        ObjetoFactura results = new ObjetoFactura();

        try
        {
            connect();
            String sql = "SELECT * FROM factura WHERE placa = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, placa);
            ResultSet resultSet = preparedStatement.executeQuery();


            while(resultSet.next()){
                ObjetoFactura ingreso = new ObjetoFactura();

                ingreso.setCodigio_factura(resultSet.getInt("codigo_factura"));
                ingreso.setTipo(resultSet.getString("tipo"));
                ingreso.setPlaca(resultSet.getString("placa"));
                ingreso.setCodigo(resultSet.getInt("codigo"));
                ingreso.setHe(resultSet.getInt("Hora_Entrada"));
                ingreso.setMe(resultSet.getInt("minuto_entrada"));
                System.out.println("error de consulfact");
                ingreso.setHs(resultSet.getInt("Hora_Salida"));
                ingreso.setMs(resultSet.getInt("minuto_salida"));
                ingreso.setValorHoras(resultSet.getDouble("Valor_Hora"));
                ingreso.setHoras(resultSet.getInt("horas"));
                ingreso.setTotal(resultSet.getDouble("Total"));


                results = ingreso;
            }
            resultSet.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al consultar usuarios por tipo: " + e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
        } finally {
            disconnect();
        }
        return results;
    }

    public void update2(ObjetoFactura obj, String placa){

        try
        {
            connect();
            String sql = "UPDATE factura SET Hora_Salida = ?, minuto_salida = ?  WHERE placa = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, obj.getHs());
            preparedStatement.setDouble(2, obj.getMs());
            preparedStatement.setString(3, placa);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se actualizo la factura:\n");
            preparedStatement.close();
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error al actualizar factura " + e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
        } finally {
            disconnect();
        }

    }
    
    public void update3(ObjetoFactura obj, int code) {
    try {
        connect();
        String sql = "UPDATE factura SET Tipo = ?, placa = ?, Hora_Entrada = ?, Hora_Salida = ?, minuto_entrada = ?, minuto_salida = ?, horas = ?, Total = ? WHERE codigo_factura = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, obj.getTipo());
        preparedStatement.setString(2, obj.getPlaca());
        preparedStatement.setDouble(3, obj.getHe());
        preparedStatement.setDouble(4, obj.getHs());
        
        preparedStatement.setInt(5, obj.getMe());
        preparedStatement.setInt(6, obj.getMs());
        preparedStatement.setInt(7, obj.getHoras());
        preparedStatement.setDouble(8, obj.getTotal());
        
                
        preparedStatement.setInt(9, code);
        preparedStatement.executeUpdate();
        JOptionPane.showMessageDialog(null, "Se actualizó la factura.");
        preparedStatement.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al actualizar factura: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        disconnect();
    }
}

}
