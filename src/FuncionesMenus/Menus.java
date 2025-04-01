package FuncionesMenus;

import java.util.Scanner;

public class Menus {

    public static int menuPrincipal() {
        Scanner S = new Scanner(System.in);
        System.out.println("Cómo quieres acceder al sistema?");
        System.out.println("1. Administrador");
        System.out.println("2. Gestor");
        System.out.println("3. Inversor");
        System.out.println("4. Crear nuevo Usuario");
        int opcion = Integer.parseInt(S.next());
        return opcion;
    }

    public static int menuAdministrador() {
        Scanner S = new Scanner(System.in);
        System.out.println("1: Desbloqueo de usuarios");
        System.out.println("2: Bloquear usario");
        System.out.println("3: Ver proyectos");
        System.out.println("4: Cambios de credenciales");
        System.out.println("5: Ordenar todos los proyectos por orden de invercion");
        System.out.println("6: Cerrar sesión");
        int opcion = Integer.parseInt(S.next());
        return opcion;
    }

    public static int muenuGestor() {
        Scanner S = new Scanner(System.in);
        System.out.println("1: Ver todos los proyectos creados por el gestor");
        System.out.println("2: Crear proyecto");
        System.out.println("3: Eliminar proyecto");
        System.out.println("4: Gráfico");
        System.out.println("5: Cambio de credenciales");
        System.out.println("6  Buscar un proyecto");
        System.out.println("7 Agregar recompensa a proyecto");
        System.out.println("8: Ver recompensas de proyecto");
        System.out.println("9: Ordenar Array por orden de importe financiado");
        System.out.println("10: Cerrar sesión");
        int opcion = S.nextInt();
        return opcion;
    }

    public static int muenuInversor() {
        Scanner S = new Scanner(System.in);
        System.out.println("1: Ver todas mis inversiones");
        System.out.println("2: Ver todos los proyectos");
        System.out.println("3: Ver saldo de cartera");
        System.out.println("4: Aumentar saldo");
        System.out.println("5  Disminuir saldo");
        System.out.println("6: Ver amigos");
        System.out.println("7: Añadir amigos");
        System.out.println("8: Cambiar credenciales");
        System.out.println("9: Invertir");
        int opcion = S.nextInt();
        return opcion;
    }


    public static int muenuCreacionUsuarios() {
        Scanner S = new Scanner(System.in);
        System.out.println("1: Crear un gestor");
        System.out.println("2: Crear Inversor");
        int opcion = S.nextInt();
        return opcion;

    }
}

