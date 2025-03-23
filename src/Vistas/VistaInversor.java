package Vistas;

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

    public void opcinesDelInversor() {
        System.out.println("1: Mis Inversiones");
        System.out.println("2: Proyectos");
        System.out.println("3: Cartera digital");
        System.out.println("4: Invitar a un amigo");
        System.out.println("5: configuracion");
    }
}
