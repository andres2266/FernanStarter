package Modelos;

import java.time.LocalDate;
import java.util.ArrayList;

public class Gestor extends Usuario{

    private boolean usuarioBloqueado;
    private ArrayList<Proyecto> proyectosCreados;

    public Gestor(String nombre, String contraseña, String correo, String id) {
        super(nombre, contraseña, correo, id);
        this.usuarioBloqueado = false;
        proyectosCreados = new ArrayList<>();
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

    public void crearProyecto(String nombre, String descripcion, Categoria categoria, int cantidadNecesaria, int cantidadFinanciada, LocalDate fechaDeApertura, float recompensas, LocalDate fechaDeFin, String id){
        Proyecto nuevoProyecto = new Proyecto(nombre,descripcion,categoria,cantidadNecesaria,cantidadFinanciada,fechaDeApertura,recompensas,fechaDeFin,id);
        proyectosCreados.add(nuevoProyecto);
    }

    public boolean eliminarProyecto(String id) {
        for (int i = 0; i < proyectosCreados.size(); i++) {
            if (proyectosCreados.get(i).getId().equals(id)) {
                proyectosCreados.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Proyecto> verArrayDeProyectos(){
        return proyectosCreados;
    }

}
