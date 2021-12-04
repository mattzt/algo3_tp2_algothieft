package edu.fiuba.algo3.modelo.Policia;
import edu.fiuba.algo3.modelo.Ciudades.Ciudad;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.Pistas.RepositorioPistas;
import edu.fiuba.algo3.modelo.Reloj.SingletonReloj;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class PoliciaTest {
     Edificio EdifcioMock = Mockito.mock(Edificio.class);
     Pista pistaMock = Mockito.mock(Pista.class);
     Policia agente = new Policia("tobias", new Ciudad());
     SingletonReloj reloj = SingletonReloj.getInstance();
     Partida partida;

    @Test
    void explorarSitio() throws IOException {
        partida = new Partida(agente);
        RepositorioPistas pistas = partida.obtenerPistas();

        when(EdifcioMock.visitar(pistas)).thenReturn(pistaMock);
        when(pistaMock.darPista()).thenReturn("hola");
        assertEquals("hola", agente.explorarSitio(EdifcioMock, pistas).darPista());
    }

    @Test
    void viajarApais() {
    }

    @Test
    void computarDatosLadron() {
    }

    @Test
    void dormir() {
        //Al inicio la hora deberia ser las 00.
        assertEquals(reloj.darHora(), 0);
        agente.dormir();
        assertEquals(reloj.darHora(), 8);
    }

    @Test
    void recibirDanio() {
    }
}