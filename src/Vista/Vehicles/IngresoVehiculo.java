package Vista.Vehicles;

import javax.swing.*;
import java.awt.*;

public class IngresoVehiculo extends JDialog {

    JLabel LabelUsuarios, placaFormat;
    public JButton bMostrarTodos, bMostrar, bValidar, bCancelar;
    public JTextField textPlacaFormat;
    public JTextArea areaCupos;
    public JComboBox<String> nivelesUsuarios;
    public JScrollPane scrollBar;

    public String[] carros = {" 1", "  2", "  3", "  4", "  5", "  6", "  7", "  8", "  9", "10"};
    public  String[] motos = {"11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
    public String[] bicicletas = {"21", "22", "23", "24", "25"};






    public String updateM(){
        String M = "";
        for(int i = 0; i < carros.length; i++){
            M += carros[i] + "    ";
        }
        M += "\n\n";
        for(int i = 0; i < motos.length; i++){
            M += motos[i] + "    ";
        }
        M += "\n\n";
        for(int i = 0; i < bicicletas.length; i++){
            M += bicicletas[i] + "    ";
        }
        return M;
    }

    public IngresoVehiculo(Frame papa, boolean modal){
        super(papa, modal);
        String []niveles = {"moto", "carro", "bicicleta"};
        setTitle("Ingreso vehiculos");






        areaCupos = new JTextArea(10, 20);
        areaCupos.setBounds(50, 100, 600, 150);
        scrollBar = new JScrollPane(areaCupos, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollBar.setBounds(150, 100, 400, 130);
        areaCupos.setText(updateM());

        bMostrar = new JButton("Mostrar");
        bMostrar.setBounds(300, 30, 100, 30);

        LabelUsuarios = new JLabel("Usuarios:");
        LabelUsuarios.setBounds(50, 30, 100, 30);


        bMostrarTodos = new JButton("Mostrar Todos");
        bMostrarTodos.setBounds(400, 30, 200, 30);

        bValidar = new JButton("Validar");
        bValidar.setBounds(450, 280, 100, 30);

        bCancelar = new JButton("Cancelar");
        bCancelar.setBounds(280, 330, 100, 30);

        textPlacaFormat = new JTextField(10);
        textPlacaFormat.setBounds(220, 280, 200, 30);


        nivelesUsuarios = new JComboBox<>(niveles);
        nivelesUsuarios.setBounds(140, 30, 100, 30);

        placaFormat = new JLabel("V-P-PLACA-HE-ME");
        placaFormat.setBounds(80, 280, 200, 30);


        add(LabelUsuarios);
        add(nivelesUsuarios);
        add(bMostrar);
        add(bMostrarTodos);
        add(scrollBar);
        add(bValidar);
        add(bCancelar);
        add(placaFormat);
        add(textPlacaFormat);

    }


    

}
