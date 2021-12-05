package edu.fiuba.algo3.modelo.Pistas;

import edu.fiuba.algo3.modelo.Edificios.*;



public class PistaBanco extends Pista {

    public PistaBanco(String linea){
        pista = linea.replace("|BANCO|", "");
    }

    public Boolean esTipo(Edificio edificio){
        return (edificio instanceof Banco);
    }
}
