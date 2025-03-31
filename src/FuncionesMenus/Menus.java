package FuncionesMenus;

import java.util.Scanner;

public class Menus {

    public static int menuPrincipal() {
        Scanner S = new Scanner(System.in);
        System.out.println("Como quieres acceder al sistema?");
        System.out.println("1. Administrador");
        System.out.println("2. Gestor");
        System.out.println("4. Inversor");
        System.out.println("5. Crear nuevo Usuario");
        int opcion = Integer.parseInt(S.next());
        return opcion;
    }

    public static int menuAdministrador() {
        Scanner S = new Scanner(System.in);
        System.out.println("1: desbloqueo de usuarios");
        System.out.println("2: bloquear usario");
        System.out.println("3: Ver proyectos");
        System.out.println("4: Cambios de credenciales");
        System.out.println("6: Cerrar sesion");
        int opcion = Integer.parseInt(S.next());
        return opcion;
    }

    public static int muenuGestor() {
        Scanner S = new Scanner(System.in);
        System.out.println("1: ver todos los proyectos creados por el gestor");
        System.out.println("2: crear proyecto");
        System.out.println("3: eliminar proyecto");
        System.out.println("4: grafico");
        System.out.println("5: cambio de credenciales");
        System.out.println("6  buscar un proyecto");
        System.out.println("7: cerrar cecion");
        int opcion = S.nextInt();
        return opcion;
    }

    public static int muenuInversor() {
        Scanner S = new Scanner(System.in);
        System.out.println("1: ver todas mis inversiones");
        System.out.println("2: ver todos los proyectos");
        System.out.println("3: ver saldo de cartera");
        System.out.println("4: aumentar saldo");
        System.out.println("5  desminuir saldo");
        System.out.println("6: ver amigos");
        System.out.println("7: añadir amigos");
        System.out.println("8: cambiar credenciales");
        System.out.println("9: invertir");
        int opcion = S.nextInt();
        return opcion;
    }


    public static int muenuCreacionUsuarios() {
        Scanner S = new Scanner(System.in);
        System.out.println("1: crear un gestor");
        System.out.println("2: crear Inversor");
        int opcion = S.nextInt();
        return opcion;

    }
}

