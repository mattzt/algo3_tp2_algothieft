package edu.fiuba.algo3.modelo.Reloj;

public class Miercoles implements DiaDeLaSemana {

    @Override
    public DiaDeLaSemana siguienteDia() {
        return new Jueves();
    }

    @Override
    public String diaDeHoy() {
        return "Miercoles";
    }
}
