package edu.fiuba.algo3.modelo.EstadoJuego;

public class SinTiempo implements FinDelJuego{

    @Override
    public String mensaje(String criminal) {
        return "Te quedaste sin tiempo!!";
    }
}
