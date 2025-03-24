package Controladores;

import Modelos.Gestor;
import Modelos.Inversor;
import MoldelosGestores.GestorDeUsuarios;
import Vistas.VistaInversor;

public class ControladorInversor {
    private Inversor Inversor;
    private VistaInversor vistaInversor;

    public ControladorInversor( Inversor inversor,VistaInversor vistaInversor) {
        this. Inversor= inversor;
        this.vistaInversor = vistaInversor;
    }
    public void misInversiones(){
        vistaInversor.textoParaMostrarInversiones(Inversor.getNombre());
        vistaInversor.mostrarInverciones(Inversor.motrarArrayDeInverciones());
    }

    public void proyectos(){
        vistaInversor.textoParaMostrarProyectos(Inversor.getNombre());
        vistaInversor.mostrarProyectos(Inversor.mostrarArrayDeProyectosInvertidos());
    }

    public void verCartera(){
        vistaInversor.textoParaCartera(Inversor.getNombre());
        vistaInversor.verCarteraDeInversor(Inversor.verCatera());
    }

}
