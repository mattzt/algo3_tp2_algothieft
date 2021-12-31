package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PartidaTest {
    Partida partida;

    @BeforeEach
    public void setUp() throws NoExisteError, IOException {
        partida = Partida.getInstance();
    }

    @Test
    public void partidaNoTerminoSiNoPasoNada() {
        assertFalse(partida.terminoJuego());
    }

    @Test
    public void partidaDevuelveLoQueDeberia(){
        assertNotNull(partida.getPolicia());
        assertNotNull(partida.getCriminalActual());
        assertNotNull(partida.obtenerPistas());
    }
}
