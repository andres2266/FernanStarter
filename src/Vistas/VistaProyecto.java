package Vistas;

import Modelos.Proyecto;

import java.util.ArrayList;

public class VistaProyecto {
    public void nombre(){System.out.println("Escribe el nombre del proyecto");}

    public void mensajeProyectoNoEncontrado(){System.out.println("El proyecto que estas buscando no existe");}

    public void verProyectos(ArrayList<Proyecto> todosLosProyectos){
        if(todosLosProyectos.isEmpty()){
            System.out.println("No se ha creado ningún proyecto");
        }
        for (int i = 0; i <todosLosProyectos.size() ; i++) {
            System.out.println(todosLosProyectos.get(i));
        }
    }
}
