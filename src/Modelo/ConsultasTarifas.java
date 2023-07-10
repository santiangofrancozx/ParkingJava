package Modelo;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasTarifas extends Conexion {

    public ConsultasTarifas(){

    }

    public void update(ObjetoTarifas obj){

        try
        {
            connect();
            String sql = "UPDATE tarifas SET valor = ? WHERE tipo = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, obj.getValor());
            preparedStatement.setString(2, obj.getTipo());
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se actualizo la tarifa\n");
            preparedStatement.close();
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error al actualizar tarifa " + e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
        } finally {
            disconnect();
        }

    }

    public double findTarifa(String tipo){
        double tarifa = 0;
        try
        {
            connect();
            String sql = "SELECT * FROM tarifas WHERE tipo = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tipo);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                tarifa = resultSet.getDouble("valor");
            }
            preparedStatement.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar tarifa: " + e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
        } finally {
            disconnect();
        }

        return tarifa;
    }
}
