package Modelos;


import static FuncionesDeCadenas.Cadenas.FortalezaContraseña;


public abstract class Usuario implements CerrarCesion{
    private String id;
    private String nombre;
    private String contraseña;
    private String correo;
    private boolean secion;

    public Usuario(String nombre, String contraseña, String correo,String id) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.correo = correo;
        this.secion = false;
        this.id = id;
    }

    public boolean cambioDeContraseña(String contraseña) {
        if(FortalezaContraseña(contraseña)){
            this.contraseña = contraseña;
            return true;
        }else{
            return false;
        }
    }

    public void cambioDeNombreDeUsusario(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setSecion(boolean secion) {
        this.secion = secion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
