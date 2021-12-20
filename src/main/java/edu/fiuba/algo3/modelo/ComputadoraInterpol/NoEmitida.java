package edu.fiuba.algo3.modelo.ComputadoraInterpol;

import edu.fiuba.algo3.modelo.Policia.Rango;

public class NoEmitida implements OrdenDeArresto{

    @Override
    public String arrestar(){
        return "No pudiste arrestar al criminal porque no tenias orden de arresto :(";
    }

    @Override
    public Rango evaluarRango(Rango rango){
        return rango;
    }
}
