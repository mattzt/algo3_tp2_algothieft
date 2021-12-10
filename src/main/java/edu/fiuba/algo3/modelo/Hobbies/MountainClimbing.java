package edu.fiuba.algo3.modelo.Hobbies;

import edu.fiuba.algo3.modelo.Criminales.Caracteristicas;
import edu.fiuba.algo3.modelo.Pistas.PistaCaracteristicasCriminal;

public class MountainClimbing implements Caracteristicas {
    @Override
    public String valor() {
        return "Mountain Climbing";
    }

    @Override
    public PistaCaracteristicasCriminal darPista() {
        return null;
    }
}
