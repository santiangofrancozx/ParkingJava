/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class ObtenerDB {

    public String ObtenerDB() {
        Properties propiedades = new Properties();
        FileInputStream archivo = null;
        String fileDB = "dbinfo.properties";
        String name[];
        String retorno = "";
        try {
            archivo = new FileInputStream(fileDB);
            propiedades.load(archivo);
            name = new String[propiedades.size()];
            for (int i = 0; i < propiedades.size(); i++) {
                name[i] = propiedades.getProperty("bd" + i);
            }
            FileOutputStream fileOut = new FileOutputStream(fileDB);
            String emptyContent = "";
            fileOut.write(emptyContent.getBytes());
            fileOut.close();
            
            retorno = name[name.length - 1];
            
            Properties propiedades1 = new Properties();
            FileInputStream archivo1 = null;
            String fileDB1 = "dbinfo.properties";
            for (int i = 0; i < name.length - 1; i++) {
                propiedades1.setProperty("bd" + i, name[i]);
                System.out.println(name[i]);
            }
            FileOutputStream fileOut1 = new FileOutputStream(fileDB1, true);
            propiedades1.store(fileOut1, null);
            fileOut1.close();
        } catch (Exception e) {
        }
        return retorno;
    }
}