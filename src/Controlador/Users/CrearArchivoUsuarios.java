/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Users;

import Modelo.Usuario;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;


public class CrearArchivoUsuarios {
    public CrearArchivoUsuarios(Usuario usu){
        try {
            Properties properties = new Properties();
            properties.setProperty(usu.getCodigo() + "codigo", String.valueOf(usu.getCodigo()));
            properties.setProperty(usu.getCodigo() + "nombre", usu.getNombre());
            properties.setProperty(usu.getCodigo() + "correo", usu.getCorreo());
            properties.setProperty(usu.getCodigo() + "password", usu.getContraseña());
            properties.setProperty(usu.getCodigo() + "nivel", String.valueOf(usu.getNivel()));

            FileOutputStream fileOut = new FileOutputStream("users.properties", true);
            properties.store(fileOut, null);
            fileOut.close();

            System.out.println("Datos guardados conrrectamente en el archivo");
        } catch (IOException e) {
            System.out.println("Error al guardar los datos en el archivo");
        }
    }
}
