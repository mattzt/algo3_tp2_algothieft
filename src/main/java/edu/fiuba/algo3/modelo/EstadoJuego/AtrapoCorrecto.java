package edu.fiuba.algo3.modelo.EstadoJuego;

import edu.fiuba.algo3.Interfaz.Controller.SonidosHandler;

public class AtrapoCorrecto implements FinDelJuego{

    @Override
    public String mensaje(String criminal) {
        try {SonidosHandler.sonidoVictoria();} catch ( Exception ignored){ }
        return "Felicitaciones, atrapaste a " + criminal;
    }
}
