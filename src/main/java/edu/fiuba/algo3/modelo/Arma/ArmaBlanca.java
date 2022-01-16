package edu.fiuba.algo3.modelo.Arma;

import edu.fiuba.algo3.modelo.IntervaloTiempo.IntervaloTiempo;
import edu.fiuba.algo3.modelo.IntervaloTiempo.IntervaloTiempoExplorarEdificio;
import edu.fiuba.algo3.modelo.Policia.*;

public class ArmaBlanca extends Arma{

    @Override
    public IntervaloTiempo tiempoIncapacitacion() {
        return new IntervaloTiempoExplorarEdificio(2);
    }

}
