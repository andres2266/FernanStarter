package Controladores;

import FuncionesDeCorreo.FuncionesDeCorreo;
import MoldelosGestores.GestorDeUsuarios;
import Vistas.VistaAdministrador;

public class ControladorAdministrador {
    private GestorDeUsuarios gestorDeUsuarios;
    private VistaAdministrador vistaAdministrador;

    public ControladorAdministrador(GestorDeUsuarios gestorDeUsuarios, VistaAdministrador vistaAdministrador) {
        this.gestorDeUsuarios = gestorDeUsuarios;
        this.vistaAdministrador = vistaAdministrador;
    }

    public void cambiarContraseñaAdministrdor(String contraseña, String  nombreDeUsuario) {
        gestorDeUsuarios.buscarUsuario(nombreDeUsuario).setContraseña(contraseña);
        vistaAdministrador.cambioDeContraseña();
    }


    public void cambiarUsuarioDeAdministrador(String nombreDeUsuario, String  nombreDeUsuariod) {
        gestorDeUsuarios.buscarUsuario(nombreDeUsuario).setNombre(nombreDeUsuario);
        vistaAdministrador.cambioDeUsuario();
    }


    public void cerrarCecionDeAdmin(String  nombreDeUsuario) {
        gestorDeUsuarios.buscarUsuario( nombreDeUsuario).cerrarSecion();
    }


    public void desbloquearUsuario(String  nombreDeUsuario) {
        gestorDeUsuarios.buscarUsuario( nombreDeUsuario).setSecion(false);
        vistaAdministrador.usuarioDesbloqueado();
    }


    public void bloquearUsuario(String  nombreDeUsuario) {
        gestorDeUsuarios.buscarUsuario( nombreDeUsuario).setSecion(true);
        vistaAdministrador.usuarioBloqueado();
    }


    public void inicioDeSecionAdmin(String  nombreDeUsuario, String contraseña) {
        if (gestorDeUsuarios.buscarUsuario( nombreDeUsuario) == null) {
            vistaAdministrador.idNoValido();
        } else if (gestorDeUsuarios.buscarUsuario( nombreDeUsuario).getContraseña().equals(contraseña)) {
            FuncionesDeCorreo codigo = new FuncionesDeCorreo(gestorDeUsuarios.buscarUsuario( nombreDeUsuario).getCorreo());
            if(codigo.getCodigoDeCorreo().equals(vistaAdministrador.inicioDeSecionCodigo())){
                vistaAdministrador.saludarUsuario();
            }
        }

    }
}


