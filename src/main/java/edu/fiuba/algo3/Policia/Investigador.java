package edu.fiuba.algo3.Policia;

public class Investigador implements Rango
{
    public void Investigador()
    {
        casosResueltos = 10;
    }


    @Override
    public int velocidadViaje() {
        return 1300;
    }
}
