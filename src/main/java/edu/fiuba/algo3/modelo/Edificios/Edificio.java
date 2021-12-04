package edu.fiuba.algo3.modelo.Edificios;
import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.Pistas.Pistas;

import java.util.ArrayList;

public interface Edificio {

    Pista visitar(Pistas pistas);
}
