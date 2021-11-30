package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Personas.Agente;
import edu.fiuba.algo3.modelo.Pistas.pistaDificultad;

import java.util.ArrayList;

public class Partida {
    Agente agente;
    ArrayList<String> pistas;

    public void asignarAgente(Agente agente){
        int arrestos = agente.cantidadArrestos();
        pistaDificultad dificultad = new pistaDificultad();
        pistas = dificultad.obtenerPistasDeDificultad(arrestos);
    }

}
