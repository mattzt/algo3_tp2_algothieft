package edu.fiuba.algo3.modelo.Pistas;

import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Edificios.Puerto;

public class PistaPuerto extends Pista {

    public PistaPuerto(String linea){
        pista = linea.replace("|PUERTO|", "");
    }

    public Boolean esTipo(Edificio edificio){
        return (edificio instanceof Puerto);
    }

}
