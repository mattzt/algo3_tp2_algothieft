package edu.fiuba.algo3.modelo.Pistas;

import edu.fiuba.algo3.modelo.Edificios.Bolsa;
import edu.fiuba.algo3.modelo.Edificios.Edificio;

public class PistaBolsa extends Pista {

    public PistaBolsa(String nuevoPais, String linea){
        pista = linea;
        pais = nuevoPais;
    }
    public Boolean esTipo(Edificio edificio){
        return (edificio instanceof Bolsa);
    }

}