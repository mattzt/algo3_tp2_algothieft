package edu.fiuba.algo3.modelo.Criminales.Pelo;

import edu.fiuba.algo3.modelo.Criminales.Sexo.Sexo;

public abstract class Pelo {

    public abstract String valor();

    public  boolean peloEsIgualA(Pelo pelo){
        return (pelo.getClass()==this.getClass());
    }
}
