package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Personas.Agente;
import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.Pistas.BuscadorPista;

public class Biblioteca implements Edificio{
    private BuscadorPista buscadorPista;
    private int visitasHechas;

    @Override
    public int visitar(Agente agente){
        buscadorPista.darPista(this, agente);
        visitasHechas += 1;

        return visitasHechas;
    }

}
