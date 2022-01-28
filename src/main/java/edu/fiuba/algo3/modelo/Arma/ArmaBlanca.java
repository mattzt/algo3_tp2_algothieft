package edu.fiuba.algo3.modelo.Arma;

import edu.fiuba.algo3.modelo.IntervaloTiempo.IntervaloIncapacitacionArma;
import edu.fiuba.algo3.modelo.IntervaloTiempo.IntervaloTiempo;
import edu.fiuba.algo3.modelo.IntervaloTiempo.IntervaloTiempoExplorarEdificio;
import edu.fiuba.algo3.modelo.Policia.*;

public class ArmaBlanca implements Arma{

    @Override
    public IntervaloTiempo tiempoIncapacitacion(int vecesAtacado) {
        return new IntervaloIncapacitacionArma(vecesAtacado);
    }

}
