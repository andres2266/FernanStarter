package Modelos;

import java.time.LocalDate;

public class Proyecto implements Inversible {
    private String id;
    private String nombre;
    private String descripcion;
    private Categoria categoria;
    private float cantidadNecesaria;
    private float cantidadFinanciada;
    private LocalDate fechaDeApertura;
    private LocalDate fechaDeFin;
    private float recompensas;

    public Proyecto(String nombre, String descripcion, Categoria categoria, int cantidadNecesaria, int cantidadFinanciada, LocalDate fechaDeApertura, float recompensas, LocalDate fechaDeFin,String id) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.cantidadNecesaria = cantidadNecesaria;
        this.cantidadFinanciada = cantidadFinanciada;
        this.fechaDeApertura = fechaDeApertura;
        this.recompensas = recompensas;
        this.fechaDeFin = fechaDeFin;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCantidadNecesaria(float cantidadNecesaria) {
        this.cantidadNecesaria = cantidadNecesaria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setCantidadFinanciada(float cantidadFinanciada) {
        this.cantidadFinanciada = cantidadFinanciada;
    }

    public void setFechaDeApertura(LocalDate fechaDeApertura) {
        this.fechaDeApertura = fechaDeApertura;
    }

    public void setFechaDeFin(LocalDate fechaDeFin) {
        this.fechaDeFin = fechaDeFin;
    }

    public void setRecompensas(float recompensas) {
        this.recompensas = recompensas;
    }

    public String getNombre() {
        return nombre;
    }


    @Override
    public void aumentarInvercion(int candtidadAumentada) {
        setCantidadNecesaria(candtidadAumentada);
    }

    @Override
    public void disminuirInvercion(int cantidadDisminuida) {
    setCantidadNecesaria(cantidadDisminuida);
    }
}
