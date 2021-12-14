package edu.fiuba.algo3.modelo.Criminales;

public interface Caracteristica {
    String valor();

    default boolean equals(Caracteristica otraCaracteristica){
        return (this.valor().equals(otraCaracteristica.valor()));
    }
}
