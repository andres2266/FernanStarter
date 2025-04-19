package Controladores;

import Modelos.RecompensasDeProyecto;
import MoldelosGestores.GestorDeProyecto;
import Vistas.VistaProyecto;

import java.util.ArrayList;

public class ControladorDeProyecto {
    private GestorDeProyecto gestorDeProyecto;
    private VistaProyecto vistaProyecto;

    public ControladorDeProyecto(GestorDeProyecto gestorDeProyecto, VistaProyecto vistaProyecto) {
        this.gestorDeProyecto = gestorDeProyecto;
        this.vistaProyecto = vistaProyecto;
    }

    public void verTodosLosProyectos(){
        vistaProyecto.verProyectos(gestorDeProyecto.verTodosLosProyectos());
    }

    public void añadirRecompensaAProyecto(String idDeProyecto,String descripcionDeProyecto,int cantidadDeProyecto,String idProyecto){
        RecompensasDeProyecto recompensasDeProyecto = new RecompensasDeProyecto(descripcionDeProyecto,cantidadDeProyecto,descripcionDeProyecto);
        gestorDeProyecto.buscarProyecto(idProyecto).añadirRecompensa(recompensasDeProyecto);
        vistaProyecto.mensajeRecompensaAgregada();
    }

    public  void verRecompensasDeProyecto(String idDeProyecto){
        if(gestorDeProyecto.buscarProyecto(idDeProyecto).getId().equals(idDeProyecto)){
            vistaProyecto.verRecompensaDeProyecto(gestorDeProyecto.buscarProyecto(idDeProyecto).verArrayDeProyecto());
        }
        vistaProyecto.mensajeProyectoNoEncontrado();
    }

    public void ordenarProyectoPorImporteRealizado(){
        gestorDeProyecto.ordenarPorImporteFinanciado(gestorDeProyecto.verArrayDeProyectos());
        vistaProyecto.mensajeDeOrdenacionPorFinanciacion();
    }

    public void grafico(String id){
        float sumaTotalDeCantidadesInvertidas = 0;
        ArrayList<Float>cantidadesInvertidas = new ArrayList<>();
        if(gestorDeProyecto.buscarProyecto(id)==null){
            vistaProyecto.mensajeProyectoNoEncontrado();
        }
        int cantidadDeInversores = gestorDeProyecto.buscarProyecto(id).cantidadDeInversores();
        for (int i = 0; i <cantidadDeInversores ; i++) {
           cantidadesInvertidas.add(gestorDeProyecto.buscarProyecto(id).verInversion(i).getCantidadInvertida());
        }
        for (int i = 0; i <cantidadesInvertidas.size() ; i++) {
            sumaTotalDeCantidadesInvertidas += cantidadesInvertidas.get(i);
        }
    }

}
