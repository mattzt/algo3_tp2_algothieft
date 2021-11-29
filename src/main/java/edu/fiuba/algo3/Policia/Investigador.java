package edu.fiuba.algo3.Policia;

public class Investigador implements Rango
{
    public void Investigador()
    {
        casosResueltos = 10;
        velocidad = 1300;
    }

    @Override
    public int tiempoViaje(Ciudad unaCiudad)
    {
        return 0;
    }
}
