package edu.fiuba.algo3.modelo.ComputadoraInterpol;

import edu.fiuba.algo3.modelo.Policia.Rango;

public class NoEmitida implements OrdenDeArresto{

    private final String nombre;

    @Override
    public String nombre(){
        return nombre;
    }

    @Override
    public Rango evaluarRango(Rango rango){
        return rango;
    }

    public NoEmitida(){
        nombre = "No emitida";
    }
}
