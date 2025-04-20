package Modelos;

import Inversión.Inversion;
import MoldelosGestores.GestorDeProyecto;

import java.time.LocalDate;
import java.util.ArrayList;

public class Proyecto implements Inversible {
    private String id;
    private String nombre;
    private String descripcion;
    private Categoria categoria;
    private float cantidadNecesaria;
    private int cantidadFinanciada;
    private LocalDate fechaDeApertura;
    private LocalDate fechaDeFin;
    private ArrayList <RecompensasDeProyecto> recompensas;
    private ArrayList<Inversion> invercionesRealizadas;

    public Proyecto(String nombre, String descripcion, Categoria categoria, int cantidadNecesaria, int cantidadFinanciada, LocalDate fechaDeApertura, LocalDate fechaDeFin,String id) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.cantidadNecesaria = cantidadNecesaria;
        this.cantidadFinanciada = cantidadFinanciada;
        this.fechaDeApertura = fechaDeApertura;
        this.fechaDeFin = fechaDeFin;
        this.id = id;
        recompensas = new ArrayList<>();
        invercionesRealizadas = new ArrayList<>();
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

    public void setCantidadFinanciada(int cantidadFinanciada) {
        this.cantidadFinanciada = cantidadFinanciada;
    }

    public void setFechaDeApertura(LocalDate fechaDeApertura) {
        this.fechaDeApertura = fechaDeApertura;
    }

    public void setFechaDeFin(LocalDate fechaDeFin) {
        this.fechaDeFin = fechaDeFin;
    }

    public void añadirRecompensa(RecompensasDeProyecto recompensasDeProyecto){
        recompensas.add(recompensasDeProyecto);
    }

    public ArrayList<RecompensasDeProyecto> verArrayDeProyecto(){
        return recompensas;
    }


    public void modificarRecompensa(RecompensasDeProyecto nuevaRecompensa, String idRecompensa){
        for (int i = 0; i <recompensas.size() ; i++) {
            if(recompensas.get(i).getIdDeRecompensa().equals(idRecompensa)){
                recompensas.add(i,nuevaRecompensa);
            }
        }
    }


    public String getNombre() {
        return nombre;
    }

    public Inversion verInversion(int inversionIndividual){
        for (int i = 0; i <invercionesRealizadas.size() ; i++) {
            return invercionesRealizadas.get(i);
        }
        return null;
    }

    public ArrayList<Inversion> getInvercionesRealizadas() {
        return invercionesRealizadas;
    }

    public int cantidadDeInversores(){
        return invercionesRealizadas.size();
    }


    @Override
    public void aumentarInversion(int candtidadAumentada) {
        setCantidadNecesaria(candtidadAumentada);
    }

    @Override
    public void disminuirInversion(int cantidadDisminuida) {
    setCantidadNecesaria(cantidadDisminuida);
    }

    public int getCantidadFinanciada() {
        return cantidadFinanciada;
    }

    public LocalDate getFechaDeApertura() {
        return fechaDeApertura;
    }

    public void añadirInversionEnProyecto(Inversion inversion){
        invercionesRealizadas.add(inversion);
    }

    @Override
    public String toString() {
        return "El nombre del proyecto es " + nombre +
                ", su descripción es " + descripcion +
                ". Pertenece a la categoría " + categoria +
                ". Se necesita una cantidad de " + cantidadNecesaria +
                " y hasta ahora se ha financiado " + cantidadFinanciada +
                ". La fecha de apertura fue " + fechaDeApertura +
                " y la fecha de finalización es " + fechaDeFin +
                ". Las recompensas ofrecidas son de " + recompensas;
    }
}
