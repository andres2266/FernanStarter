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
        for (int i = 0; i < gestorDeUsuarios.getGestorUsuarios().size(); i++){
            if (gestorDeUsuarios.getGestorUsuarios().get(i).getId().equals(id)){
                gestorDeUsuarios.getGestorUsuarios().get(i).setContraseña(contraseña);
                vistaAdministrador.cambioDeContraseña();
            }
        }
    }

    public void cambiarUsuarioDeAdministrador(String nombreDeUsuario, String id) {
        for (int i = 0; i < gestorDeUsuarios.getGestorUsuarios().size(); i++) {
            if (gestorDeUsuarios.getGestorUsuarios().get(i).getId().equals(id)) {
                gestorDeUsuarios.getGestorUsuarios().get(i).setNombre(nombreDeUsuario);
                vistaAdministrador.cambioDeUsuario();
            }
        }
    }

    public void cerrarCecionDeAdmin(String nombreDeUsuario, String id) {
        for (int i = 0; i < gestorDeUsuarios.getGestorUsuarios().size(); i++) {
            if (gestorDeUsuarios.getGestorUsuarios().get(i).getId().equals(id)) {
                gestorDeUsuarios.getGestorUsuarios().get(i).cerrarSecion();
            }
        }
    }

    public void desbloquearUsuario(String id) {
        for (int i = 0; i < gestorDeUsuarios.getGestorUsuarios().size(); i++) {
            if (gestorDeUsuarios.getGestorUsuarios().get(i).getId().equals(id)){
                gestorDeUsuarios.getGestorUsuarios().get(i).setSecion(false);
                vistaAdministrador.usuarioDesbloqueado();
            }
        }
    }
    public void bloquearUsuario(String id) {
        for (int i = 0; i < gestorDeUsuarios.getGestorUsuarios().size(); i++) {
            if (gestorDeUsuarios.getGestorUsuarios().get(i).getId().equals(id)) {
                gestorDeUsuarios.getGestorUsuarios().get(i).setSecion(true);
                vistaAdministrador.usuarioDesbloqueado();
            }
        }
    }
}
