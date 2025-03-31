package App;
import Controladores.ControladorAdministrador;
import Controladores.ControladorDeProyecto;
import Controladores.ControladorGestor;
import Controladores.ControladorInversor;
import Modelos.*;
import MoldelosGestores.GestorDeProyecto;
import MoldelosGestores.GestorDeUsuarios;
import Vistas.VistaAdministrador;
import Vistas.VistaGestor;
import Vistas.VistaInversor;
import Vistas.VistaProyecto;

import java.time.LocalDate;
import java.util.Scanner;

import static FuncionesMenus.Menus.*;


public class FernanStarter {
    public static void main(String[] args) {

        Scanner S = new Scanner(System.in);
        /*Usuarios por defecto*/
        Administrador administradorPorDefecto = new Administrador("Andres","andrevelezg42@gmail.com","1234");
        Gestor gestorPorDefecto = new Gestor("Sergi","andrevelezg42@gmail.com","1234");
        Inversor inversorPorDefecto = new Inversor("Marcos","andrevelezg42@gmail.com","1234",0);

        System.out.println(gestorPorDefecto);

        VistaAdministrador vistaAdministrador = new VistaAdministrador();
        VistaInversor vistaInversor = new VistaInversor();
        VistaGestor vistaGestor = new VistaGestor();
        VistaProyecto vistaProyecto = new VistaProyecto();

        GestorDeUsuarios gestorDeUsuarios = new GestorDeUsuarios();
        GestorDeProyecto gestorDeProyecto = new GestorDeProyecto();


        ControladorAdministrador controladorAdministrador = new ControladorAdministrador(gestorDeUsuarios, vistaAdministrador);
        ControladorDeProyecto controladorDeProyecto = new ControladorDeProyecto(gestorDeProyecto, vistaProyecto);
        ControladorGestor controladorGestor = new ControladorGestor(gestorDeUsuarios,vistaGestor,gestorDeProyecto);
        ControladorInversor controladorInversor = new ControladorInversor(gestorDeUsuarios,vistaInversor);

        gestorDeUsuarios.agregarUsuarios(administradorPorDefecto);
        gestorDeUsuarios.agregarUsuarios(gestorPorDefecto);
        gestorDeUsuarios.agregarUsuarios(inversorPorDefecto);

        String nombreDeUsuarioGestor = "";
        String nombreDeUsuarioInversor = "";

        int opcionesDeMenu = 0;
        int opcionesDeAdmin = 0;
        int opcionesDeGestor = 0;
        int opcionesInversor = 0;
        int intentosDeGestor = 2;
        int intentosInversor = 2;


        boolean credencialesAdmin;
        boolean credencialesGestor = false;
        boolean credencialesInversor = false;

        while (opcionesDeMenu != 6) {
            switch (opcionesDeMenu=menuPrincipal()) {
                case 1:
                do {
                    System.out.println("ingresa tu nombre de usuario");
                    String nombreDeUsuarioAdministrador = S.nextLine();
                    System.out.println("Ingresa la contraseña del usuario");
                    String contraseñaAdministrador = S.nextLine();
                   credencialesAdmin = controladorAdministrador.inicioDeSecionAdmin(nombreDeUsuarioAdministrador, contraseñaAdministrador);
                }while (!credencialesAdmin);
                    while (opcionesDeAdmin !=6 ){
                        opcionesDeAdmin=menuAdministrador();
                        switch (opcionesDeAdmin) {
                            case 1:
                                System.out.println("Ingresa el id del usuario que quieras desbloquear");
                                String nombreDesvloqueado = S.nextLine();
                                controladorAdministrador.desbloquearUsuario(nombreDesvloqueado);
                                break;
                            case 2:
                                System.out.println("Ingresa el id del usuario que quieras bloquear");
                                String nombreBloqueado = S.nextLine();
                                controladorAdministrador.bloquearUsuario(nombreBloqueado);
                                break;
                            case 3:
                                controladorDeProyecto.verTodosLosProyectos();
                                break;
                            case 4:
                                System.out.println("Escribe el id del proyecto que deseas eliminar");
                                String idDeProyecto = S.nextLine();
                                controladorAdministrador.eliminarProyecto(idDeProyecto);
                                break;
                            case 5:
                                System.out.println("Escribe el usuario al que quieres cambiar la contraseña");
                                String nombreDeUsuario = S.nextLine();
                                System.out.println("Escribe el nuevo nombre de usaurio");
                                String nuevoNombreDeUsuario = S.nextLine();
                                System.out.println("Escribe la nueva contraseña");
                                String nuevaContraseña = S.nextLine();
                                controladorAdministrador.cambiarUsuarioDeAdministrador(nombreDeUsuario, nuevoNombreDeUsuario);
                                controladorAdministrador.cambiarContraseñaAdministrdor(nuevaContraseña, nombreDeUsuario);
                                break;
                        }
                    }
                    break;
                case 2:
                    do {
                        System.out.println("ingresa tu nombre de usuario");
                        nombreDeUsuarioGestor = S.nextLine();
                        System.out.println("Ingresa la contraseña del usuario");
                        String contraseñaGestor = S.nextLine();

                        if(gestorDeUsuarios.buscarUsuario(nombreDeUsuarioGestor).isBloqueado()){
                            controladorGestor.usuarioBloqueado(nombreDeUsuarioGestor);
                            System.out.println("Escribe 1 para cerrar secion");
                            int cerrar = S.nextInt();
                            if(cerrar==1){
                              credencialesInversor = true;
                              opcionesDeGestor = 6;
                            }
                        }else{
                            credencialesGestor = controladorGestor.inicioDeSecionGestor(nombreDeUsuarioGestor,contraseñaGestor);
                            if(!credencialesGestor){
                                intentosDeGestor--;
                                if(intentosDeGestor==0){
                                    controladorGestor.bloquearGestor(nombreDeUsuarioGestor);
                                }
                            }
                        }
                    }while (!credencialesGestor);
                    while (opcionesDeGestor !=7 ) {
                        switch (opcionesDeGestor = muenuGestor()) {
                            case 1:
                                controladorGestor.verProyectos(nombreDeUsuarioGestor);
                                break;
                            case 2:
                                System.out.println("Escribe el id del proyecto");
                                String id = S.nextLine();
                                System.out.println("Escribe el nombre del proyecto:");
                                String nombre = S.nextLine();

                                System.out.println("Escribe la descripción del proyecto:");
                                String descripcion = S.nextLine();

                                System.out.println("Escribe la categoria");
                                String categoria = S.nextLine();


                                System.out.println("Escribe la cantidad necesaria:");
                                int cantidadNecesaria = S.nextInt();

                                System.out.println("Escribe la cantidad financiada:");
                                int cantidadFinanciada = S.nextInt();

                                System.out.println("Escribe el año de apertura:");
                                int año = S.nextInt();
                                System.out.println("Escribe el mes de apertura:");
                                int mes = S.nextInt();
                                System.out.println("Escribe el día de apertura:");
                                int dia =S.nextInt();
                                LocalDate fechaInicio = LocalDate.of(año ,mes, dia);

                                System.out.println("Escribe el año de fin:");
                                int yearFin = S.nextInt();
                                System.out.println("Escribe el mes de fin:");
                                int monthFin = S.nextInt();
                                System.out.println("Escribe el día de fin:");
                                int dayFin =S.nextInt();
                                LocalDate fechaDeFin = LocalDate.of(yearFin, monthFin, dayFin);

                                System.out.println("Escribe la cantidad de recompensas:");
                                float recompensas = S.nextFloat();
                                controladorGestor.crearProyecto(nombre,descripcion,Categoria.valueOf(categoria),cantidadNecesaria,cantidadFinanciada,fechaInicio,recompensas,fechaDeFin,id,nombreDeUsuarioGestor);
                                break;
                            case 3:
                                System.out.println("Escribir id de proyecto que quieres eliminar");
                                String proyectoId = S.nextLine();
                                controladorGestor.eliminarProyecto(proyectoId,nombreDeUsuarioGestor);
                                break;
                            case 4:

                            case 5:
                                System.out.println("Escribe tu nuevo nombre de usuario");
                                String nuevoNombreDeUsuario = S.nextLine();
                                System.out.println("Escribe tu contraseña");
                                String nuevaContraseña = S.nextLine();
                                controladorGestor.cambiarUsuarioGestor(nombreDeUsuarioGestor,nuevoNombreDeUsuario);
                                controladorGestor.cambiarContraseñaDeUsuario(nombreDeUsuarioGestor,nuevaContraseña);
                                break;
                            case 6 :
                                System.out.println("Escribe el id del proyecto que buscas");
                                String idDeProyectoBuscado = S.nextLine();
                                gestorDeProyecto.buscarProyecto(idDeProyectoBuscado);
                                break;
                        }
                    }
                    break;
                case 3 :
                    do {
                        System.out.println("ingresa tu nombre de usuario");
                        nombreDeUsuarioInversor = S.next();
                        System.out.println("Ingresa la contraseña del usuario");
                        String contraseñaInversor = S.next();
                        if(gestorDeUsuarios.buscarUsuario(nombreDeUsuarioInversor).isBloqueado()){
                            controladorInversor.bloquearInversor(nombreDeUsuarioInversor);
                            System.out.println("Usuario bloqueado");
                            System.out.println("Escribe 1 para cerrar secion");
                            int cerrar = S.nextInt();
                            if(cerrar==1){
                                credencialesInversor = true;
                                opcionesInversor = 6;
                            }
                        }else{
                            credencialesInversor = controladorInversor.inicioDeSecionInversor(nombreDeUsuarioInversor,contraseñaInversor);
                            if(!credencialesInversor){
                                intentosInversor--;
                                if(intentosInversor==0){
                                    controladorInversor.bloquearInversor(nombreDeUsuarioInversor);
                                }
                            }
                        }
                    }while (!credencialesInversor);
                    while (opcionesInversor !=6 ) {
                        opcionesInversor = muenuInversor();
                        switch (opcionesInversor) {
                            case 1:
                                controladorInversor.misInversiones(nombreDeUsuarioInversor);
                                break;
                            case 2:
                                controladorDeProyecto.verTodosLosProyectos();
                                break;
                            case 3:
                                controladorInversor.verCartera(nombreDeUsuarioInversor);
                                break;
                            case 4:
                                System.out.println("Cuanto quieres añadir a la cartera");
                                int nuevoCredito = S.nextInt();
                                controladorInversor.añadirCreditoAcartera(nuevoCredito, nombreDeUsuarioInversor);
                                break;
                            case 5:
                                System.out.println("Cuanto quieres restar a la cartera");
                                int restarACartera = S.nextInt();
                                controladorInversor.restarCreditoAcartera(restarACartera, nombreDeUsuarioGestor);
                            case 6:
                                System.out.println("Escribe tu nuevo nombre de usuario");
                                String nuevoNombreDeUsuario = S.nextLine();
                                System.out.println("Escribe tu contraseña");
                                String nuevaContraseña = S.nextLine();
                                controladorGestor.cambiarUsuarioGestor(nombreDeUsuarioInversor, nuevoNombreDeUsuario);
                                controladorGestor.cambiarContraseñaDeUsuario(nombreDeUsuarioInversor, nuevaContraseña);
                                break;
                            case 7:
                                controladorInversor.mostrarAmigosDelIversor(nombreDeUsuarioInversor);
                            case 8:
                                System.out.println("Ingresa el nombre del amigo");
                                String nombreDeAmigo = S.nextLine();
                                System.out.println("Ingresar correo de amigo");
                                String correoDeAmigo = S.nextLine();
                                Amigo nuevoAmigo = new Amigo(nombreDeAmigo, correoDeAmigo);
                                controladorInversor.añadirAmigoDeInversor(nuevoAmigo, nombreDeUsuarioInversor);
                                break;
                            case 9:
                                System.out.println("Escribe el id del proyecto en el que quieres invertir");
                                String proyecto = S.next();
                                System.out.println("cuanto quieres invertir");
                                int inversion = S.nextInt();
                                System.out.println("Escribe el año de la inversion:");
                                int año = S.nextInt();
                                System.out.println("Escribe el mes de la inversion:");
                                int mes = S.nextInt();
                                System.out.println("Escribe el día de la inversion:");
                                int dia = S.nextInt();
                                LocalDate fechaIversion = LocalDate.of(año, mes, dia);
                                controladorInversor.invertir(nombreDeUsuarioInversor, gestorDeProyecto.buscarProyecto(proyecto), inversion, fechaIversion);
                                break;
                        }
                    }
                        break;
                case 5:
                    switch (muenuCreacionUsuarios()){
                        case 1:
                            System.out.print("Ingrese su nombre: ");
                            String nombreGestor = S.nextLine();
                            System.out.print("Ingrese su contraseña: ");
                            String contraseñaGestor = S.nextLine();
                            System.out.print("Ingrese su correo electrónico: ");
                            String correoGestor = S.nextLine();
                            Gestor gestor = new Gestor(nombreGestor,correoGestor,contraseñaGestor);
                            controladorGestor.añadirGestorAGestorDeUsuarios(gestor);
                            break;
                        case 2 :
                            System.out.print("Ingrese su nombre: ");
                            String nombreInversor = S.nextLine();
                            System.out.print("Ingrese su contraseña: ");
                            String contraseñaInversor = S.nextLine();
                            System.out.print("Ingrese su correo electrónico: ");
                            String correoInversor = S.nextLine();
                            Gestor Inversor = new Gestor(nombreInversor,correoInversor,contraseñaInversor);
                            controladorInversor.añadirInversorAGestorDeUsuarios(Inversor);
                            break;
                    }
            }
        }
    }
}

