package edu.fiuba.algo3.modelo.Policia;

public class Novato extends Rango{

    private final String dificultad = "FACIL";

    public Novato(){
        casosResueltos = 0;
    }

    @Override
    public int velocidadViaje(){
        return 900;
    }

    @Override
    public Rango promover(){
        if(casosResueltos < 5)
            return this;
        return new Detective();
    }

    @Override
    public int nivelDeLosObjetosBuscados() {
        return 1;
    }

    @Override
    public String toString(){
        return dificultad;
    }
}
