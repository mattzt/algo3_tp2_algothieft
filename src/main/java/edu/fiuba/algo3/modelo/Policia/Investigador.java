package edu.fiuba.algo3.modelo.Policia;

public class Investigador implements Rango
{
    public Investigador(){
    }

    @Override
    public int casosResueltos() {
        return 10;
    }

    @Override
    public int velocidadViaje() {
        return 1300;
    }
}
