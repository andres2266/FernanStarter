package Vistas;

import Modelos.Proyecto;

import java.util.ArrayList;
import java.util.Scanner;

public class VistaGestor implements Credenciales {
    Scanner S = new Scanner(System.in);

    public void inicioDeSecion(){System.out.println("Ingrese su id");}

    public void idNoValido(){System.out.println("el id proporcido no es valido");}

    public String inicioDeSecionCodigo(){
        System.out.println("ingrese el codigo de verificacion");
        String codigo = S.nextLine();
        return codigo;
    }

    public void pedirUsuario(){
        System.out.println("Por facor introdusca el nombre De Usuario/Alias");
    }

    public void PedirContraseña(){
        System.out.println("Por favor introdusca su contraseña");
    }

    public void saludarUsuario(){
        System.out.println("Bienbenido al modo gestor");
    }

    public void mensajeMostrarProyectos(String nombreDeGestor){
        System.out.println(" Estos son los proyectos Creados por el gestor " + nombreDeGestor );
    }

    public void mensajeDeProyectoBuscado(){
        System.out.println(" EL proyecto buscado es ");
    }

    public void mostrarProyecto(ArrayList<Proyecto> proyecto){
        for (int i = 0; i <proyecto.size() ; i++) {
            System.out.println(proyecto.get(i));
        }
    }

    public void mensajeDeCambioDeNombre(){
        System.out.println("El nombre del proyecto fue cambiado");
    }

    public void mensajeDeCambioDeDescripcion(){
        System.out.println("la descripcion del proyecto fue cambiado");
    }

    public void mensajeDeCambioDeCambioCategoria(){
        System.out.println("La categoria fue cambiada");
    }

    public void mensajeCantidadNecesaria() {
        System.out.println("La cantidad necesaria fue cambiada");
    }

    public void mensajeCantidadFinanciada() {
        System.out.println("La cantidad financiada fue cambiada");
    }

    public void mensajeFechaDeApertura() {
        System.out.println("La fecha de apertura fue cambiada");
    }

    public void mensajeRecompensas() {
        System.out.println("Las recompensas fueron cambiadas");
    }

    public void mensajeFechaDeFin() {
        System.out.println("La fecha de fin fue cambiada");
    }






    public void opcinesDelGestor(){
        System.out.println("1: Ver todos mis proyectos");
        System.out.println("2: Cambio de credenciales");
        System.out.println("3: Cerrar secion");
    }

}
