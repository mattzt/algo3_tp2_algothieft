package edu.fiuba.algo3.modelo.IntervaloTiempo;

public class IntervaloHeridaArmaDeFuego implements IntervaloTiempo{
    @Override
    public int pasarTiempo(int horas) {
        return horas + 4;
    }
}
