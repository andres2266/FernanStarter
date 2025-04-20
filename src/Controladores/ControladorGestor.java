package Controladores;

import FuncionesDeCorreo.FuncionesDeCorreo;
import Inversión.Inversion;
import Modelos.*;
import MoldelosGestores.GestorDeProyecto;
import MoldelosGestores.GestorDeUsuarios;
import Vistas.VistaGestor;

import java.time.LocalDate;
import java.util.ArrayList;

public class ControladorGestor {
    private GestorDeUsuarios gestorDeUsuarios;
    private VistaGestor vistaGestor;
    private GestorDeProyecto gestorDeProyecto;

    public ControladorGestor(GestorDeUsuarios gestorDeUsuarios, VistaGestor vistaGestor,GestorDeProyecto gestorDeProyecto) {
        this.gestorDeUsuarios = gestorDeUsuarios;
        this.vistaGestor = vistaGestor;
        this.gestorDeProyecto = gestorDeProyecto;
    }

    public void crearProyecto(String nombre, String descripcion, Categoria categoria, int cantidadNecesaria, int cantidadFinanciada, LocalDate fechaDeApertura, LocalDate fechaDeFin, String id,String nombreDeUsuario){
        Proyecto nuevoProyecto=new Proyecto(nombre,descripcion,categoria,cantidadNecesaria,cantidadFinanciada,fechaDeApertura,fechaDeFin,id);
        gestorDeUsuarios.verMetodosDeGestor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario)).crearProyecto(nuevoProyecto);
        vistaGestor.mensajeProyectoCreado();
        gestorDeProyecto.añadirProyecto(nuevoProyecto);
    }

    public void eliminarProyecto(String id,String nombreDeUsuario){
        gestorDeUsuarios.verMetodosDeGestor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario)).eliminarProyecto(id);
        gestorDeProyecto.eliminarProyecto(id);
        vistaGestor.mensajeProyectoEliminado();
    }

    public void ordenarPorFecha(String nombreDeUsuario){
     gestorDeProyecto.ordenarArrayPorFecha( gestorDeUsuarios.verMetodosDeGestor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario)).verArrayDeProyectos());
     vistaGestor.mensajeProyectosOrdenadosPorFecha();
    }

    public void verProyectos(String nombreDeUsuario){
        vistaGestor.mensajeMostrarProyectos(gestorDeUsuarios.buscarUsuario(nombreDeUsuario).getNombre());
        vistaGestor.mostrarProyectoDeGestor(gestorDeUsuarios.verMetodosDeGestor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario)).verArrayDeProyectos());
    }
    public void ordenarProyectoPorImporteRealizado(String nombreDeUsuario){
       gestorDeProyecto.ordenarPorImporteFinanciado(gestorDeUsuarios.verMetodosDeGestor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario)).verArrayDeProyectosDeGestor());
        vistaGestor.mensajeDeOrdenacionPorFinanciacion();
    }
    public void mostrarInversionistasOrdenadoPorNombre(String idProyecto){

        vistaGestor.mostrarInversiones(gestorDeProyecto.ordenarInversionesPorNombre(gestorDeProyecto.buscarProyecto(idProyecto).getInvercionesRealizadas()));
    }

    public void mostrarInversionistasOrdenadoPorImporte(String idProyecto){

        vistaGestor.mostrarInversiones(gestorDeProyecto.ordenarInversionesPorImporte(gestorDeProyecto.buscarProyecto(idProyecto).getInvercionesRealizadas()));
    }

    public Proyecto BuscarProyecto(String idProyecto,String nombreDeUsuario){
        if(gestorDeUsuarios.verMetodosDeGestor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario)).buscarProyectosDeGestor(idProyecto)==null){
            vistaGestor.mensajeProyectoNoEncontrado();
            return null;
        }
        vistaGestor.mensajeDeProyectoBuscado();
        return gestorDeUsuarios.verMetodosDeGestor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario)).buscarProyectosDeGestor(idProyecto);
    }
    public void modificarnNombreDeProyecto(String idProyecto,String nuevoNobreDeProyecto){
        gestorDeProyecto.buscarProyecto(idProyecto).setNombre(nuevoNobreDeProyecto);
        vistaGestor.mensajeDeCambioDeNombre();
    }

    public void modificarCategoriaDeProyecto(Categoria nuevaCategoria , String nombreDeUsuario){
        gestorDeProyecto.buscarProyecto(nombreDeUsuario).setCategoria(nuevaCategoria);
        vistaGestor.mensajeDeCambioDeCambioCategoria();
    }

    public void modificarCantidadNecesaria(int cantidadNecesaria, String nombreDeUsuario) {
        gestorDeProyecto.buscarProyecto(nombreDeUsuario).setCantidadNecesaria(cantidadNecesaria);
        vistaGestor.mensajeCantidadNecesaria();
    }

    public void modificarCantidadFinanciada(int cantidadFinanciada, String nombreDeUsuario) {
        gestorDeProyecto.buscarProyecto(nombreDeUsuario).setCantidadFinanciada(cantidadFinanciada);
        vistaGestor.mensajeCantidadFinanciada();
    }

    public void modificarFechaDeApertura(LocalDate fechaDeApertura, String nombreDeUsuario) {
        gestorDeProyecto.buscarProyecto(nombreDeUsuario).setFechaDeApertura(fechaDeApertura);
        vistaGestor.mensajeFechaDeApertura();
    }

    public void modificarRecompensas(String idDeProyecto, RecompensasDeProyecto NuevarecompensasDeProyecto, String idRecompesa) {
        gestorDeProyecto.buscarProyecto(idDeProyecto).modificarRecompensa(NuevarecompensasDeProyecto,idRecompesa);
        vistaGestor.mensajeRecompensas();
    }

    public void modificarFechaDeFin(LocalDate fechaDeFin, String  nombreDeUsuario) {
        gestorDeProyecto.buscarProyecto( nombreDeUsuario).setFechaDeFin(fechaDeFin);
        vistaGestor.mensajeFechaDeFin();
    }

    public void modificarDescripcionDeProyecto(String descripcion, String nombreDeUsuario) {
        gestorDeProyecto.buscarProyecto(nombreDeUsuario).setDescripcion(descripcion);
        vistaGestor.mensajeDeCambioDeDescripcion();
    }

    public GestorDeUsuarios getGestorDeUsuarios() {
        return gestorDeUsuarios;
    }

    public boolean inicioDeSecionGestor(String nombreDeUsuario, String contraseña) {
        if (gestorDeUsuarios.buscarUsuario(nombreDeUsuario) == null) {
            vistaGestor.idNoValido();
            return false;
        } else if (gestorDeUsuarios.buscarUsuario(nombreDeUsuario).getContraseña().equals(contraseña)) {
            FuncionesDeCorreo codigo = new FuncionesDeCorreo(gestorDeUsuarios.buscarUsuario(nombreDeUsuario).getCorreo());
            if(codigo.getCodigoDeCorreo().equals(vistaGestor.inicioDeSecionCodigo())){
                vistaGestor.saludarUsuario();
                return true;
            }
        }
        return false;
    }
    public void usuarioBloqueado(String nombreDeUsuario){
        if(gestorDeUsuarios.buscarUsuario(nombreDeUsuario).isBloqueado()){
            vistaGestor.usuarioBloqueado();
        }
    }
    public void bloquearGestor(String nombreDeGestor){
        gestorDeUsuarios.buscarUsuario(nombreDeGestor).setBloqueado(true);
    }

    public void cambiarUsuarioGestor(String nombreDeUsuario,String nuevoUsuario){
        gestorDeUsuarios.buscarUsuario(nombreDeUsuario).cambioDeNombreDeUsusario(nuevoUsuario);

    }

    public void cambiarContraseñaDeUsuario(String nombreDeUsuario,String nuevaContraseña){
        gestorDeUsuarios.buscarUsuario(nombreDeUsuario).cambioDeContraseña(nuevaContraseña);
    }
    public void añadirGestorAGestorDeUsuarios(Usuario Gestor){
        gestorDeUsuarios.agregarUsuarios(Gestor);
    }

}

