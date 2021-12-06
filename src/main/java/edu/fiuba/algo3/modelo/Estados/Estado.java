package edu.fiuba.algo3.modelo.Estados;

public interface Estado {

    default boolean comprobarEstado(Estado estado){
        return estado.getClass() == this.getClass();
    }

}
