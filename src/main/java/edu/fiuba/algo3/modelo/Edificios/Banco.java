package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Pistas.Pistas;

public class Banco implements Edificio{
    Pistas pistasBanco;
    int visitasHechas;

    @Override
    public int visitar() {
        pistasBanco.darUnaPista();
        visitasHechas += 1;
        return visitasHechas;
    }
}
