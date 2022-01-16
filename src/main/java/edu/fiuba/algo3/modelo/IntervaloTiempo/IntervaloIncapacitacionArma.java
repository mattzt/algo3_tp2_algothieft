package edu.fiuba.algo3.modelo.IntervaloTiempo;

public class IntervaloIncapacitacionArma implements IntervaloTiempo{
    private int vecesIncapacitado;
    public IntervaloIncapacitacionArma(int veces)
    {
        if (veces >= 2){ vecesIncapacitado = 2;}
        else {vecesIncapacitado = 1;}
    }
    @Override
    public int pasarTiempo(int horas) {
        return horas + vecesIncapacitado;
    }
}
