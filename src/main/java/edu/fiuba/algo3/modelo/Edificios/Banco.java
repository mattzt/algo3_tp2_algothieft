package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Pistas.Pistas;
import edu.fiuba.algo3.modelo.Pistas.Pista;


public class Banco implements Edificio{

    @Override
    public Pista visitar(Pistas pistas) {
        return pistas.obtenerPistaPara(this);
    }
}
