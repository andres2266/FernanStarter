package App;

import Controladores.ControladorAdministrador;
import MoldelosGestores.GestorDeProyecto;
import MoldelosGestores.GestorDeUsuarios;
import Vistas.VistaAdministrador;
import Vistas.VistaGestor;
import Vistas.VistaInversor;

import java.util.Scanner;

import static FuncionesMenus.Menus.menuAdministrador;
import static FuncionesMenus.Menus.menuPrincipal;


public class FernanStarter {
    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        VistaAdministrador vistaAdministrador = new VistaAdministrador();
        VistaInversor vistaInversor = new VistaInversor();
        VistaGestor vistaGestor = new VistaGestor();

        GestorDeUsuarios gestorDeUsuarios = new GestorDeUsuarios();
        GestorDeProyecto gestorDeProyecto = new GestorDeProyecto();
        ControladorAdministrador controladorAdministrador = new ControladorAdministrador(gestorDeUsuarios,vistaAdministrador);

        switch (menuPrincipal()){
            case 1:
                System.out.println("ingresa tu nombre de usuario");
                String nombreDeUsuarioAdministrador = S.nextLine();
                System.out.println("Ingresa la contraseña del usuario");
                String contraseñaAdministrador = S.nextLine();
                controladorAdministrador.inicioDeSecionAdmin(nombreDeUsuarioAdministrador,contraseñaAdministrador);
              switch (menuAdministrador()){
                  case 1:
                      System.out.println("Ingresa el id del usuario que quieras desbloquear");
                      String nombreDesvloqueado = S.nextLine();
                      controladorAdministrador.desbloquearUsuario(nombreDesvloqueado);
                  case 2:
                      System.out.println("Ingresa el id del usuario que quieras bloquear");
                      String nombreBloqueado = S.nextLine();
                      controladorAdministrador.bloquearUsuario(nombreBloqueado);
              }
        }


    }
}
