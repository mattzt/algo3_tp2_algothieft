package edu.fiuba.algo3.modelo.Criminales.Sexo;

public interface Sexo {

    static Sexo crear(String unSexo){
        if (unSexo.equals("Femenino")) return new SexoFemenino();
        return new SexoMasculino();
    }

    String valor();

    default boolean sexoEsIgualA(Sexo sexo){
        return this.valor().equals(sexo.valor());
    }
}
