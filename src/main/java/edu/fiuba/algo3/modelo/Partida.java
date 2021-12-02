package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Personas.Agente;
import edu.fiuba.algo3.modelo.Pistas.Pistas;

public class Partida {
    Agente agente;
    Pistas pistas;

    public Partida(Agente agente){
        pistas = new Pistas(agente);
    }


}
