package Modelos;

import Ivercion.Inversion;

import java.time.LocalDate;
import java.util.ArrayList;

public class Inversor extends Usuario {

    ArrayList<Inversion>inversiones;
    private int cartera ;
    private ArrayList<Amigo> amigos;
    private boolean usuarioBloqueado;

    public Inversor(String nombre, String contraseña, String correo, boolean secion, int cartera,String id) {
        super(nombre, contraseña, correo,id);
        this.cartera = cartera;
        usuarioBloqueado = false;
    }

    @Override
    public void cerrarSecion() {
        setSecion(false);
    }

    public void añadirSaldo(int saldo) {
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

    public void invertir(Proyecto Proyecto, float cantidad, LocalDate fechaDeInvercion){
        Inversion inversion = new Inversion(Proyecto,cantidad,fechaDeInvercion);
        inversiones.add(inversion);
    }

}

