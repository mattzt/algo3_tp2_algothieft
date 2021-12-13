package edu.fiuba.algo3.modelo.Criminales.Sexo;

import edu.fiuba.algo3.modelo.Criminales.Caracteristicas;
import edu.fiuba.algo3.modelo.Pistas.PistaCaracteristicasCriminal;

import java.util.Objects;

public class SexoFemenino implements Sexo{
    public SexoFemenino(){}

    @Override
    public String valor() {
        return "Femenino";
    }

    @Override
    public PistaCaracteristicasCriminal darPista() {
        return new PistaCaracteristicasCriminal("Vi a una mujer");
    }

    @Override
    public boolean equals(Caracteristicas recibida) {
        return Objects.equals(this.valor(), recibida.valor());
    }
}
