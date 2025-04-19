package Modelos;

import javax.swing.*;

public class RecompensasDeProyecto {
    private String idDeRecompensa;
    private String descripcionDeRecompensas;
    private int cantidadDeRecompensa;


    public RecompensasDeProyecto(String descripcionDeRecompensas, int cantidadDeRecompensa,String idDeRecompensa) {
        this.descripcionDeRecompensas = descripcionDeRecompensas;
        this.cantidadDeRecompensa = cantidadDeRecompensa;
        this.idDeRecompensa = idDeRecompensa;
    }

    public String getIdDeRecompensa() {
        return idDeRecompensa;
    }

    @Override
    public String toString() {
        return descripcionDeRecompensas + " la cantidad final es " + cantidadDeRecompensa;
    }
}
