package edu.fiuba.algo3.modelo.ComputadoraInterpol;

import edu.fiuba.algo3.modelo.Policia.Rango;

public class Emitida implements OrdenDeArresto{

    private final String nombre;

    @Override
    public String nombre(){
        return nombre;
    }

    @Override
    public Rango evaluarRango(Rango rango){
        rango.aumentarCasosResueltos();
        return rango.promover();
    }

    public Emitida(){
        nombre = "Emitida";
    }
}

