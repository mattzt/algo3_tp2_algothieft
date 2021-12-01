package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Personas.Agente;
import edu.fiuba.algo3.modelo.Pistas.BaseDatosPistas;

public class Partida {
    Agente agente;
    BaseDatosPistas pistas;

    public Partida(Agente agente){
        pistas = new BaseDatosPistas(agente);
    }


}
