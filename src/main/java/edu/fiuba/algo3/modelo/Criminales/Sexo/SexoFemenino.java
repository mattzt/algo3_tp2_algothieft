package edu.fiuba.algo3.modelo.Criminales.Sexo;

import edu.fiuba.algo3.modelo.Criminales.Caracteristicas;
import edu.fiuba.algo3.modelo.Pistas.PistaCaracteristicasCriminal;

import java.util.Objects;

public class SexoFemenino implements Sexo {

    @Override
    public String valor() {
        return "Femenino";
    }

}
