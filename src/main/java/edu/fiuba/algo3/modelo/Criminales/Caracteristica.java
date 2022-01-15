package edu.fiuba.algo3.modelo.Criminales;

public interface Caracteristica {
    String valor();

    String crearPista();

    default boolean equals(Caracteristica otraCaracteristica){
        return (this.valor().equals(otraCaracteristica.valor()));
    }
}
