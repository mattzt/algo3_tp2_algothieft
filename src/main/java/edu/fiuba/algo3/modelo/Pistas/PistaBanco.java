package edu.fiuba.algo3.modelo.Pistas;

import edu.fiuba.algo3.modelo.Edificios.Edificio;

public class PistaBanco implements Pista {

    @Override
    public Pista obtenerPistaBanco(BaseDatosPistas pistas) {
        pista = pistas.buscarPista("|BANCO|");
        return this;
    }
}
