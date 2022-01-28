package edu.fiuba.algo3.modelo.EstadoJuego;

import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;

import java.io.IOException;

public interface FinDelJuego {
    String mensaje(String criminal) throws NoExisteError, IOException;
}
