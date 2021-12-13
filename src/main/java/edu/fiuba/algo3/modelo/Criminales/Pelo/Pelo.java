package edu.fiuba.algo3.modelo.Criminales.Pelo;

public interface Pelo {

    static Pelo crear(String colorDePelo){
        if (colorDePelo.equals("Castanio")) return new Castanio();
        if (colorDePelo.equals("Negro")) return new Negro();
        if (colorDePelo.equals("Rojo")) return new Rojo();
        return new Rubio();
    }

    String valor();

    default boolean peloEsIgualA(Pelo pelo){
        return this.valor().equals(pelo.valor());
    }
}
