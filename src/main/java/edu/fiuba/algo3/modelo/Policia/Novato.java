package edu.fiuba.algo3.modelo.Policia;

public class Novato implements Rango
{
    public Novato() {
    }

    @Override
    public int casosResueltos(){
        return 0;
    }

    @Override
    public int velocidadViaje() {
        return 900;
    }
}
