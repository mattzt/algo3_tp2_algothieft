package edu.fiuba.algo3.modelo.Policia;

public abstract class Rango
{
    int casosResueltos;
    //public abstract int tiempoViaje(Ciudad unCiudad);

    abstract int velocidadViaje();

    abstract Rango promover();

    public abstract int nivelDeLosObjetosBuscados();

}
