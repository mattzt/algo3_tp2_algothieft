package edu.fiuba.algo3.Policia;

public class Detective implements Rango
{
    public void Detective()
    {
        casosResueltos = 5;
    }

    @Override
    public int velocidadViaje() {
        return 1100;
    }
}
