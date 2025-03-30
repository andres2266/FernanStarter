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

    public void misInversiones(String id) {
        vistaInversor.textoParaMostrarInversiones(gestorDeUsuarios.buscarUsuario(id).getNombre());
        vistaInversor.mostrarInverciones(gestorDeUsuarios.verMetodosDeInversor(gestorDeUsuarios.buscarUsuario(id)).motrarArrayDeInversiones());
    }

    public void proyectos(String id) {
        vistaInversor.textoParaMostrarProyectos(gestorDeUsuarios.buscarUsuario(id).getNombre());
        vistaInversor.mostrarProyectos(gestorDeUsuarios.verMetodosDeInversor(gestorDeUsuarios.buscarUsuario(id)).mostrarArrayDeProyectosInvertidos());
    }

    public void verCartera(String id) {
        vistaInversor.textoParaCartera(gestorDeUsuarios.buscarUsuario(id).getNombre());
        vistaInversor.verCarteraDeInversor(gestorDeUsuarios.verMetodosDeInversor(gestorDeUsuarios.buscarUsuario(id)).verCatera());
    }

    public void añadirCreditoAcartera(int creditoAñadido, String id) {
        vistaInversor.mensajeCreditoAñadido(creditoAñadido);
        gestorDeUsuarios.verMetodosDeInversor(gestorDeUsuarios.buscarUsuario(id)).añadirSaldoACartera(creditoAñadido);
    }

    public void mostrarAmigosDelIversor(String id) {
        vistaInversor.mensajeAmigos(gestorDeUsuarios.buscarUsuario(id).getNombre());
        vistaInversor.verAmigosDeGestor(gestorDeUsuarios.verMetodosDeInversor(gestorDeUsuarios.buscarUsuario(id)).verListaDeAmigos());
    }

    public void añadirAmigoDeInversor(Amigo amigo, String id) {
        gestorDeUsuarios.verMetodosDeInversor(gestorDeUsuarios.buscarUsuario(id)).añadirAmigo(amigo);
        vistaInversor.mensajeAmigoAñadido();
    }

    public void cambiarNombreDeInversor(String nombre, String id) {
        gestorDeUsuarios.verMetodosDeInversor(gestorDeUsuarios.buscarUsuario(id)).cambioDeUsusario(nombre);
        vistaInversor.mensajeCambioDeUsusaio();
    }

    public void cambioDeContraseñaDeInversor(String contraseña, String id) {
        gestorDeUsuarios.verMetodosDeInversor(gestorDeUsuarios.buscarUsuario(id)).cambioDeContraseña(contraseña);
        vistaInversor.mensajeDeCabioDeContraseña();
    }

    public void inicioDeSecionAdmin(String id, String contraseña) {
        if (gestorDeUsuarios.buscarUsuario(id) == null) {
            vistaInversor.idNoValido();
        } else if (gestorDeUsuarios.buscarUsuario(id).getContraseña().equals(contraseña)) {
            FuncionesDeCorreo codigo = new FuncionesDeCorreo(gestorDeUsuarios.buscarUsuario(id).getCorreo());
            if (codigo.getCodigoDeCorreo().equals(vistaInversor.inicioDeSesionCodigo())) {
                vistaInversor.saludarUsuario();
            }
        }
    }
    public void invertir(Usuario usuarioInversor, String nombreUsuario, Proyecto proyecto, float cantidad, LocalDate fechaDeInversion){
        if(usuarioInversor.getClass().getSimpleName().equals("Inversor")){
            gestorDeUsuarios.verMetodosDeInversor(gestorDeUsuarios.buscarUsuario(nombreUsuario)).invertir(proyecto, cantidad, fechaDeInversion);
        }
    }
}
