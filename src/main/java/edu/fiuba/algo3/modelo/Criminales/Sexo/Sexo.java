package edu.fiuba.algo3.modelo.Criminales.Sexo;

import edu.fiuba.algo3.modelo.Criminales.Caracteristica;

public interface Sexo extends Caracteristica {

    static Sexo crear(String unSexo){
        if (unSexo.equals("Femenino")) return new SexoFemenino();
        return new SexoMasculino();
    }
}
