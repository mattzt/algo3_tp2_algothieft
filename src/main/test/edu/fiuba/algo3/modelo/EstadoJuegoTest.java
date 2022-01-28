package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.EstadoJuego.AtrapoCorrecto;
import edu.fiuba.algo3.modelo.EstadoJuego.AtrapoIncorrecto;
import edu.fiuba.algo3.modelo.EstadoJuego.FinDelJuego;
import edu.fiuba.algo3.modelo.EstadoJuego.SinTiempo;
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EstadoJuegoTest {

    @Test
    public void mensajeEsCorrecto() throws NoExisteError, IOException {
        FinDelJuego estado = new AtrapoCorrecto();
        FinDelJuego incorrecto = new AtrapoIncorrecto();
        FinDelJuego sinTiempo = new SinTiempo();

        assertEquals("Felicitaciones, atrapaste a Pepe", estado.mensaje("Pepe"));
        assertEquals("Atrapaste al que no era! El criminal era Pepe", incorrecto.mensaje("Pepe"));
        assertEquals("Te quedaste sin tiempo!!", sinTiempo.mensaje(null));
    }
}
