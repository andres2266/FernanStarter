package Modelos;

public class Administrador extends Usuario{

    public Administrador(String nombre, String contraseña, String correo,String id) {
        super(nombre, contraseña, correo,id);
    }

    public boolean cambioDeContraseña(String nuevaContraseña ){
        super.cambioDeContraseña(nuevaContraseña);
        return true;
    }

    public boolean cambioDeUsusario(String nuevoUsuario ){
        super.cambioDeNombreDeUsusario(nuevoUsuario);
        return true;
    }

    @Override
    public void cerrarSecion() {
       super.setSecion(false);
    }

    public boolean bloquearUsuario(Usuario usuario){
        return false;
    }

    public boolean desbloquearUsuario(Usuario usuario){
        return true;
    }


}
