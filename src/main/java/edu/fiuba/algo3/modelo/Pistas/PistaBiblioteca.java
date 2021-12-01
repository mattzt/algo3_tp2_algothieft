package edu.fiuba.algo3.modelo.Pistas;

public class PistaBiblioteca implements Pista {

    @Override
    public Pista obtenerPistaBiblioteca(BaseDatosPistas pistas) {
        pista = pistas.buscarPista("|BIBLIOTECA|");
        return this;
    }
}