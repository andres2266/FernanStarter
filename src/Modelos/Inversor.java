package Modelos;

import Ivercion.Inversion;

import java.util.ArrayList;

public class Inversor extends Usuario {
    private ArrayList<Inversion>inversionesRealizadas;
    private int cartera ;
    private ArrayList<Amigo> amigos;
    private boolean usuarioBloqueado;

    public Inversor(String nombre, String correo, String contraseña,int cartera) {
        super(nombre, correo, contraseña);
        this.cartera = cartera;
        usuarioBloqueado = false;
        inversionesRealizadas = new ArrayList<>();
    }

    @Override
    public void cerrarSecion() {
        setBloqueado(false);
    }

    public void añadirSaldoACartera(int saldo) {
        this.cartera += saldo;
    }

    public void restarSaldoACartera(int saldo) {
        this.cartera -= saldo;
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

    public ArrayList<Inversion> mostrarListaDeInversiones(){
        return inversionesRealizadas;
    }

    public void invertir(Inversion inversion){
        inversionesRealizadas.add(inversion);
    }


}

