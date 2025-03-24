package MoldelosGestores;


import Modelos.Proyecto;
import Modelos.Usuario;

import java.util.ArrayList;
import java.util.HashMap;

public class GestorDeUsuarios {

    private HashMap<String, Usuario> gestorDeUsuarios = new HashMap<>();
    private static int usuariosInsertados = 0;

    public GestorDeUsuarios() {
        gestorDeUsuarios = new HashMap<>();
    }

    public void agregarUsuarios(Usuario usuario) {
        gestorDeUsuarios.put(usuario.getId(), usuario);
        usuariosInsertados++;
    }

    public boolean eliminarUsuario(String id) {
        gestorDeUsuarios.remove(id);
        return true;
    }

    public Usuario buscarUsuario(String id) {
        if (gestorDeUsuarios.get(id) == null) {
            return null;
        } else {
            return gestorDeUsuarios.get(id);
        }
    }


    public boolean modificarUsuaio(Usuario usuaio, String id) {
        if (gestorDeUsuarios.get(id) == null) {
            return false;

        } else {
            gestorDeUsuarios.put(id, usuaio);
            return true;
        }
    }


}