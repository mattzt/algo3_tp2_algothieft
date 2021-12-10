package edu.fiuba.algo3.modelo.Hobbies;

import edu.fiuba.algo3.modelo.Criminales.Caracteristicas;
import edu.fiuba.algo3.modelo.Pistas.PistaCaracteristicasCriminal;

public class Croquet implements Caracteristicas {
    @Override
    public String valor() {
        return "Croquet";
    }

    @Override
    public PistaCaracteristicasCriminal darPista() {
        return null;
    }
}
