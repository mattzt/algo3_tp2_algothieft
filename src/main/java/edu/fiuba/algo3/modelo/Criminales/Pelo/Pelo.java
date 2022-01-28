package edu.fiuba.algo3.modelo.Criminales.Pelo;

import edu.fiuba.algo3.modelo.Criminales.Caracteristica;

public interface Pelo extends Caracteristica {

    static Pelo crear(String colorDePelo){
        if (colorDePelo.equals("Castanio")) return new Castanio();
        if (colorDePelo.equals("Negro")) return new Negro();
        if (colorDePelo.equals("Rojo")) return new Rojo();
        return new Rubio();
    }
}
