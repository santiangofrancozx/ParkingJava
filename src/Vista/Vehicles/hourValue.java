/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.Vehicles;

import java.awt.*;
import javax.swing.*;


public class hourValue extends JDialog{
    
    JTextField caja_hCarro, caja_hMoto, caja_hBicicleta;
    JLabel hCarro, hMoto, hBicicleta; 
    JButton bGuardar, bCancelar;
   
    public hourValue(Frame e, boolean modal){
        super(e, modal);
        setTitle("                                  Valor Hora");
        
        
        hCarro = new JLabel("Hora Carro");
        hCarro.setBounds(30, 20, 100, 30);
        add(hCarro);
        
        caja_hCarro = new JTextField();
        caja_hCarro.setBounds(120, 26, 150, 20);
        add(caja_hCarro);
        
        hMoto = new JLabel("Hora Moto");
        hMoto.setBounds(30, 65, 100, 30);
        add(hMoto);
        
        caja_hMoto = new JTextField();
        caja_hMoto.setBounds(120, 71, 150, 20);
        add(caja_hMoto);
        
        hBicicleta = new JLabel("Hora Bicicleta");
        hBicicleta.setBounds(30, 110, 100, 30);
        add(hBicicleta);
        
        caja_hBicicleta = new JTextField();
        caja_hBicicleta.setBounds(120, 116, 150, 20);
        add(caja_hBicicleta);
        
        bGuardar = new JButton("Guardar");
        bGuardar.setBounds(50, 165, 80, 19);
        add(bGuardar);
        
        bCancelar = new JButton("Cancelar");
        bCancelar.setBounds(150, 165, 90, 19);
        add(bCancelar);
        
        setSize(300,240);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
}
