package edu.fiuba.algo3.modelo.Pistas;

import edu.fiuba.algo3.modelo.Edificios.Edificio;

import java.util.ArrayList;

public interface RangoPista {
    ArrayList<String> pistas = new ArrayList<>();

    public String obtenerPistaEdificio(Edificio edificio);
}
