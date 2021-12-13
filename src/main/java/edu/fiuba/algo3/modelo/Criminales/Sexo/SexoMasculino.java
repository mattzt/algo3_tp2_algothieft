package edu.fiuba.algo3.modelo.Criminales.Sexo;

import edu.fiuba.algo3.modelo.Criminales.Caracteristicas;
import edu.fiuba.algo3.modelo.Pistas.PistaCaracteristicasCriminal;

import java.util.Objects;

public class SexoMasculino implements Sexo{
    public SexoMasculino(){}

    @Override
    public String valor() {
        return "Masculino";
    }

    @Override
    public PistaCaracteristicasCriminal darPista() {
        return new PistaCaracteristicasCriminal("Vi a un hombre");
    }

    @Override
    public boolean equals(Caracteristicas recibida) {
        return Objects.equals(this.valor(), recibida.valor());
    }
}
