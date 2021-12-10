package edu.fiuba.algo3.modelo.Vehiculo;

import edu.fiuba.algo3.modelo.Criminales.Caracteristicas;
import edu.fiuba.algo3.modelo.Pistas.PistaCaracteristicasCriminal;

public class Convertible implements Caracteristicas {
    @Override
    public String valor() {
        return "Convertible";
    }

    @Override
    public PistaCaracteristicasCriminal darPista() {
        return null;
    }
}
