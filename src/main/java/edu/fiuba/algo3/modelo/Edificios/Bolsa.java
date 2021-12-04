package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.Pistas.Pistas;


public class Bolsa implements Edificio{

    @Override
    public Pista visitar(Pistas pistas) {
        return pistas.obtenerPistaPara(this);
    }
}
