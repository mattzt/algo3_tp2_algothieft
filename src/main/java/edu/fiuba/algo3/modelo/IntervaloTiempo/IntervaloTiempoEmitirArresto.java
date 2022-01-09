package edu.fiuba.algo3.modelo.IntervaloTiempo;

public class IntervaloTiempoEmitirArresto implements IntervaloTiempo{
    @Override
    public int pasarTiempo(int horas) {
        return horas + 3;
    }
}
