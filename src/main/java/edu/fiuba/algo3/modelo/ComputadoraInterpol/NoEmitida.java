package edu.fiuba.algo3.modelo.ComputadoraInterpol;

public class NoEmitida implements OrdenDeArresto{

    @Override
    public String arrestar(){
        return "No pudiste arrestar al criminal porque no tenias orden de arresto :(";
    }
}
