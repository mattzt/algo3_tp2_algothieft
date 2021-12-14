package edu.fiuba.algo3.modelo.Policia;

public class Detective extends Rango{

    private final String dificultad = "FACIL";

    public Detective(){
        casosResueltos = 5;
    }

    @Override
    public int velocidadViaje(){
        return 1100;
    }

    @Override
    public Rango promover(){
        if(casosResueltos < 10 && casosResueltos > 5)
            return this;
        return new Investigador();
    }

    @Override
    public int nivelDeLosObjetosBuscados() {
        return 2;
    }

    @Override
    public String toString(){
        return dificultad;
    }
}
