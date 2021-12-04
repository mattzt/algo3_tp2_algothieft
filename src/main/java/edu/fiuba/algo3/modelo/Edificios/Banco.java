package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.Pistas.RepositorioPistas;


public class Banco implements Edificio{

    @Override
    public Pista visitar(RepositorioPistas pistas) {
        return pistas.obtenerPistaPara(this);
    }
}
