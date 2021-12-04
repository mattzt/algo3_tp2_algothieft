package edu.fiuba.algo3.modelo.Policia;

public class Sargento implements Rango
{
    public Sargento(){
    }

    @Override
    public int casosResueltos() {
        return 20;
    }

    @Override
    public int velocidadViaje() {
        return 1500;
    }

    public void pasar(){
    }
}
