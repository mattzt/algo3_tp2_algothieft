package edu.fiuba.algo3.modelo.Policia;

public abstract class Rango
{
    protected int casosResueltos;

    public abstract int velocidadViaje();

    public abstract Rango promover();

    public void aumentarCasosResueltos(){
        casosResueltos++;
    }

    public boolean equals(Rango otroRango){
        return (this.velocidadViaje() == otroRango.velocidadViaje());
    }

    public abstract int nivelDeLosObjetosBuscados();

}
