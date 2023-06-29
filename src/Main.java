
import Vista.*;
import Controlador.*;
import Vista.Users.Crear_Usuario;
//import Modelo.*;


public class Main{
    public static void main(String[] args) {
        PrincipalMenu menu = new PrincipalMenu();
        Crear_Usuario cu = new Crear_Usuario(null, true);
        ControladorInicio cIni = new ControladorInicio(menu);
        ControladorMenu cMenu = new ControladorMenu(menu, cu);
        cIni.inicio();
    }
}
