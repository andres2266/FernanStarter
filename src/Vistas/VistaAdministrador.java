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

    public void idNoValido(){
        System.out.println("el id proporcido no es valido");
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




}
