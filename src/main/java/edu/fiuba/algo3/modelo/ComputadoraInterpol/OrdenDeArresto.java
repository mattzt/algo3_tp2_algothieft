package edu.fiuba.algo3.modelo.ComputadoraInterpol;

import edu.fiuba.algo3.modelo.Policia.Rango;

public interface OrdenDeArresto {
    String arrestar();

    public Rango evaluarRango(Rango rango);
}
