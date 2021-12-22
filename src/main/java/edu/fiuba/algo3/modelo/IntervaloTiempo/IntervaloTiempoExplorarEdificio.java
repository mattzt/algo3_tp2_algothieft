package edu.fiuba.algo3.modelo.IntervaloTiempo;

public class IntervaloTiempoExplorarEdificio implements IntervaloTiempo{
    private int horasPorVecesVisitado;
    public IntervaloTiempoExplorarEdificio(int veces)
    {
        if (veces > 3){ horasPorVecesVisitado = 3;}
        else {horasPorVecesVisitado = veces;};
    }
    @Override
    public int pasarTiempo(int horas) {
        return horas + horasPorVecesVisitado;
    }
}
