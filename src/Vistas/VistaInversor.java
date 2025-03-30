package Vistas;

import Ivercion.Inversion;
import Modelos.Amigo;
import Modelos.Proyecto;

import java.util.ArrayList;

public class VistaInversor implements Credenciales {
    @Override
    public void PedirContraseña() {
        System.out.println("Por favor introdusca su contraseña");
    }

    @Override
    public void pedirUsuario() {
        System.out.println("Por facor introdusca el nombre De Usuario");
    }

    @Override
    public void saludarUsuario() {
        System.out.println("Bienbenido al modo Inversor");
    }

    public void textoParaMostrarProyectos(String nombreInversor){
        System.out.println(" Los proyectos creador por el Inversor " + nombreInversor + " son ");
    }

    public void mostrarProyectos(ArrayList<Proyecto> proyectosInvertidos){
        for (int i = 0; i <proyectosInvertidos.size() ; i++) {
            System.out.println(proyectosInvertidos.get(i));
        }
    }

    public void textoParaMostrarInversiones(String nombreDeInversor){
        System.out.println("Las inverciones realizadas por el Inversor " + nombreDeInversor + " son ");
    }

    public void mostrarInverciones(ArrayList<Inversion> inversiones){
        for (int i = 0; i <inversiones.size() ; i++) {
            System.out.println(inversiones.get(i));
        }
    }

    public void textoParaCartera(String nombre){
        System.out.println("El dinero que tiene " + nombre + "En la cartera es ");
    }

    public void verCarteraDeInversor(float cartera){
        System.out.println(cartera);
    }

    public void mensajeCreditoAñadido(int cantidadAñadida){
        System.out.println(" Se añadio a la cartera " + cantidadAñadida + " Creditos ");
    }

    public void mensajeAmigos(String nombre){
        System.out.println(" Los amigos del inversor " + nombre);
    }

    public void mensajeAmigoAñadido(){
        System.out.println("El nuevo amigo fue agregado");
    }

    public void verAmigosDeGestor(ArrayList<Amigo> amigos){
        for (int i = 0; i <amigos.size() ; i++) {
            System.out.println(amigos.get(i));
        }
    }

    public void mensajeCambioDeUsusaio(){
        System.out.println("El nombre del Inversor fue modificado" );
    }

    public void mensajeDeCabioDeContraseña(){
        System.out.println("La contraseña del Inversor fue modificada");
    }

    public void idNoValido(){
        System.out.println("el id proporcido no es valido");
    }

    public String inicioDeSecionCodigo(){
        System.out.println("ingrese el codigo de verificacion");
        String codigo = S.nextLine();
        return codigo;
    }

    public void opcinesDelInversor() {
        System.out.println("1: Mis Inversiones");
        System.out.println("2: Proyectos");
        System.out.println("3: Cartera digital");
        System.out.println("4: Invitar a un amigo");
        System.out.println("5: configuracion");
    }
}
