package edu.fiuba.algo3.modelo.Sexo;

import edu.fiuba.algo3.modelo.Pistas.PistaCaracteristicasCriminal;

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
}
