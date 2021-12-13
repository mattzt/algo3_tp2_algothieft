package edu.fiuba.algo3.modelo.Criminales;

import edu.fiuba.algo3.modelo.Criminales.Sexo.Sexo;

import java.util.ArrayList;

public class Criminal {
    Caracteristicas caracteristicas;

    public Criminal(Caracteristicas nuevasCaracteristicas){
        caracteristicas = nuevasCaracteristicas;
    }


    public boolean tieneCaracteristica(Caracteristicas buscada){
        return caracteristicas.tieneCaracteristicasIguales(buscada);
    }
}
