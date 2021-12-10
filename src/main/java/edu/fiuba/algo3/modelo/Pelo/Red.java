package edu.fiuba.algo3.modelo.Pelo;

import edu.fiuba.algo3.modelo.Criminales.Caracteristicas;
import edu.fiuba.algo3.modelo.Pistas.PistaCaracteristicasCriminal;

public class Red implements Caracteristicas {
    @Override
    public String valor() {
        return "Red";
    }

    @Override
    public PistaCaracteristicasCriminal darPista() {
        return null;
    }
}
