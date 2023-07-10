import Controlador.Users.ControladorCrearUsuario;
import Controlador.Users.ControladorLogeo;
import Controlador.Users.ControladorModificarUsuario;
import Controlador.Users.ControladorVizualizarEliminar;
import Modelo.Delete_DB;
import Modelo.Crear_BD;
import Vista.*;
import Controlador.*;
import Vista.Login.Login;
import Vista.Users.Crear_Usuario;
import Vista.DataBase.*;
import Modelo.*;
import Vista.Users.EditarU;
import Vista.Users.Eliminar;
import Vista.Vehicles.*;


import java.util.ArrayList;


public class Main{
    public static void main(String[] args) {
        Eliminar vistaEliminar = new Eliminar(null, true);
        DataBase modelo = new DataBase();
        PrincipalMenu menu = new PrincipalMenu();
        Crear_Usuario cu = new Crear_Usuario(null, true);
        Usuario us = new Usuario();
        ControladorCrearUsuario cCU = new ControladorCrearUsuario(us, cu);
        EditarU editUgui = new EditarU(null, true);
        ControladorModificarUsuario cmu = new ControladorModificarUsuario(editUgui, us);
        Crear_DataBase crearDB = new Crear_DataBase(null, true);
        Crear_BD createDB = new Crear_BD();
        Delete_DB dDB = new Delete_DB();
        IngresoVehiculo ingVh = new IngresoVehiculo(null, true);
        SalidaVehiculo salVh = new SalidaVehiculo(null, true);
        ConsultasUsuarios cosun = new ConsultasUsuarios();
        BuscarRegistros buscRe = new BuscarRegistros(null, true);
        Login log = new Login(null, true);
        ControladorLogeo cLog = new ControladorLogeo(log, menu, us, cosun);
        ModificarRegistros modRe = new ModificarRegistros(null, true);
        BuscarFactura buscF = new BuscarFactura(null, true);
        hourValue hourV = new hourValue(null, true);

        ControladorBuscarFactura bDhc = new ControladorBuscarFactura(buscF);
        ControladorTarifas coTf = new ControladorTarifas(hourV);
        ControladorVizualizarEliminar cVe = new ControladorVizualizarEliminar(vistaEliminar, cosun);
        ControladorInicio cIni = new ControladorInicio(menu);
        ControladorMenu cMenu = new ControladorMenu(menu, cu, crearDB, dDB, editUgui, log, vistaEliminar, ingVh, salVh, buscRe, modRe, buscF, hourV);
        ControladorDB cDB = new ControladorDB(modelo, crearDB, createDB);
        ConsultasIngresoVehiculos consulIvh = new ConsultasIngresoVehiculos();



        COntroladorIngresoVehiculo contVh = new COntroladorIngresoVehiculo(ingVh);
        cIni.inicio();
    }
}