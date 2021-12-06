package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Ciudades.Ciudad;
import edu.fiuba.algo3.modelo.Edificios.*;
import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.Pistas.RepositorioPistas;
import edu.fiuba.algo3.modelo.Policia.Policia;
import edu.fiuba.algo3.modelo.Reloj.SingletonReloj;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PoliciaTest {
     Policia agente;
     SingletonReloj reloj;
     Partida partida;
     RepositorioPistas pistas;


     @BeforeEach
     void setUp() throws IOException {
         agente = new Policia("tobias", new Ciudad());
         partida = new Partida(agente);
         reloj = SingletonReloj.getInstance();

         reloj.resetear();
         pistas = partida.obtenerPistas();
     }

    @Test
    void explorarSitio() throws IOException {
        partida = new Partida(agente);
        RepositorioPistas pistas = partida.obtenerPistas();
        Banco banco = new Banco();

        Pista pista = agente.explorarSitio(banco, pistas);

        assertEquals(pista.darPista(), "Dijo que queria cambiar su dinero por Rublos");
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