package edu.fiuba.algo3.modelo.Policia;

public abstract class Rango
{
    int casosResueltos;
    //public abstract int tiempoViaje(Ciudad unCiudad);
    abstract int velocidadViaje();
    public int arrestos()
    {
        return casosResueltos;
    }
    abstract Rango promover();


}
