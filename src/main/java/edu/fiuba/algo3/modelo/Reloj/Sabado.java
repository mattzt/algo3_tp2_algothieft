package edu.fiuba.algo3.modelo.Reloj;

public class Sabado implements DiaDeLaSemana {

    @Override
    public DiaDeLaSemana siguienteDia() {
        return new Domingo();
    }

    @Override
    public String diaDeHoy() {
        return "Sabado";
    }
}
