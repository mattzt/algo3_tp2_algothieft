package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Personas.Agente;
import edu.fiuba.algo3.modelo.Pistas.pistaDificultad;

import java.util.ArrayList;

public class Partida {
    private Agente agente;
    private ArrayList<String> pistas;

    public ArrayList<String> asignarAgente(Agente agente){
        int arrestos = agente.cantidadArrestos();
        pistaDificultad dificultad = new pistaDificultad();
        pistas = dificultad.obtenerPistasDeDificultad(arrestos);
        return pistas;
    }
}
