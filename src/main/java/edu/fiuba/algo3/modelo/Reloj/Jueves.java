package edu.fiuba.algo3.modelo.Reloj;

public class Jueves implements DiaDeLaSemana {
    @Override
    public DiaDeLaSemana siguienteDia() {
        return new Viernes();
    }

    @Override
    public String diaDeHoy() {
        return "Jueves";
    }

}
