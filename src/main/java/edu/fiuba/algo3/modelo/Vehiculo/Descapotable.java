package edu.fiuba.algo3.modelo.Vehiculo;

import edu.fiuba.algo3.modelo.Criminales.Caracteristicas;
import edu.fiuba.algo3.modelo.Pistas.PistaCaracteristicasCriminal;

import java.util.Objects;

public class Descapotable implements Caracteristicas {
    @Override
    public String valor() {
        return "Descapotable";
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
