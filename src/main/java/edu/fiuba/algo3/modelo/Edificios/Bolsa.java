package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Personas.Agente;
import edu.fiuba.algo3.modelo.Pistas.Pista;

public class Bolsa implements Edificio{
    private Pista pista;
    private int visitasHechas = 0;

    @Override
    public int visitar(Agente agente){
        pista.darPista(this, agente);
        visitasHechas += 1;

        return visitasHechas;
    }

}
