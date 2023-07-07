/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.DataBase;
import java.io.*;
import java.util.*;

public class CrearArchivo {

    public CrearArchivo(String bd) {
        Properties propiedades = new Properties();
        FileInputStream archivo = null;
        String fileDB = "dbinfo.properties";
        File file = new File(fileDB);
        if (file.exists()) {
            try {
                archivo = new FileInputStream(fileDB);
                propiedades.load(archivo);
                int valor = 0;
                if (propiedades.isEmpty()) {
                    propiedades.setProperty("bd" + valor, bd);

                } else {
                    valor = propiedades.size();
                    propiedades.setProperty("bd" + valor, bd);
                }
                FileOutputStream fileOut = new FileOutputStream(fileDB, true);
                propiedades.store(fileOut, null);
                fileOut.close();
            } catch (IOException e) {
                System.err.println(e);
            }
        } else {
            try {
                int valor = 0;
                propiedades.setProperty("bd" + valor, bd);
                FileOutputStream fileOut = new FileOutputStream(fileDB, true);
                propiedades.store(fileOut, null);
                fileOut.close();

            } catch (Exception e) {

            }

        }
    }
}
