package Controladores;

import MoldelosGestores.GestorDeUsuarios;
import Vistas.VistaAdministrador;

public class ControladorAdministrador {
    private GestorDeUsuarios gestorDeUsuarios;
    private VistaAdministrador vistaAdministrador;

    public ControladorAdministrador(GestorDeUsuarios gestorDeUsuarios, VistaAdministrador vistaAdministrador) {
        this.gestorDeUsuarios = gestorDeUsuarios;
        this.vistaAdministrador = vistaAdministrador;
    }

    public void cambiarContraseñaAdministrdor(String contraseña, String id){
               gestorDeUsuarios.buscarUsuario(id).setContraseña(contraseña);
                vistaAdministrador.cambioDeContraseña();
            }


    public void cambiarUsuarioDeAdministrador(String nombreDeUsuario, String id) {
                gestorDeUsuarios.buscarUsuario(id).setNombre(nombreDeUsuario);
                vistaAdministrador.cambioDeUsuario();
            }


    public void cerrarCecionDeAdmin(String nombreDeUsuario, String id) {
            gestorDeUsuarios.buscarUsuario(id).cerrarSecion();
        }


    public void desbloquearUsuario(String id) {
        gestorDeUsuarios.buscarUsuario(id).setSecion(false);
                vistaAdministrador.usuarioDesbloqueado();
            }


    public void bloquearUsuario(String id) {
        gestorDeUsuarios.buscarUsuario(id).setSecion(true);
        vistaAdministrador.usuarioBloqueado();
            }
        }


