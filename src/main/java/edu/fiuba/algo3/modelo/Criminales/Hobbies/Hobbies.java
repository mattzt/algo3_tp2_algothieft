package edu.fiuba.algo3.modelo.Criminales.Hobbies;

import edu.fiuba.algo3.modelo.Criminales.Sexo.Sexo;

public abstract class Hobbies {

    public abstract String valor();

    public  boolean hobbiesEsIgualA(Hobbies hobbies){
        return (hobbies.getClass()==this.getClass());
    }
}
