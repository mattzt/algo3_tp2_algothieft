package edu.fiuba.algo3.modelo.Vehiculo;

import edu.fiuba.algo3.modelo.Criminales.Caracteristicas;
import edu.fiuba.algo3.modelo.Pistas.PistaCaracteristicasCriminal;

public class Limousine implements Caracteristicas {
    @Override
    public String valor() {
        return "Limousine";
    }

    @Override
    public PistaCaracteristicasCriminal darPista() {
        return null;
    }
}
