package Ivercion;

import Modelos.Proyecto;

import java.time.LocalDate;

public class Inversion {
    private Proyecto proyecto1;
    private float cantidadInvertida;
    private LocalDate fechaDeInversion;

    public Inversion(Proyecto proyecto, float cantidadInvertida, LocalDate fechaDeInvercion) {
        this.proyecto1 = proyecto;
        this.cantidadInvertida = cantidadInvertida;
        this.fechaDeInversion = fechaDeInvercion;
    }
}
