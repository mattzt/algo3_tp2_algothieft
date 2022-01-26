package edu.fiuba.algo3.modelo.Arma;

import edu.fiuba.algo3.modelo.IntervaloTiempo.IntervaloHeridaArmaDeFuego;
import edu.fiuba.algo3.modelo.IntervaloTiempo.IntervaloTiempo;

public class ArmaDeFuego extends Arma{

    @Override
    public IntervaloTiempo tiempoIncapacitacion() {
        return new IntervaloHeridaArmaDeFuego();
    }
}
