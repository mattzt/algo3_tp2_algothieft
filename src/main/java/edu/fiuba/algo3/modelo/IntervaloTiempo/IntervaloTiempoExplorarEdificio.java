package edu.fiuba.algo3.modelo.IntervaloTiempo;

public class IntervaloTiempoExplorarEdificio implements IntervaloTiempo{
    private int vecesVisitado;
    public IntervaloTiempoExplorarEdificio(int veces)
    {
        vecesVisitado = veces;
    }
    @Override
    public int pasarTiempo(int horas) {
        return horas + vecesVisitado;
    }
}
