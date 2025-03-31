package Vistas;

import java.util.Scanner;

public class VistaAdministrador implements Credenciales{
    Scanner S = new Scanner(System.in);


    public String inicioDeSecionCodigo(){
        System.out.println("ingrese el codigo de verificacion");
        String codigo = S.nextLine();
        return codigo;
    }

    @Override
    public void PedirContraseña() {
        System.out.println("Por favor introdusca su contraseña");
    }

    @Override
    public void pedirUsuario() {
        System.out.println("Por facor introdusca el nombre De Usuario/Alias");
    }

    public void credencialesNoValidos(){
        System.out.println("credenciales no validos");
    }

    @Override
    public void saludarUsuario() {
        System.out.println("Bienbenido al modo Administrador");
    }

    public void cambioDeContraseña(){
        System.out.println("La contrasela ha sido cambiada");
    }

    public void cambioDeUsuario(){
        System.out.println("El usuario ha sido cambiado");
    }

    public void usuarioDesbloqueado(){
        System.out.println("El usuario ha sido desbloqueado");
    }

    public void usuarioBloqueado(){
        System.out.println("El usuario ha sido bloqueado");
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




}
