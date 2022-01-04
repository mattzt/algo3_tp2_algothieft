package edu.fiuba.algo3.modelo.Reloj;

public interface DiaDeLaSemana {
    DiaDeLaSemana siguienteDia();

    String diaDeHoy();

    default boolean equals(DiaDeLaSemana otroDia){
        return this.diaDeHoy().equals(otroDia.diaDeHoy());
    }
}
