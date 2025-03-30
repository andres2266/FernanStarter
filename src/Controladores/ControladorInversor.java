package Controladores;


import FuncionesDeCorreo.FuncionesDeCorreo;
import Modelos.Amigo;

import MoldelosGestores.GestorDeUsuarios;
import Vistas.VistaInversor;

public class ControladorInversor {
    private GestorDeUsuarios gestoDeUsuarios;
    private VistaInversor vistaInversor;

    public ControladorInversor(GestorDeUsuarios gestoDeUsuarios, VistaInversor vistaInversor) {
        this.gestoDeUsuarios = gestoDeUsuarios;
        this.vistaInversor = vistaInversor;
    }

    public void misInversiones(String id) {
        vistaInversor.textoParaMostrarInversiones(gestoDeUsuarios.buscarUsuario(id).getNombre());
        vistaInversor.mostrarInverciones(gestoDeUsuarios.verMetodosDeInversor(gestoDeUsuarios.buscarUsuario(id)).motrarArrayDeInverciones());
    }

    public void proyectos(String id) {
        vistaInversor.textoParaMostrarProyectos(gestoDeUsuarios.buscarUsuario(id).getNombre());
        vistaInversor.mostrarProyectos(gestoDeUsuarios.verMetodosDeInversor(gestoDeUsuarios.buscarUsuario(id)).mostrarArrayDeProyectosInvertidos());
    }

    public void verCartera(String id) {
        vistaInversor.textoParaCartera(gestoDeUsuarios.buscarUsuario(id).getNombre());
        vistaInversor.verCarteraDeInversor(gestoDeUsuarios.verMetodosDeInversor(gestoDeUsuarios.buscarUsuario(id)).verCatera());
    }

    public void añadirCreditoAcartera(int creditoAñadido, String id) {
        vistaInversor.mensajeCreditoAñadido(creditoAñadido);
        gestoDeUsuarios.verMetodosDeInversor(gestoDeUsuarios.buscarUsuario(id)).añadirSaldoACartera(creditoAñadido);
    }

    public void mostrarAmigosDelIversor(String id) {
        vistaInversor.mensajeAmigos(gestoDeUsuarios.buscarUsuario(id).getNombre());
        vistaInversor.verAmigosDeGestor(gestoDeUsuarios.verMetodosDeInversor(gestoDeUsuarios.buscarUsuario(id)).verListaDeAmigos());
    }

    public void añadirAmigoDeInversor(Amigo amigo, String id) {
        gestoDeUsuarios.verMetodosDeInversor(gestoDeUsuarios.buscarUsuario(id)).añadirAmigo(amigo);
        vistaInversor.mensajeAmigoAñadido();
    }

    public void cambiarNombreDeInversor(String nombre, String id) {
        gestoDeUsuarios.verMetodosDeInversor(gestoDeUsuarios.buscarUsuario(id)).cambioDeUsusario(nombre);
        vistaInversor.mensajeCambioDeUsusaio();
    }

    public void cambioDeContraseñaDeInversor(String contraseña, String id) {
        gestoDeUsuarios.verMetodosDeInversor(gestoDeUsuarios.buscarUsuario(id)).cambioDeContraseña(contraseña);
        vistaInversor.mensajeDeCabioDeContraseña();
    }

    public void inicioDeSecionAdmin(String id, String contraseña) {
        if (gestoDeUsuarios.buscarUsuario(id) == null) {
            vistaInversor.idNoValido();
        } else if (gestoDeUsuarios.buscarUsuario(id).getContraseña().equals(contraseña)) {
            FuncionesDeCorreo codigo = new FuncionesDeCorreo(gestoDeUsuarios.buscarUsuario(id).getCorreo());
            if (codigo.getCodigoDeCorreo().equals(vistaInversor.inicioDeSecionCodigo())) {
                vistaInversor.saludarUsuario();
            }
        }
    }
}
