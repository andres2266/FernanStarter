package Vistas;

public class VistaGestor implements Credenciales {
    public void pedirUsuario(){
        System.out.println("Por facor introdusca el nombre De Usuario");
    }
    public void PedirContraseña(){
        System.out.println("Por favor introdusca su contraseña");
    }

    public void saludarUsuario(){
        System.out.println("Bienbenido al modo gestor");
    }

    public void opcinesDelGestor(){
        System.out.println("1: Ver todos mis proyectos");
        System.out.println("2: Cambio de credenciales");
        System.out.println("3: Cerrar secion");
    }

}
