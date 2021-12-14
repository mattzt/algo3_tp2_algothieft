package edu.fiuba.algo3.modelo.Policia;

public class Investigador extends Rango{

    private final String dificultad = "NORMAL";

    public Investigador(){
        casosResueltos = 10;
    }

    @Override
    public int velocidadViaje(){
        return 1300;
    }

    @Override
    public Rango promover(){
        if(casosResueltos < 20 && casosResueltos > 10)
            return this;
        return new Sargento();
    }

    @Override
    public String toString(){
        return dificultad;
    }
}
