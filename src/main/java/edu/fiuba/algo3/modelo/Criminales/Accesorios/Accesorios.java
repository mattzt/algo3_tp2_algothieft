package edu.fiuba.algo3.modelo.Criminales.Accesorios;

import edu.fiuba.algo3.modelo.Criminales.Caracteristica;

public interface Accesorios extends Caracteristica {

    static Accesorios crear(String tipoAcesorio){
        if (tipoAcesorio.equals("Anillo")) return new Anillo();
        if (tipoAcesorio.equals("Cicatriz")) return new Cicatriz();
        if (tipoAcesorio.equals("Joyas")) return new Joyas();
        return new Tatuaje();
    }

}
