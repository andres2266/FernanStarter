package Controladores;


import FuncionesDeCorreo.FuncionesDeCorreo;
import Modelos.Amigo;

import Modelos.Proyecto;
import Modelos.Usuario;
import MoldelosGestores.GestorDeUsuarios;
import Vistas.VistaInversor;

import java.time.LocalDate;

public class ControladorInversor {
    private GestorDeUsuarios gestorDeUsuarios;
    private VistaInversor vistaInversor;

    public ControladorInversor(GestorDeUsuarios gestoDeUsuarios, VistaInversor vistaInversor) {
        this.gestorDeUsuarios = gestoDeUsuarios;
        this.vistaInversor = vistaInversor;
    }

    public void misInversiones(String nombreDeUsuario) {
        vistaInversor.textoParaMostrarInversiones(gestorDeUsuarios.buscarUsuario(nombreDeUsuario).getNombre());
        vistaInversor.mostrarInverciones(gestorDeUsuarios.verMetodosDeInversor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario)).motrarArrayDeInversiones());
    }

    public void proyectos(String nombreDeUsuario) {
        vistaInversor.textoParaMostrarProyectos(gestorDeUsuarios.buscarUsuario(nombreDeUsuario).getNombre());
        vistaInversor.mostrarProyectos(gestorDeUsuarios.verMetodosDeInversor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario)).mostrarArrayDeProyectosInvertidos());
    }

    public void verCartera(String nombreDeUsuario) {
        vistaInversor.textoParaCartera(gestorDeUsuarios.buscarUsuario(nombreDeUsuario).getNombre());
        vistaInversor.verCarteraDeInversor(gestorDeUsuarios.verMetodosDeInversor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario)).verCatera());
    }

    public void añadirCreditoAcartera(int creditoAñadido, String nombreDeUsuario) {
       if(gestorDeUsuarios.verMetodosDeInversor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario))==null){
           vistaInversor.mensajeUsuarioNoEncontrado();
       }
        gestorDeUsuarios.verMetodosDeInversor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario)).añadirSaldoACartera(creditoAñadido);
        vistaInversor.mensajeCreditoAñadido(creditoAñadido);
    }

    public void mostrarAmigosDelIversor(String nombreDeUsuairo) {
        vistaInversor.mensajeAmigos(gestorDeUsuarios.buscarUsuario(nombreDeUsuairo).getNombre());
        vistaInversor.verAmigosDeGestor(gestorDeUsuarios.verMetodosDeInversor(gestorDeUsuarios.buscarUsuario(nombreDeUsuairo)).verListaDeAmigos());
    }

    public void añadirAmigoDeInversor(Amigo amigo, String nombreDeUsuario) {
        if(gestorDeUsuarios.verMetodosDeInversor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario))==null){
            vistaInversor.mensajeUsuarioNoEncontrado();
        }
        gestorDeUsuarios.verMetodosDeInversor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario)).añadirAmigo(amigo);
        vistaInversor.mensajeAmigoAñadido();
    }

    public void cambiarNombreDeInversor(String nombre, String nombreDeUsuario) {
        if(gestorDeUsuarios.verMetodosDeInversor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario))==null){
            vistaInversor.mensajeUsuarioNoEncontrado();
        }
        gestorDeUsuarios.verMetodosDeInversor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario)).cambioDeUsusario(nombre);
        vistaInversor.mensajeCambioDeUsusaio();
    }

    public void cambioDeContraseñaDeInversor(String contraseña, String nombreDeUsuario) {
        if(gestorDeUsuarios.verMetodosDeInversor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario))==null){
            vistaInversor.mensajeUsuarioNoEncontrado();
        }
        gestorDeUsuarios.verMetodosDeInversor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario)).cambioDeContraseña(contraseña);
        vistaInversor.mensajeDeCabioDeContraseña();
    }

    public void inicioDeSecionAdmin(String nombreDeUsuario, String contraseña) {
        if (gestorDeUsuarios.buscarUsuario(nombreDeUsuario) == null) {
            vistaInversor.idNoValido();
        } else if (gestorDeUsuarios.buscarUsuario(nombreDeUsuario).getContraseña().equals(contraseña)) {
            FuncionesDeCorreo codigo = new FuncionesDeCorreo(gestorDeUsuarios.buscarUsuario(nombreDeUsuario).getCorreo());
            if (codigo.getCodigoDeCorreo().equals(vistaInversor.inicioDeSesionCodigo())) {
                vistaInversor.saludarUsuario();
            }
        }
    }
    public void invertir(Usuario usuarioInversor, String nombreDeUsuario, Proyecto proyecto, float cantidad, LocalDate fechaDeInversion){
        if(gestorDeUsuarios.verMetodosDeInversor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario))==null){
            vistaInversor.mensajeUsuarioNoEncontrado();
        }
        gestorDeUsuarios.verMetodosDeInversor(gestorDeUsuarios.buscarUsuario(nombreDeUsuario)).invertir(proyecto, cantidad, fechaDeInversion);
    }
}
