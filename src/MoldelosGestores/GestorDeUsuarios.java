package MoldelosGestores;

import Modelos.Usuario;

import java.util.ArrayList;

public class GestorDeUsuarios {
    private ArrayList<Usuario> gestorDeUsuarios;
    private static int usuariosInsertados = 0;

    public GestorDeUsuarios(){
        gestorDeUsuarios = new ArrayList<Usuario>();}

    public void agregarUsuarios(Usuario usuario){
        gestorDeUsuarios.add(usuario);
        usuariosInsertados++;
    }

    public boolean eliminarUsuario(String id){
        for (int i = 0; i <gestorDeUsuarios.size() ; i++) {
            if(gestorDeUsuarios.get(i).getId().equals(id)){
                gestorDeUsuarios.remove(i);
                return true;
            }
        }
        return  false;
    }

    public Usuario buscarUsuario(String id){
        for (int i = 0; i <gestorDeUsuarios.size() ; i++) {
            if(gestorDeUsuarios.get(i).getId().equals(id)){
                return gestorDeUsuarios.get(i);
            }
        }
        return null;
    }

    public boolean modificarUsuaio(Usuario usuaio,String id){
        for (int i = 0; i <gestorDeUsuarios.size(); i++) {
            if(gestorDeUsuarios.get(i).getId().equals(id)){
                gestorDeUsuarios.add(i,usuaio);
                return true;
            }
        }
        return false;
    }
    public ArrayList<Usuario> getGestorUsuarios(){
        return gestorDeUsuarios;
    }

}
