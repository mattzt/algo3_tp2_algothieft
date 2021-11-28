package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Pistas.Pista;

public class Banco implements Edificio{
    Pista pistasBanco;
    int visitasHechas;

    @Override
    public int visitar() {
        pistasBanco.darUnaPista();
        visitasHechas += 1;
        return visitasHechas;
    }
}
