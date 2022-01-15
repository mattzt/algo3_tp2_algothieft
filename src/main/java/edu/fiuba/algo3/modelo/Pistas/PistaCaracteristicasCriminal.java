package edu.fiuba.algo3.modelo.Pistas;

import edu.fiuba.algo3.modelo.Edificios.Edificio;

public class PistaCaracteristicasCriminal extends Pista{

    public PistaCaracteristicasCriminal(String nuevoPais, String linea){
        pista = linea;
        pais = nuevoPais;
    }

    @Override
    public Boolean esTipo(Edificio edificio) {
        return false;
    }
}
