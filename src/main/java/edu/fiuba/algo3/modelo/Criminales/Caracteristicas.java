package edu.fiuba.algo3.modelo.Criminales;

import edu.fiuba.algo3.modelo.Pistas.PistaCaracteristicasCriminal;

public interface Caracteristicas {
    String valor();
    PistaCaracteristicasCriminal darPista();

    boolean equals(Caracteristicas recibida);
}
