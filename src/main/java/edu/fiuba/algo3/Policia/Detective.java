package edu.fiuba.algo3.Policia;

public class Detective implements Rango
{
    public void Detective()
    {
        velocidad = 1100;
        casosResueltos = 5;
    }

    @Override
    public int tiempoViaje(Ciudad unaCiudad)
    {
        return 0;
    }
}
