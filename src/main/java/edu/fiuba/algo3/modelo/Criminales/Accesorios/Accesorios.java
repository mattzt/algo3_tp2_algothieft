package edu.fiuba.algo3.modelo.Criminales.Accesorios;

public interface Accesorios {

    static Accesorios crear(String tipoAcesorio){
        if (tipoAcesorio.equals("Anillo")) return new Anillo();
        if (tipoAcesorio.equals("Cicatriz")) return new Cicatriz();
        if (tipoAcesorio.equals("Joyas")) return new Joyas();
        return new Tatuaje();
    }

    String valor();

    default boolean accesoriosEsIgualA(Accesorios accesorios){
        return this.valor().equals(accesorios.valor());
    }
}
