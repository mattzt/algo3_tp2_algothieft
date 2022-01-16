package edu.fiuba.algo3.modelo.EstadoJuego;

public class AtrapoIncorrecto implements FinDelJuego{

    @Override
    public String mensaje(String criminal) {
        return "Atrapaste al que no era! El criminal era " + criminal;
    }
}
