package edu.fiuba.algo3.modelo.Policia;

public class Detective extends Rango
{
    Detective(){
        casosResueltos = 5;
    }

    @Override
    public int velocidadViaje() {
        return 1100;
    }
}
