package edu.fiuba.algo3.modelo.Pistas;

import edu.fiuba.algo3.modelo.Edificios.Biblioteca;
import edu.fiuba.algo3.modelo.Edificios.Edificio;

public class PistaBiblioteca extends Pista {

    public PistaBiblioteca(String nuevoPais, String linea){
        pista = linea;
        pais = nuevoPais;
    }
    public Boolean esTipo(Edificio edificio){
        return (edificio instanceof Biblioteca);
    }
}