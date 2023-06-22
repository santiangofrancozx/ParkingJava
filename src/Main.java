
import Users.Crear_Usuario;
import Users.EditarU;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame{
    JMenuBar barra;
    JMenu bd, login, usuario, vehiculo; 
    JMenuItem crearBD, eliminarBD, login1, logout, crearU, modificarU, verU, ingresarVe, salidaVe, buscarRe, modificarRe, buscarF, valorHora;
    public Main(){
        barra = new JMenuBar();
        
        bd = new JMenu("Base de Datos");
        crearBD = new JMenuItem("Crear Base de Datos");
        eliminarBD = new JMenuItem("Eliminar Base de Datos");
        
        login = new JMenu("Login");
        login1 = new JMenuItem("Iniciar Sesion");
        logout = new JMenuItem("Cerrar Sesion");
        
        usuario = new JMenu("Usuario");
        crearU = new JMenuItem("Crear");
        modificarU = new JMenuItem("Modificar");
        verU = new JMenuItem("Visualizar/Eliminar");
        
        vehiculo = new JMenu("Vehiculos");
        ingresarVe = new JMenuItem("Ingresar");
        salidaVe = new JMenuItem("Salida");
        buscarRe = new JMenuItem("Buscar Registros");
        modificarRe = new JMenuItem("Modificar Registros");
        buscarF = new JMenuItem("Buscar Factura");
        valorHora = new JMenuItem("Valor Hora");
        
        setJMenuBar(barra);
        barra.add(bd);
        barra.add(login);
        barra.add(usuario);
        barra.add(vehiculo);
        
        bd.add(crearBD);
        bd.add(eliminarBD);
        
        login.add(login1);
        login.add(logout);
        
        usuario.add(crearU);
        usuario.add(modificarU);
        usuario.add(verU);
        
        vehiculo.add(ingresarVe);
        vehiculo.add(salidaVe);
        vehiculo.add(buscarRe);
        vehiculo.add(modificarRe);
        vehiculo.add(buscarF);
        vehiculo.add(valorHora);
        
        crearU.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Crear_Usuario(null, true);
            }
        });
        
        modificarU.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new EditarU(null, true);
            }
        });
        
        setSize(360,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    public static void main(String[] args) {
        new Main();
    }
}
