package edu.fiuba.algo3.modelo.Criminales.Accesorios;

import edu.fiuba.algo3.modelo.Criminales.Hobbies.Hobbies;

public abstract class Accesorios {
    public abstract String valor();

    public  boolean accesoriosEsIgualA(Accesorios accesorios){
        return (accesorios.getClass()==this.getClass());
    }
}
