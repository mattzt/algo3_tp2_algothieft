package edu.fiuba.algo3.modelo.ComputadoraInterpol;

import edu.fiuba.algo3.modelo.Policia.Rango;

public class Emitida implements OrdenDeArresto{

    @Override
    public String arrestar(){
        return "Arrestaste al criminal!";
    }

    @Override
    public Rango evaluarRango(Rango rango){
        rango.aumentarCasosResueltos();
        return rango.promover();
    }
}

