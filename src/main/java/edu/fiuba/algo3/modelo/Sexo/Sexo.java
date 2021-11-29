package edu.fiuba.algo3.modelo.Sexo;

public interface Sexo {

    default boolean esDeSexo(Sexo unSexo){
        return unSexo.getClass() == this.getClass();
    }
}
