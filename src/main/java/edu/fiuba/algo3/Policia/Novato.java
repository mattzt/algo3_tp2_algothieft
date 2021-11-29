package edu.fiuba.algo3.Policia;

public class Novato implements Rango
{
    public void Novato()
    {
        casosResueltos = 0;
        velocidad = 900;
    }

    @Override
    public int tiempoViaje(Ciudad unaCiudad) {
        return 0;
    }
}
