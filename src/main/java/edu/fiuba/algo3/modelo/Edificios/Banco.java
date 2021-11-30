package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Personas.Agente;
import edu.fiuba.algo3.modelo.Pistas.BuscadorPista;
import edu.fiuba.algo3.modelo.Pistas.Pista;

public class Banco implements Edificio{
    Pista pista;
    int visitasHechas;

    public Banco(){
        pista = new Pista();
        visitasHechas = 0;
    }

    @Override
    public int visitar(Agente agente) {
        pistas.darUnaPista();
        visitasHechas += 1;
        return visitasHechas;
    }
}
