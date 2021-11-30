package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.Pistas.Pistas;

public class Banco implements Edificio{
    Pistas pistasBanco;
    int visitasHechas;

    @Override
    public Pista visitar() {
        visitasHechas += 1;
        return pistasBanco.darUnaPista();
    }
}
