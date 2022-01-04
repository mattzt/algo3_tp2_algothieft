package edu.fiuba.algo3.modelo.IntervaloTiempo;

public class IntervaloTiempoExplorarEdificio implements IntervaloTiempo{
    private final int horasPorVecesVisitado;

    public IntervaloTiempoExplorarEdificio(int veces) {
        if ((veces + 1) > 3)
            horasPorVecesVisitado = 3;
        else
            horasPorVecesVisitado = veces + 1;
    }

    @Override
    public int pasarTiempo(int horas) {
        return horas + horasPorVecesVisitado;
    }
}
