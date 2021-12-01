package edu.fiuba.algo3.modelo.Pistas;

public class PistaAeropuerto implements Pista {

    @Override
    public Pista obtenerPistaAeropuerto(BaseDatosPistas pistas) {
        pista = pistas.buscarPista("|AEROPUERTO|");
        return this;
    }
}
