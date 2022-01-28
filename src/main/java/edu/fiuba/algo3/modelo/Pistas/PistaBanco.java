package edu.fiuba.algo3.modelo.Pistas;

import edu.fiuba.algo3.modelo.Edificios.Banco;
import edu.fiuba.algo3.modelo.Edificios.Edificio;

public class PistaBanco extends Pista {

    public PistaBanco(String nuevoPais, String linea){
        pista = linea;
        pais = nuevoPais;
    }
    public Boolean esTipo(Edificio edificio){
        return (edificio instanceof Banco);
    }
}
