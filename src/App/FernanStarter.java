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
        Administrador administradorPorDefecto = new Administrador("Andres","davidgalan001@gmail.com","1234");
        Gestor gestorPorDefecto = new Gestor("Sergi","davidgalan001@gmail.com","1234");
        Inversor inversorPorDefecto = new Inversor("Marcos","davidgalan001@gmail.com","1234");
        Inversor inversorPorDefecto1 = new Inversor("Andresito","davidgalan001@gmail.com","1234");

        Proyecto proyectoPrueba = new Proyecto("da","da",Categoria.Arte,100,1,LocalDate.of(2000,10,1),LocalDate.of(2000,10,1),"1");

        System.out.println(gestorPorDefecto);

        VistaAdministrador vistaAdministrador = new VistaAdministrador();
        VistaInversor vistaInversor = new VistaInversor();
        VistaGestor vistaGestor = new VistaGestor();
        VistaProyecto vistaProyecto = new VistaProyecto();

        GestorDeUsuarios gestorDeUsuarios = new GestorDeUsuarios();
        GestorDeProyecto gestorDeProyecto = new GestorDeProyecto();

        gestorDeProyecto.añadirProyecto(proyectoPrueba);

        ControladorAdministrador controladorAdministrador = new ControladorAdministrador(gestorDeUsuarios, vistaAdministrador,gestorDeProyecto);
        ControladorDeProyecto controladorDeProyecto = new ControladorDeProyecto(gestorDeProyecto, vistaProyecto);
        ControladorGestor controladorGestor = new ControladorGestor(gestorDeUsuarios,vistaGestor,gestorDeProyecto);
        ControladorInversor controladorInversor = new ControladorInversor(gestorDeUsuarios,vistaInversor);

        gestorDeUsuarios.agregarUsuarios(administradorPorDefecto);
        gestorDeUsuarios.agregarUsuarios(gestorPorDefecto);
        gestorDeUsuarios.agregarUsuarios(inversorPorDefecto);
        gestorDeUsuarios.agregarUsuarios(inversorPorDefecto1);

        String nombreDeUsuarioGestor = "";
        String nombreDeUsuarioInversor = "";

        int opcionesDeMenu = 0;
        int opcionesDeAdmin = 0;
        int opcionesDeGestor = 0;
        int opcionesInversor = 0;
        int intentosDeGestor = 2;
        int intentosInversor = 2;


        boolean credencialesAdmin=false;
        boolean credencialesGestor = false;
        boolean credencialesInversor = false;

        while (opcionesDeMenu != 7) {
            switch (opcionesDeMenu=menuPrincipal()) {
                case 1:
                do {
                    System.out.println("Ingresa tu nombre de usuario");
                    String nombreDeUsuarioAdministrador = S.next();
                    System.out.println("Ingresa la contraseña del usuario");
                    String contraseñaAdministrador = S.next();
                   credencialesAdmin = controladorAdministrador.inicioDeSecionAdmin(nombreDeUsuarioAdministrador, contraseñaAdministrador);
                }while (!credencialesAdmin);
                    while (opcionesDeAdmin !=10 ){
                        opcionesDeAdmin=menuAdministrador();
                        switch (opcionesDeAdmin) {
                            case 1:
                                System.out.println("Ingresa el id del usuario que quieras desbloquear");
                                String nombreDesvloqueado = S.next();
                                controladorAdministrador.desbloquearUsuario(nombreDesvloqueado);
                                break;
                            case 2:
                                System.out.println("Ingresa el id del usuario que quieras bloquear");
                                String nombreBloqueado = S.next();
                                controladorAdministrador.bloquearUsuario(nombreBloqueado);
                                break;
                            case 3:
                                controladorDeProyecto.verTodosLosProyectos();
                                break;
                            case 4:
                                System.out.println("Escribe el id del proyecto que deseas eliminar");
                                String idDeProyecto = S.next();
                                controladorAdministrador.eliminarProyecto(idDeProyecto);
                                break;
                            case 5:
                                System.out.println("Escribe el usuario al que quieres cambiar la contraseña");
                                String nombreDeUsuario = S.next();
                                System.out.println("Escribe el nuevo nombre de usaurio");
                                String nuevoNombreDeUsuario = S.next();
                                System.out.println("Escribe la nueva contraseña");
                                String nuevaContraseña = S.next();
                                controladorAdministrador.cambiarUsuarioDeAdministrador(nombreDeUsuario, nuevoNombreDeUsuario);
                                controladorAdministrador.cambiarContraseñaAdministrdor(nuevaContraseña, nombreDeUsuario);
                                break;
                            case 6:
                                  controladorAdministrador.ordenarTodosLosProyectosPorOrdenDeCantidadFinanciada();
                                  break;
                            case 7:
                                controladorAdministrador.ordenarPorFecha();
                                break;
                            case 8:
                                System.out.println("Escribe el id del proyecto que quieras ordenar por el nombre los inversores");
                                String idProyecto = S.next();
                                controladorAdministrador.mostrarInversionistasOrdenadoPorNombre(idProyecto);
                                break;
                            case 9:
                                System.out.println("Escribe el id del proyecto que quieras ordenar por el importe los inversores");
                                idProyecto = S.next();
                                controladorAdministrador.mostrarInversionistasOrdenadoPorImporte(idProyecto);
                                break;
                        }
                    }
                    break;
                case 2:
                    do {
                        System.out.println("Ingresa tu nombre de usuario");
                        nombreDeUsuarioGestor = S.next();
                        System.out.println("Ingresa la contraseña del usuario");
                        String contraseñaGestor = S.next();

                        if(gestorDeUsuarios.buscarUsuario(nombreDeUsuarioGestor).isBloqueado()){
                            controladorGestor.usuarioBloqueado(nombreDeUsuarioGestor);
                            System.out.println("Escribe 1 para cerrar sesión");
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
                    while (opcionesDeGestor !=13) {
                        switch (opcionesDeGestor = muenuGestor()) {
                            case 1:
                                controladorGestor.verProyectos(nombreDeUsuarioGestor);
                                break;
                            case 2:
                                System.out.println("Escribe el id del proyecto");
                                String id = S.next();
                                System.out.println("Escribe el nombre del proyecto:");
                                String nombre = S.next();

                                System.out.println("Escribe la descripción del proyecto:");
                                String descripcion = S.next();

                                System.out.println("Escribe la categoría");
                                String categoria = S.next();


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
                                controladorGestor.crearProyecto(nombre,descripcion,Categoria.valueOf(categoria),cantidadNecesaria,cantidadFinanciada,fechaInicio,fechaDeFin,id,nombreDeUsuarioGestor);
                                break;
                            case 3:
                                System.out.println("Escribe tu nombre de usuario");
                                String nombreUsuario=S.next();
                                controladorGestor.verProyectos(nombreUsuario);
                                break;
                            case 4:
                                System.out.println("Escribe id de proyecto que quieres eliminar");
                                String proyectoId = S.next();
                                controladorGestor.eliminarProyecto(proyectoId,nombreDeUsuarioGestor);
                                break;
                            case 5:
                                System.out.println("Escribe tu nuevo nombre de usuario");
                                String nuevoNombreDeUsuario = S.next();
                                System.out.println("Escribe tu contraseña");
                                String nuevaContraseña = S.next();
                                controladorGestor.cambiarUsuarioGestor(nombreDeUsuarioGestor,nuevoNombreDeUsuario);
                                controladorGestor.cambiarContraseñaDeUsuario(nombreDeUsuarioGestor,nuevaContraseña);
                                break;
                            case 6 :
                                System.out.println("Escribe el id del proyecto que buscas");
                                String idDeProyectoBuscado = S.next();
                                gestorDeProyecto.buscarProyecto(idDeProyectoBuscado);
                                break;
                            case 7:
                                System.out.println(" Escribe el id de la recompensa ");
                                String idDeRecompensa = S.next();
                                System.out.println("Escribe la descripcion de la recompensa");
                                String descripcionDeProyecto = S.next();
                                System.out.println("Escribe la cantidad de la recompensa");
                                int recompensaDePoryecto = Integer.parseInt(S.next());
                                System.out.println("Escribe el id del proyecto al cual quieres agregar la recompensa");
                                String idDeProyecto = S.next();
                                controladorDeProyecto.añadirRecompensaAProyecto(idDeProyecto,descripcionDeProyecto,recompensaDePoryecto,idDeProyecto);
                                break;

                            case 8:
                                System.out.println("Escribe el id del proyecto que deseas ver sus recompensas");
                                String IdDeProyecto = S.next();
                                controladorDeProyecto.verRecompensasDeProyecto(IdDeProyecto);
                                break;
                            case 9:
                                System.out.println("Escibe el nombre del gestor para ordenar sus proyectos creados");
                                String nombreDeusuarioDeGestor = S.next();
                                controladorGestor.ordenarProyectoPorImporteRealizado(nombreDeusuarioDeGestor);
                                break;
                            case 10:
                                System.out.println("Escibe el nombre del gestor para ordenar sus proyectos creados");
                                String NombreDeusuarioDeGestor = S.next();
                                controladorGestor.ordenarPorFecha(NombreDeusuarioDeGestor);
                                break;
                            case 11:
                                System.out.println("Escribe el id del proyecto que quieras ordenar por el nombre los inversores");
                                String idProyecto = S.next();
                                controladorGestor.mostrarInversionistasOrdenadoPorNombre(idProyecto);
                                break;
                            case 12:
                                System.out.println("Escribe el id del proyecto que quieras ordenar por el importe los inversores");
                                idProyecto = S.next();
                                controladorGestor.mostrarInversionistasOrdenadoPorImporte(idProyecto);
                                break;
                        }

                    }
                    opcionesDeGestor=0;
                    break;
                case 3 :
                    do {
                        System.out.println("Ingresa tu nombre de usuario");
                        nombreDeUsuarioInversor = S.next();
                        System.out.println("Ingresa la contraseña del usuario");
                        String contraseñaInversor = S.next();
                        if(gestorDeUsuarios.buscarUsuario(nombreDeUsuarioInversor).isBloqueado()){
                            controladorInversor.bloquearInversor(nombreDeUsuarioInversor);
                            System.out.println("Usuario bloqueado");
                            System.out.println("Escribe 1 para cerrar sesión");
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
                    while (opcionesInversor !=10 ) {
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
                                System.out.println("¿Cuánto quieres añadir a la cartera?");
                                int nuevoCredito = S.nextInt();
                                controladorInversor.añadirCreditoAcartera(nuevoCredito, nombreDeUsuarioInversor);
                                break;
                            case 5:
                                System.out.println("¿Cuánto quieres restar a la cartera?");
                                int restarACartera = S.nextInt();
                                controladorInversor.restarCreditoAcartera(restarACartera, nombreDeUsuarioInversor);
                            case 6:
                                System.out.println("Escribe tu nuevo nombre de usuario");
                                String nuevoNombreDeUsuario = S.next();
                                System.out.println("Escribe tu contraseña");
                                String nuevaContraseña = S.next();
                                controladorGestor.cambiarUsuarioGestor(nombreDeUsuarioInversor, nuevoNombreDeUsuario);
                                controladorGestor.cambiarContraseñaDeUsuario(nombreDeUsuarioInversor, nuevaContraseña);
                                break;
                            case 7:
                                controladorInversor.mostrarAmigosDelIversor(nombreDeUsuarioInversor);
                            case 8:
                                System.out.println("Ingresa el nombre del amigo");
                                String nombreDeAmigo = S.next();
                                System.out.println("Ingresa el correo de amigo");
                                String correoDeAmigo = S.next();
                                Amigo nuevoAmigo = new Amigo(nombreDeAmigo, correoDeAmigo);
                                controladorInversor.añadirAmigoDeInversor(nuevoAmigo, nombreDeUsuarioInversor);
                                break;
                            case 9:
                                System.out.println("Escribe el id del proyecto en el que quieres invertir");
                                String proyecto = S.next();
                                System.out.println("¿Cuánto quieres invertir?");
                                int inversion = S.nextInt();
                                System.out.println("Escribe el año de la inversión:");
                                int año = S.nextInt();
                                System.out.println("Escribe el mes de la inversión:");
                                int mes = S.nextInt();
                                System.out.println("Escribe el día de la inversión:");
                                int dia = S.nextInt();
                                LocalDate fechaIversion = LocalDate.of(año, mes, dia);
                                controladorInversor.invertir(nombreDeUsuarioInversor, gestorDeProyecto.buscarProyecto(proyecto), inversion, fechaIversion);
                                break;

                        }
                    }
                    opcionesInversor = 0;
                        break;
                case 4:
                    switch (muenuCreacionUsuarios()){
                        case 1:
                            System.out.print("Ingrese su nombre: ");
                            String nombreGestor = S.next();
                            System.out.print("Ingrese su contraseña: ");
                            String contraseñaGestor = S.next();
                            System.out.print("Ingrese su correo electrónico: ");
                            String correoGestor = S.next();
                            Gestor gestor = new Gestor(nombreGestor,correoGestor,contraseñaGestor);
                            controladorGestor.añadirGestorAGestorDeUsuarios(gestor);
                            break;
                        case 2 :
                            System.out.print("Ingrese su nombre: ");
                            String nombreInversor = S.next();
                            System.out.print("Ingrese su contraseña: ");
                            String contraseñaInversor = S.next();
                            System.out.print("Ingrese su correo electrónico: ");
                            String correoInversor = S.next();
                            Inversor Inversor = new Inversor(nombreInversor,correoInversor,contraseñaInversor);
                            controladorInversor.añadirInversorAGestorDeUsuarios(Inversor);
                            break;
                    }
            }
        }
    }
}

