package edu.fiuba.algo3.modelo.Criminales.Sexo;

import edu.fiuba.algo3.modelo.Criminales.Caracteristicas;

public abstract class Sexo {

    public abstract String valor();

    public  boolean sexoEsIgualA(Sexo sexo){
        return (sexo.getClass()==this.getClass());
    }
}
