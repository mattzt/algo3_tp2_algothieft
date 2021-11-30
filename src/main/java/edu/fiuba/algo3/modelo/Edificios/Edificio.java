package edu.fiuba.algo3.modelo.Edificios;
import edu.fiuba.algo3.modelo.Personas.Agente;
import edu.fiuba.algo3.modelo.Pistas.Pista;

import java.util.ArrayList;

public interface Edificio {

    Pista visitar(ArrayList<String> pistas);
}
