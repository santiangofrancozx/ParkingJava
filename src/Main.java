import Controlador.Users.ControladorCrearUsuario;
import Controlador.Users.ControladorModificarUsuario;
import Modelo.Delete_DB;
import Modelo.Crear_BD;
import Vista.*;
import Controlador.*;
import Vista.Users.Crear_Usuario;
import Vista.DataBase.*;
import Modelo.*;
import Vista.Users.EditarU;

import java.util.ArrayList;


public class Main{
    public static void main(String[] args) {
        DataBase modelo = new DataBase();
        PrincipalMenu menu = new PrincipalMenu();
        Crear_Usuario cu = new Crear_Usuario(null, true);
        Usuario us = new Usuario();
        ControladorCrearUsuario cCU = new ControladorCrearUsuario(us, cu);
        EditarU editUgui = new EditarU(null, true);
        ControladorModificarUsuario cmu = new ControladorModificarUsuario(editUgui, us);
        Crear_DataBase crearDB = new Crear_DataBase(null, true);
        Delete_DB dDB = new Delete_DB();
        Crear_BD createDB = new Crear_BD();
        ControladorInicio cIni = new ControladorInicio(menu);
        ControladorMenu cMenu = new ControladorMenu(menu, cu, crearDB, dDB, editUgui);
        ControladorDB cDB = new ControladorDB(modelo, crearDB, createDB);
        cIni.inicio();
    }
}
