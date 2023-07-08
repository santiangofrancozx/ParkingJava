package Controlador.Users;

import Modelo.ConsultasUsuarios;
import Modelo.Usuario;
import Vista.Users.Eliminar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorVizualizarEliminar implements ActionListener {
    Eliminar vista;
    ConsultasUsuarios modelo;
    Usuario us = new Usuario();
    public ControladorVizualizarEliminar(){

        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.bbuscar){
            if (vista.nivelesUsuarios.getSelectedIndex() == 0){
                
            }
        }
    }


}
