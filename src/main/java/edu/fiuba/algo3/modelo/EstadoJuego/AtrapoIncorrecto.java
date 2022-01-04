package edu.fiuba.algo3.modelo.EstadoJuego;

import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Partida;

import java.io.IOException;

public class AtrapoIncorrecto implements FinDelJuego{

    @Override
    public String mensaje(String criminal) throws NoExisteError, IOException {
        return "Atrapaste al que no era! El criminal era " + criminal;
    }
}
