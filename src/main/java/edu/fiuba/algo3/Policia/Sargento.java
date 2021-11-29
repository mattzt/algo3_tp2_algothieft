package edu.fiuba.algo3.Policia;

public class Sargento implements Rango
{
    public void Sargento()
    {
        casosResueltos = 20;
        velocidad = 1500;
    }

    @Override
    public int tiempoViaje(Ciudad unaCiudad)
    {
        return 0;
    }
}
