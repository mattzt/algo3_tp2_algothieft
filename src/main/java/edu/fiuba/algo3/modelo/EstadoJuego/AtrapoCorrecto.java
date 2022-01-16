package edu.fiuba.algo3.modelo.EstadoJuego;

public class AtrapoCorrecto implements FinDelJuego{

    @Override
    public String mensaje(String criminal) {
        return "Felicitaciones, atrapaste a " + criminal;
    }
}
