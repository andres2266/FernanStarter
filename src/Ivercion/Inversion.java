package Ivercion;

import Modelos.Inversor;
import Modelos.Proyecto;

import java.time.LocalDate;

public class Inversion {
    private Proyecto proyecto1;
    private float cantidadInvertida;
    private LocalDate fechaDeInversion;
    private Inversor inversor;

    public Inversion(Proyecto proyecto, float cantidadInvertida, LocalDate fechaDeInvercion,Inversor inversor) {
        this.proyecto1 = proyecto;
        this.cantidadInvertida = cantidadInvertida;
        this.fechaDeInversion = fechaDeInvercion;
        this.inversor = inversor;
    }
}
