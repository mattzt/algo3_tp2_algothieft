package edu.fiuba.algo3.modelo.Sexo;

import edu.fiuba.algo3.modelo.Pistas.PistaCaracteristicasCriminal;

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
}
