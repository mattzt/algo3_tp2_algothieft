package edu.fiuba.algo3.modelo.Pistas;

import edu.fiuba.algo3.modelo.Edificios.Aeropuerto;
import edu.fiuba.algo3.modelo.Edificios.Edificio;

public class PistaAeropuerto extends Pista {

    public PistaAeropuerto(String nuevoPais, String linea){
        pista = linea;
        pais = nuevoPais;
    }

    public Boolean esTipo(Edificio edificio){
        return (edificio instanceof Aeropuerto);
    }

}
