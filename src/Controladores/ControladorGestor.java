package Controladores;

import FuncionesDeCorreo.FuncionesDeCorreo;
import Modelos.Categoria;
import Modelos.Proyecto;
import MoldelosGestores.GestorDeProyecto;
import MoldelosGestores.GestorDeUsuarios;
import Vistas.VistaGestor;

import java.time.LocalDate;

public class ControladorGestor {
    private GestorDeUsuarios gestorDeUsuarios;
    private VistaGestor vistaGestor;
    private GestorDeProyecto gestorDeProyecto;



    public ControladorGestor(GestorDeUsuarios gestorDeUsuarios, VistaGestor vistaGestor, GestorDeProyecto gestorDeProyecto) {
        this.gestorDeUsuarios = gestorDeUsuarios;
        this.vistaGestor = vistaGestor;
        this.gestorDeProyecto = gestorDeProyecto;
    }

    public void crearProyecto(String nombre, String descripcion, Categoria categoria, int cantidadNecesaria, int cantidadFinanciada, LocalDate fechaDeApertura, float recompensas, LocalDate fechaDeFin, String id,String idUsuarios){
        gestorDeUsuarios.verMetodosDeGestor(gestorDeUsuarios.buscarUsuario(idUsuarios)).crearProyecto(nombre,descripcion,categoria,cantidadNecesaria,cantidadFinanciada,fechaDeApertura,recompensas,fechaDeFin,id);
    }

    public void verProyectos(String id){
        vistaGestor.mensajeMostrarProyectos(gestorDeUsuarios.buscarUsuario(id).getNombre());
        vistaGestor.mostrarProyecto(gestorDeUsuarios.verMetodosDeGestor(gestorDeUsuarios.buscarUsuario(id)).verArrayDeProyectos());
    }

    public Proyecto BuscarProyecto(String idProyecto){
        vistaGestor.mensajeDeProyectoBuscado();
        return gestorDeProyecto.buscarProyecto(idProyecto);
    }
    public void modificarnNombreDeProyecto(String idProyecto,String nuevoNobreDeProyecto){
        gestorDeProyecto.buscarProyecto(idProyecto).setNombre(nuevoNobreDeProyecto);
        vistaGestor.mensajeDeCambioDeNombre();
    }

    public void modificarCategoriaDeProyecto(Categoria nuevaCategoria , String id){
        gestorDeProyecto.buscarProyecto(id).setCategoria(nuevaCategoria);
        vistaGestor.mensajeDeCambioDeCambioCategoria();
    }

    public void modificarCantidadNecesaria(int cantidadNecesaria, String id) {
        gestorDeProyecto.buscarProyecto(id).setCantidadNecesaria(cantidadNecesaria);
        vistaGestor.mensajeCantidadNecesaria();
    }

    public void modificarCantidadFinanciada(int cantidadFinanciada, String id) {
        gestorDeProyecto.buscarProyecto(id).setCantidadFinanciada(cantidadFinanciada);
        vistaGestor.mensajeCantidadFinanciada();
    }

    public void modificarFechaDeApertura(LocalDate fechaDeApertura, String id) {
        gestorDeProyecto.buscarProyecto(id).setFechaDeApertura(fechaDeApertura);
        vistaGestor.mensajeFechaDeApertura();
    }

    public void modificarRecompensas(float recompensas, String id) {
        gestorDeProyecto.buscarProyecto(id).setRecompensas(recompensas);
        vistaGestor.mensajeRecompensas();
    }

    public void modificarFechaDeFin(LocalDate fechaDeFin, String id) {
        gestorDeProyecto.buscarProyecto(id).setFechaDeFin(fechaDeFin);
        vistaGestor.mensajeFechaDeFin();
    }

    public void modificarDescripcionDeProyecto(String descripcion, String id) {
        gestorDeProyecto.buscarProyecto(id).setDescripcion(descripcion);
        vistaGestor.mensajeDeCambioDeDescripcion();
    }

    public GestorDeUsuarios getGestorDeUsuarios() {
        return gestorDeUsuarios;
    }

    public void inicioDeSecionAdmin(String id, String contraseña) {
        if (gestorDeUsuarios.buscarUsuario(id) == null) {
            vistaGestor.idNoValido();
        } else if (gestorDeUsuarios.buscarUsuario(id).getContraseña().equals(contraseña)) {
            FuncionesDeCorreo codigo = new FuncionesDeCorreo(gestorDeUsuarios.buscarUsuario(id).getCorreo());
            if(codigo.getCodigoDeCorreo().equals(vistaGestor.inicioDeSecionCodigo())){
                vistaGestor.saludarUsuario();
            }
        }
    }

}

