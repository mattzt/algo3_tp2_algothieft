package edu.fiuba.algo3.modelo.Reloj;

public class Viernes implements DiaDeLaSemana {

    @Override
    public DiaDeLaSemana siguienteDia() {
        return new Sabado();
    }

    @Override
    public String diaDeHoy() {
        return "Viernes";
    }
}
