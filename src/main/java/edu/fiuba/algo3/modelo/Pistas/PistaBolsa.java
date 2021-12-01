package edu.fiuba.algo3.modelo.Pistas;

public class PistaBolsa implements Pista {

    @Override
    public Pista obtenerPistaBolsa(BaseDatosPistas pistas) {
        pista = pistas.buscarPista("|BOLSA|");
        return this;
    }
}