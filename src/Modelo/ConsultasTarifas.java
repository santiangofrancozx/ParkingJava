package Modelo;

import javax.swing.*;
import java.sql.PreparedStatement;
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
}
