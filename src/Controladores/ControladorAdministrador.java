package Controladores;

import FuncionesDeCorreo.FuncionesDeCorreo;
import Modelos.Categoria;
import Modelos.RecompensasDeProyecto;
import MoldelosGestores.GestorDeProyecto;
import MoldelosGestores.GestorDeUsuarios;
import Vistas.VistaAdministrador;

import java.time.LocalDate;

public class ControladorAdministrador {
    private GestorDeUsuarios gestorDeUsuarios;
    private VistaAdministrador vistaAdministrador;
    private GestorDeProyecto gestorDeProyecto;
    public ControladorAdministrador(GestorDeUsuarios gestorDeUsuarios, VistaAdministrador vistaAdministrador) {
        this.gestorDeUsuarios = gestorDeUsuarios;
        this.vistaAdministrador = vistaAdministrador;
    }

    public void cambiarContraseñaAdministrdor(String contraseña, String  nombreDeUsuario) {
        gestorDeUsuarios.buscarUsuario(nombreDeUsuario).setContraseña(contraseña);
        vistaAdministrador.cambioDeContraseña();
    }


    public void cambiarUsuarioDeAdministrador(String nombreDeUsuario, String  NuevonombreDeUsuario) {
        gestorDeUsuarios.buscarUsuario(nombreDeUsuario).cambioDeNombreDeUsusario(NuevonombreDeUsuario);
        vistaAdministrador.cambioDeUsuario();
    }

    public void cerrarCecionDeAdmin(String  nombreDeUsuario) {
        gestorDeUsuarios.buscarUsuario( nombreDeUsuario).cerrarSecion();
    }


    public void desbloquearUsuario(String  nombreDeUsuario) {
        gestorDeUsuarios.buscarUsuario( nombreDeUsuario).setBloqueado(false);
        vistaAdministrador.usuarioDesbloqueado();
    }


    public void bloquearUsuario(String  nombreDeUsuario) {
        gestorDeUsuarios.buscarUsuario( nombreDeUsuario).setBloqueado(true);
        vistaAdministrador.usuarioBloqueado();
    }


    public void modificarnNombreDeProyecto(String idProyecto,String nuevoNobreDeProyecto){
        gestorDeProyecto.buscarProyecto(idProyecto).setNombre(nuevoNobreDeProyecto);
        vistaAdministrador.mensajeDeCambioDeNombre();
    }

    public void modificarCategoriaDeProyecto(Categoria nuevaCategoria , String nombreDeUsuario){
        gestorDeProyecto.buscarProyecto(nombreDeUsuario).setCategoria(nuevaCategoria);
        vistaAdministrador.mensajeDeCambioDeCambioCategoria();
    }

    public void modificarCantidadNecesaria(int cantidadNecesaria, String nombreDeUsuario) {
        gestorDeProyecto.buscarProyecto(nombreDeUsuario).setCantidadNecesaria(cantidadNecesaria);
        vistaAdministrador.mensajeCantidadNecesaria();
    }

    public void modificarCantidadFinanciada(int cantidadFinanciada, String nombreDeUsuario) {
        gestorDeProyecto.buscarProyecto(nombreDeUsuario).setCantidadFinanciada(cantidadFinanciada);
        vistaAdministrador.mensajeCantidadFinanciada();
    }

    public void modificarFechaDeApertura(LocalDate fechaDeApertura, String nombreDeUsuario) {
        gestorDeProyecto.buscarProyecto(nombreDeUsuario).setFechaDeApertura(fechaDeApertura);
        vistaAdministrador.mensajeFechaDeApertura();
    }

    public void modificarRecompensas( String idDeProyecto, RecompensasDeProyecto NuevarecompensasDeProyecto,String idRecompesa) {
        gestorDeProyecto.buscarProyecto(idDeProyecto).modificarRecompensa(NuevarecompensasDeProyecto,idRecompesa);
        vistaAdministrador.mensajeRecompensas();
    }

    public void modificarFechaDeFin(LocalDate fechaDeFin, String  nombreDeUsuario) {
        gestorDeProyecto.buscarProyecto( nombreDeUsuario).setFechaDeFin(fechaDeFin);
        vistaAdministrador.mensajeFechaDeFin();
    }

    public void modificarDescripcionDeProyecto(String descripcion, String nombreDeUsuario) {
        gestorDeProyecto.buscarProyecto(nombreDeUsuario).setDescripcion(descripcion);
        vistaAdministrador.mensajeDeCambioDeDescripcion();
    }

    public void eliminarProyecto(String id){
        gestorDeProyecto.eliminarProyecto(id);
    }

    public void ordenarTodosLosProyectosPorOrdenDeCantidadFinanciada(){
        gestorDeProyecto.oridenarPorImporteFinanciado(gestorDeProyecto.verArrayDeProyectos());
    }
    public boolean inicioDeSecionAdmin(String nombreDeUsuario, String contraseña) {
        if (gestorDeUsuarios.buscarUsuario( nombreDeUsuario) == null) {
            vistaAdministrador.credencialesNoValidos();
            return false;
        } else if (gestorDeUsuarios.buscarUsuario( nombreDeUsuario).getContraseña().equals(contraseña)) {
            FuncionesDeCorreo codigo = new FuncionesDeCorreo(gestorDeUsuarios.buscarUsuario( nombreDeUsuario).getCorreo());
            if(codigo.getCodigoDeCorreo().equals(vistaAdministrador.inicioDeSecionCodigo())){
                vistaAdministrador.saludarUsuario();
                return true;
            }
        }
        return false;
    }
}


