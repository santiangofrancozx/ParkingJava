package Modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeerNombreDB {

    public LeerNombreDB(){

    }
    public String leerNombreDBMethod(String rutaArchivo) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(rutaArchivo))) {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
