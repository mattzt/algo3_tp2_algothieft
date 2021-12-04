package edu.fiuba.algo3.modelo.Policia;

public class Detective implements Rango
{
    public Detective(){
    }

    @Override
    public int casosResueltos() {
        return 5;
    }

    @Override
    public int velocidadViaje() {
        return 1100;
    }
}
