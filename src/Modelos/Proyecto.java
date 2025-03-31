package Modelos;

import java.time.LocalDate;
import java.util.ArrayList;

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





//    public void Grafico (){
//        System.out.println("Gráfico:");
//
//        int porcentaje = 10;
//        ArrayList<String> Inversores= new ArrayList<>();
//        aporteInversor1 = (arrayIntProyecto[1 + jj] * 100) / arrayIntProyecto[0 + jj];
//        aporteInversor2 = (arrayIntProyecto[2 + jj] * 100) / arrayIntProyecto[0 + jj];
//
//        int aporteTotal = aporteInversor1 + aporteInversor2;
//
//
//        System.out.println("Aporte inversor 1 -> \033[33m■\u001B[0m");
//        System.out.println("Aporte inversor 2 -> \u001B[34m■\u001B[0m");
//        System.out.println("Aporte total -> \u001B[32m■\u001B[0m");
//        System.out.print("  \u001B[32m");
//
//        System.out.print("\n\u001B[35m|\n");
//
//        System.out.print("|\u001B[0m");
//        for (int j = 0; j < (aporteInversor1 - 2); j++) {
//            System.out.print("\033[33m■\u001B[0m");
//
//        }
//        System.out.print("\n\u001B[35m|\u001B[0m");
//        for (int j = 0; j < (aporteInversor2 - 2); j++) {
//            System.out.print("\u001B[34m■\u001B[0m");
//
//        }
//        System.out.print("\n\u001B[35m|\u001B[0m");
//
//        for (int j = 0; j < (aporteTotal - 2); j++) {
//            System.out.print("\u001B[32m■\u001B[0m");
//
//        }
//        System.out.print("\n\u001B[35m|\u001B[0m");
//        for (int r = 0; r < 10; r++) {
//            System.out.print("\u001B[35m");
//            System.out.print("_______" + porcentaje + "%\u001B[0m");
//            porcentaje = porcentaje + 10;
//
//        }
//    }

    @Override
    public void aumentarInversion(int candtidadAumentada) {
        setCantidadNecesaria(candtidadAumentada);
    }

    @Override
    public void disminuirInversion(int cantidadDisminuida) {
    setCantidadNecesaria(cantidadDisminuida);
    }
}
