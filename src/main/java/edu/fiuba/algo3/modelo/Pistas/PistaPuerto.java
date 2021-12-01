package edu.fiuba.algo3.modelo.Pistas;

public class PistaPuerto implements Pista {

    @Override
    public Pista obtenerPistaPuerto(BaseDatosPistas pistas) {
        pista = pistas.buscarPista("|PUERTO|");
        return this;
    }
}
