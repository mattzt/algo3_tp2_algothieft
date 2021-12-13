package edu.fiuba.algo3.modelo.Criminales.Hobbies;

import edu.fiuba.algo3.modelo.Criminales.Caracteristicas;
import edu.fiuba.algo3.modelo.Pistas.PistaCaracteristicasCriminal;

import java.util.Objects;

public class Paracaidismo implements Caracteristicas {
    @Override
    public String valor() {
        return "Paracaidismo";
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
