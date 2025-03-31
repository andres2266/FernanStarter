package Modelos;

import java.util.ArrayList;

public class Gestor extends Usuario{

    private boolean usuarioBloqueado;
    private ArrayList<Proyecto> proyectosCreados;

    public Gestor(String nombre, String correo, String contraseña) {
        super(nombre, correo,contraseña);
        this.usuarioBloqueado = false;
        proyectosCreados = new ArrayList<>();
    }


    @Override
    public void cerrarSecion() {
        setBloqueado(false);
    }

    public boolean cambioDeUsusario(String nuevoUsuario ){
        super.cambioDeNombreDeUsusario(nuevoUsuario);
        return true;
    }


    public boolean cambioDeContraseña(String nuevaContraseña ){
        super.cambioDeContraseña(nuevaContraseña);
        return true;
    }

    public void crearProyecto(Proyecto proyecto){
        Proyecto nuevoProyecto = proyecto;
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

    public Proyecto buscarProyectosDeGestor(String idProyecto){
        for (int i = 0; i <proyectosCreados.size() ; i++) {
            if(proyectosCreados.get(i).getId().equals(idProyecto)){
                return proyectosCreados.get(i);
            }
        }
        return null;
    }
    public ArrayList<Proyecto> verArrayDeProyectos(){
        return proyectosCreados;
    }

    public void setUsuarioBloqueado(boolean usuarioBloqueado) {
        this.usuarioBloqueado = usuarioBloqueado;
    }
}
