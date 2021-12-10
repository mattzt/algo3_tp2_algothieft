package edu.fiuba.algo3.modelo.Accesorios;

import edu.fiuba.algo3.modelo.Criminales.Caracteristicas;
import edu.fiuba.algo3.modelo.Pistas.PistaCaracteristicasCriminal;

public class Tattoo implements Caracteristicas {
    @Override
    public String valor() {
        return "Tattoo";
    }

    @Override
    public PistaCaracteristicasCriminal darPista() {
        return null;
    }
}
