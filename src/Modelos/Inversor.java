package Modelos;

import Ivercion.Inversion;

import java.time.LocalDate;
import java.util.ArrayList;

public class Inversor extends Usuario {

    private ArrayList<Inversion>inversiones;
    private ArrayList<Proyecto> proyectosInvertidos;
    private int cartera ;
    private ArrayList<Amigo> amigos;
    private boolean usuarioBloqueado;

    public Inversor(String nombre, String contraseña, String correo, boolean secion, int cartera,String id) {
        super(nombre, contraseña, correo,id);
        this.cartera = cartera;
        usuarioBloqueado = false;
        proyectosInvertidos = new ArrayList<>();
    }

    @Override
    public void cerrarSecion() {
        setSecion(false);
    }

    public void añadirSaldoACartera(int saldo) {
        this.cartera += saldo;
    }

    public int verCatera() {
        return cartera;
    }

    public boolean cambioDeUsusario(String nuevoUsuario ){
        super.cambioDeNombreDeUsusario(nuevoUsuario);
        return true;
    }

    public boolean cambioDeContraseña(String nuevaContraseña ){
        super.cambioDeContraseña(nuevaContraseña);
        return true;
    }

    public boolean añadirAmigo(Amigo amigo){amigos.add(amigo);return true;}

    public void setUsuarioBloqueado(boolean usuarioBloqueado) {
        this.usuarioBloqueado = usuarioBloqueado;
    }

    public ArrayList<Amigo> verListaDeAmigos(){
        return amigos;
    }

    public void invertir(Proyecto proyecto, float cantidad, LocalDate fechaDeInversion){
        Inversion inversion = new Inversion(proyecto,cantidad, fechaDeInversion);
        inversiones.add(inversion);
        proyectosInvertidos.add(proyecto);
    }

    public ArrayList<Proyecto> mostrarArrayDeProyectosInvertidos(){
        return proyectosInvertidos;
    }

   public ArrayList<Inversion> motrarArrayDeInversiones(){
        return inversiones;
   }




}

