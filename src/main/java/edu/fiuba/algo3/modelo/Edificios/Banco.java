package edu.fiuba.algo3.modelo.Edificios;

public class Banco implements Edificio{
    buscadorPista pistasBanco;
    int visitasHechas;

    @Override
    public int visitar() {
        pistasBanco.darUnaPista();
        visitasHechas += 1;
        return visitasHechas;
    }
}
