package edu.fiuba.algo3.modelo.Policia;
import edu.fiuba.algo3.modelo.Ciudades.Ciudad;
import edu.fiuba.algo3.modelo.Edificios.*;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.Pistas.RepositorioPistas;
import edu.fiuba.algo3.modelo.Reloj.SingletonReloj;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PoliciaTest {
     Edificio edifcioMock;
     Pista pistaMock;
     Policia agente;
     SingletonReloj reloj;
     Partida partida;
     RepositorioPistas pistas;

    PoliciaTest() throws IOException {
        edifcioMock = mock(Edificio.class);
        pistaMock = mock(Pista.class);
        agente = new Policia("tobias", new Ciudad());
        partida = new Partida(agente);
        reloj = SingletonReloj.getInstance();
        pistas = partida.obtenerPistas();
    }

    @BeforeEach
    void resetearReloj(){
        reloj.resetear();
    }

    @Test
    void explorarSitio() throws IOException {
        partida = new Partida(agente);
        RepositorioPistas pistas = partida.obtenerPistas();


        when(edifcioMock.visitar(pistas)).thenReturn(pistaMock);
        when(pistaMock.darPista()).thenReturn("hola");
        assertEquals("hola", agente.explorarSitio(edifcioMock, pistas).darPista());
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

        //Reseteo el reloj a 0 para las otras pruebas
        reloj.avanzarReloj(16);
    }

    @Test
    void recibirDanio() {
    }

    @Test
    void visitoEdificioUnaVez(){
        Banco banco = new Banco();

        agente.explorarSitio(banco, pistas);

        assertEquals(1, reloj.darHora());

    }

    @Test
    void visitoEdificiosDosVeces(){
        Banco banco = new Banco();
        Aeropuerto aeropuerto = new Aeropuerto();

        agente.explorarSitio(banco, pistas);
        agente.explorarSitio(aeropuerto, pistas);

        assertEquals(3, reloj.darHora());
    }

    @Test
    void visitoEdificiosTresVeces(){
        Banco banco = new Banco();
        Puerto puerto = new Puerto();
        Bolsa bolsa = new Bolsa();

        agente.explorarSitio(banco, pistas);
        agente.explorarSitio(puerto, pistas);
        agente.explorarSitio(bolsa, pistas);

        assertEquals(6, reloj.darHora());
    }

}