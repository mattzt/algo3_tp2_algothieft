package edu.fiuba.algo3.modelo.ComputadoraInterpol;

import edu.fiuba.algo3.modelo.Policia.Rango;

public interface OrdenDeArresto {
    String nombre();

    Rango evaluarRango(Rango rango);

    default boolean equals(OrdenDeArresto otraOrden){
        return this.nombre().equals(otraOrden.nombre());
    }
}
