package edu.fiuba.algo3.modelo.IntervaloTiempo;

public class IntervaloTiempoViajeaPais implements IntervaloTiempo{
    private final int velocidad;
    private final int distancia;

    public IntervaloTiempoViajeaPais(int unaVelocidad, int unaDistancia)
    {
        velocidad = unaVelocidad;
        distancia = unaDistancia;
    }

    @Override
    public int pasarTiempo(int horas) {
        return horas + (distancia / velocidad);
    }
}
