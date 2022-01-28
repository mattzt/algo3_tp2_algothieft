package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Criminales.Criminal;
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class PartidaTest {
    private final Partida partida;

    public PartidaTest() throws NoExisteError, IOException {
        partida = Partida.getInstance();
    }

    @Test
    public void partidaSeCreaConPolicia(){
        assertNotNull(partida.getPolicia());
    }

    @Test
    public void seInicializaConObjetoRobadoYCriminalNoNulos(){
        assertNotNull(partida.nombreCriminalActual());
        assertNotNull(partida.nombreObjetoRobado());
    }

    @Test
    public void policiaNoArrancaEnElUltimoPais(){
        assertFalse(partida.estaEnUltimoPais());
    }

    @Test
    public void mensajeNoVacioSiAtrapasAlCriminal() throws NoExisteError, IOException {
        String nombre = partida.nombreCriminalActual();
        Criminal criminal = new Criminal(nombre, null);

        partida.evaluarEstado(criminal);

        String mensaje = partida.mensajeFinal();

        assertNotEquals("", mensaje);

        assertTrue(partida.terminoJuego());
    }

}
