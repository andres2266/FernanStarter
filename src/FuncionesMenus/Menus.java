package FuncionesMenus;

import java.util.Scanner;

public class Menus {

    public static int menuPrincipal() {
        Scanner S = new Scanner(System.in);
        System.out.println("Como quieres acceder al sistema?");
        System.out.println("1. Administrador");
        System.out.println("2. Gestor");
        System.out.println("3. Inversor 1");
        System.out.println("4. Inversor 2");
        System.out.println("5. Crear nuevo Usuario");
        int opcion = Integer.parseInt(S.next());
        return opcion;
    }

    public static int menuAdministrador(){
        Scanner S = new Scanner(System.in);
            System.out.println("1: desbloqueo de usuarios");
            System.out.println("2: bloquear usario");
            System.out.println("3: Ver proyectos");
            System.out.println("4: Cambios de credenciales");
            System.out.println("5: Cerrar sesion");
        int opcion = Integer.parseInt(S.next());
        return opcion;
        }


    }

