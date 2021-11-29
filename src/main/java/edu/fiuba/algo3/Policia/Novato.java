package edu.fiuba.algo3.Policia;

public class Novato implements Rango
{
    public void Novato()
    {
        casosResueltos = 0;
    }

    @Override
    public int velocidadViaje() {
        return 900;
    }
}
