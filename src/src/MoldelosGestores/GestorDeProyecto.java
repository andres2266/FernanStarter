package MoldelosGestores;

import Modelos.Proyecto;

import java.util.ArrayList;

public class GestorDeProyecto {
    ArrayList<Proyecto>gestorProyecto;

    public GestorDeProyecto (){
        gestorProyecto = new ArrayList<Proyecto>();
    }

    public boolean añadirProyecto(Proyecto proyecto){
        gestorProyecto.add(proyecto);
        return true;
    }

    public boolean eliminarProyecto(String id){
        for (int i = 0; i <gestorProyecto.size() ; i++) {
            if(gestorProyecto.get(i).getId().equals(id)){
                gestorProyecto.remove(i);
                return true;
            }
        }
        return false;
    }

    public Proyecto buscarProyecto(String id){
        for (int i = 0; i <gestorProyecto.size() ; i++) {
            if (gestorProyecto.get(i).getId().equals(id)){
                return gestorProyecto.get(i);
            }
        }
        return null;
    }

    public boolean aterarProyecto(Proyecto proyecto,String id){
        for (int i = 0; i <gestorProyecto.size() ; i++) {
            if (gestorProyecto.get(i).getId().equals(id)){
                gestorProyecto.add(i,proyecto);
                return true;
            }
        }
        return false;
    }

}
