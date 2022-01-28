package edu.fiuba.algo3.modelo.EstadoJuego;

import edu.fiuba.algo3.Interfaz.Controller.SonidosHandler;

public class SinTiempo implements FinDelJuego{

    @Override
    public String mensaje(String criminal) {
        try {SonidosHandler.sonidoDerrota();} catch ( Exception ignored){ }
        return "Te quedaste sin tiempo!!";
    }
}
