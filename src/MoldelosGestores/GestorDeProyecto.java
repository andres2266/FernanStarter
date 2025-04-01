package MoldelosGestores;

import Modelos.Proyecto;
import Modelos.RecompensasDeProyecto;


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

    public void oridenarPorImporteFinanciado(ArrayList<Proyecto> proyecrtos){
            proyecrtos.sort((a , b) -> (b.getCantidadFinanciada()-a.getCantidadFinanciada()));
    }

    public ArrayList<Proyecto> verArrayDeProyectos(){
        return gestorProyecto;
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

    public ArrayList<Proyecto> verTodosLosProyectos(){
        return gestorProyecto;
    }

}
