package edu.fiuba.algo3.modelo.Policia;

public class Investigador extends Rango
{
    Investigador(){
        casosResueltos = 10;
    }


    @Override
    public int velocidadViaje() {
        return 1300;
    }
}
