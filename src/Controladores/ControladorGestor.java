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

    public void crearProyecto(String nombre, String descripcion, Categoria categoria, int cantidadNecesaria, int cantidadFinanciada, LocalDate fechaDeApertura, float recompensas, LocalDate fechaDeFin, String id,String nombreDeUsuario){
        if(gestorDeUsuarios.verMetodosDeInversor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario))==null){
            vistaGestor.mensajeUsuarioNoEncontrado();
        }
        gestorDeUsuarios.verMetodosDeGestor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario)).crearProyecto(nombre,descripcion,categoria,cantidadNecesaria,cantidadFinanciada,fechaDeApertura,recompensas,fechaDeFin,id);
        vistaGestor.mensajeProyectoCreado();
    }

    public void verProyectos(String nombreDeUsuario){
        vistaGestor.mensajeMostrarProyectos(gestorDeUsuarios.buscarUsuario(nombreDeUsuario).getNombre());
        vistaGestor.mostrarProyecto(gestorDeUsuarios.verMetodosDeGestor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario)).verArrayDeProyectos());
    }

    public Proyecto BuscarProyecto(String idProyecto){
        vistaGestor.mensajeDeProyectoBuscado();
        return gestorDeProyecto.buscarProyecto(idProyecto);
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

    public void modificarRecompensas(float recompensas, String nombreDeUsuario) {
        gestorDeProyecto.buscarProyecto(nombreDeUsuario).setRecompensas(recompensas);
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

    public void inicioDeSecionAdmin(String nombreDeUsuario, String contraseña) {
        if (gestorDeUsuarios.buscarUsuario(nombreDeUsuario) == null) {
            vistaGestor.idNoValido();
        } else if (gestorDeUsuarios.buscarUsuario(nombreDeUsuario).getContraseña().equals(contraseña)) {
            FuncionesDeCorreo codigo = new FuncionesDeCorreo(gestorDeUsuarios.buscarUsuario(nombreDeUsuario).getCorreo());
            if(codigo.getCodigoDeCorreo().equals(vistaGestor.inicioDeSecionCodigo())){
                vistaGestor.saludarUsuario();
            }

        }
    }

}

