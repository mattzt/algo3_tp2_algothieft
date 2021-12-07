package edu.fiuba.algo3.modelo.Pistas;


import edu.fiuba.algo3.modelo.Edificios.Edificio;

public abstract class Pista {
    public String pista;


    public String darPista(){
        return pista;
    }

    public abstract Boolean esTipo(Edificio edificio);

}
