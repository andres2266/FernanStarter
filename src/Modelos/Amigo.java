package Modelos;
public class Amigo {
    private String nombre;
    private String correo;

    public Amigo(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "El nombre es " + nombre + "su correo es " + correo;
    }
}
