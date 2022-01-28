package edu.fiuba.algo3.modelo.Arma;

import edu.fiuba.algo3.modelo.IntervaloTiempo.IntervaloTiempo;

public interface Arma {
    IntervaloTiempo tiempoIncapacitacion(int vecesAtacado);
}
