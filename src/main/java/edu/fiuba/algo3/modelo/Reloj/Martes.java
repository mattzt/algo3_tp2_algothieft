package edu.fiuba.algo3.modelo.Reloj;

public class Martes implements DiaDeLaSemana {

    @Override
    public DiaDeLaSemana siguienteDia() {
        return new Miercoles();
    }

    @Override
    public String diaDeHoy() {
        return "Martes";
    }
}
