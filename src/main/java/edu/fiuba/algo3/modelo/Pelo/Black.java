package edu.fiuba.algo3.modelo.Pelo;

import edu.fiuba.algo3.modelo.Criminales.Caracteristicas;
import edu.fiuba.algo3.modelo.Pistas.PistaCaracteristicasCriminal;

import java.util.Objects;

public class Black implements Caracteristicas {
    @Override
    public String valor() {
        return "Black";
    }

    @Override
    public PistaCaracteristicasCriminal darPista() {
        return null;
    }

    @Override
    public boolean equals(Caracteristicas recibida) {
        return Objects.equals(this.valor(), recibida.valor());
    }
}
