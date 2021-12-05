package edu.fiuba.algo3.modelo.Pistas;

import edu.fiuba.algo3.modelo.Edificios.*;
import edu.fiuba.algo3.modelo.Edificios.Edificio;

public class PistaAeropuerto extends Pista {

    public PistaAeropuerto(String linea){
        pista = linea.replace("|AEROPUERTO|", "");
    }

    public Boolean esTipo(Edificio edificio){
        return (edificio instanceof Aeropuerto);
    }

}
