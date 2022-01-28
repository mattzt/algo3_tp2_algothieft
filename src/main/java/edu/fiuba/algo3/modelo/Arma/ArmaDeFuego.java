package edu.fiuba.algo3.modelo.Arma;

import edu.fiuba.algo3.modelo.IntervaloTiempo.IntervaloHeridaArmaDeFuego;
import edu.fiuba.algo3.modelo.IntervaloTiempo.IntervaloTiempo;

public class ArmaDeFuego implements Arma{

    @Override
    public IntervaloTiempo tiempoIncapacitacion(int vecesAtacado) {
        return new IntervaloHeridaArmaDeFuego();
    }
}
