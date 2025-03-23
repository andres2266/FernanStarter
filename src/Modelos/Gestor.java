package Modelos;

public class Gestor extends Usuario{

    private boolean usuarioBloqueado;

    public Gestor(String nombre, String contraseña, String correo, String id) {
        super(nombre, contraseña, correo, id);
        this.usuarioBloqueado = false;
    }

    public Gestor(String nombre, String contraseña, String correo, boolean secion , String id) {
        super(nombre, contraseña, correo,id);
    }

    @Override
    public void cerrarSecion() {
        setSecion(false);
    }

    public boolean cambioDeUsusario(String nuevoUsuario ){
        super.cambioDeNombreDeUsusario(nuevoUsuario);
        return true;
    }


    public boolean cambioDeContraseña(String nuevaContraseña ){
        super.cambioDeContraseña(nuevaContraseña);
        return true;
    }



}
