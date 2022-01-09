package edu.fiuba.algo3.modelo.EstadoJuego;

import edu.fiuba.algo3.modelo.Criminales.Criminal;
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.Policia.Policia;

import java.io.IOException;

public class AtrapoCorrecto implements FinDelJuego{

    @Override
    public String mensaje(String criminal) throws NoExisteError, IOException {
        return "Felicitaciones, atrapaste a " + criminal;

    }
}
