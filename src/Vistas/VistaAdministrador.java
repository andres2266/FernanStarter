package Vistas;

public class VistaAdministrador implements Credenciales{
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


    public void opcionesAdministrador(){
        System.out.println("1: Bloaqueo y desbloqueo de usuarios");
        System.out.println("2: Ver proyectos");
        System.out.println("3: Cambios de credenciales");
        System.out.println("4: Cerrar sesion");
    }
}
