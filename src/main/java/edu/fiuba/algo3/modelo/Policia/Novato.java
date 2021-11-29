package edu.fiuba.algo3.modelo.Policia;

public class Novato extends Rango
{
    Novato() {
        casosResueltos = 0;
    }

    @Override
    public int velocidadViaje() {
        return 900;
    }
}
