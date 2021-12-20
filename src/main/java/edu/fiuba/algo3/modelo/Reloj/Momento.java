package edu.fiuba.algo3.modelo.Reloj;

public class Momento {
    private final DiaDeLaSemana dia;
    private final int hora;

    public Momento(DiaDeLaSemana dia, int hora){
        this.dia = dia;
        this.hora = hora;
    }

    public String obtenerFecha(){
        return dia.diaDeHoy() + ", " + hora + "hs.";
    }
}
