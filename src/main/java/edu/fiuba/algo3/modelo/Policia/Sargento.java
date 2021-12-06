package edu.fiuba.algo3.modelo.Policia;

public class Sargento extends Rango{

    private final String dificultad = "DIFICIL";

    public Sargento(){
        casosResueltos = 20;
    }

    @Override
    public int velocidadViaje(){
        return 1500;
    }

    @Override
    public Rango promover(){
        return this;
    }

    @Override
    public String toString(){
        return dificultad;
    }
}
