package edu.fiuba.algo3.modelo.Reloj;

public class Domingo implements DiaDeLaSemana {
    @Override
    public DiaDeLaSemana siguienteDia() {
        return new Lunes();
    }

    @Override
    public String diaDeHoy() {
        return "Domingo";
    }
}
