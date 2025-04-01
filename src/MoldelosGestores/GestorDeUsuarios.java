package MoldelosGestores;


import Modelos.Gestor;
import Modelos.Inversor;
import Modelos.Usuario;


import java.util.HashMap;

public class GestorDeUsuarios {

    private HashMap<String, Usuario> gestorDeUsuarios;

    public GestorDeUsuarios() {
        gestorDeUsuarios = new HashMap<>();
    }

    public void agregarUsuarios(Usuario usuario) {
        gestorDeUsuarios.put(usuario.getNombre(), usuario);
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

    public Inversor verMetodosDeInversor(Usuario usuario){
        if(usuario.getClass().getSimpleName().equals("Inversor")) {
            Inversor inversor = (Inversor) usuario;
            return inversor;
        }
        return null;
    }


    public Gestor verMetodosDeGestor(Usuario usuario){
        if(usuario.getClass().getSimpleName().equals("Gestor")) {
            Gestor gestor = (Gestor) usuario;
            return gestor;
        }
        return null;
    }

    @Override
    public String toString() {
        return "usuarios" + gestorDeUsuarios;
    }
}