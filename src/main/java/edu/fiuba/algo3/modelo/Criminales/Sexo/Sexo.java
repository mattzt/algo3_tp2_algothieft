package edu.fiuba.algo3.modelo.Criminales.Sexo;

import edu.fiuba.algo3.modelo.Criminales.Caracteristicas;

public interface Sexo extends Caracteristicas {

    static Sexo establecer(String sexo, String pistaSexo){
        if (sexo.equals("Masculino")) return new SexoMasculino();
        return new SexoFemenino();
    }

    default boolean esDeSexo(Sexo unSexo){
        return unSexo.getClass() == this.getClass();
    }
}
