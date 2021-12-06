package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Paises.Pais;
import edu.fiuba.algo3.modelo.Edificios.*;
import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.Pistas.RepositorioPistas;
import edu.fiuba.algo3.modelo.Policia.Policia;
import edu.fiuba.algo3.modelo.Reloj.SingletonReloj;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PoliciaTest {
     private Policia agente;
     private SingletonReloj reloj;
     private Partida partida;
     private RepositorioPistas pistas;


     @BeforeEach
     public void setUp() throws IOException {
         agente = new Policia("tobias", new Pais("Argentina","Buenos Aires"));
         partida = new Partida(agente);
         reloj = SingletonReloj.getInstance();

         reloj.resetear();
         pistas = partida.obtenerPistas();
     }

    @Test
    public void explorarSitio(){
        Banco banco = new Banco();

        Pista pista = agente.explorarSitio(banco, pistas);

        assertEquals(pista.darPista(), "Dijo que queria cambiar su dinero por Rublos");
    }

    @Test
    public void viajarApais() {
    }

    @Test
    public void computarDatosLadron() {
    }

    @Test
    public void dormir() {
        //Al inicio la hora deberia ser las 00.
        assertEquals(reloj.darHora(), 0);
        agente.dormir();
        assertEquals(reloj.darHora(), 8);

    }

    @Test
    public void recibirDanio() {
    }

    @Test
    public void visitoEdificioUnaVez(){
        Banco banco = new Banco();

        agente.explorarSitio(banco, pistas);

        assertEquals(1, reloj.darHora());

    }

    @Test
    public void visitoEdificiosDosVeces(){
        Banco banco = new Banco();
        Aeropuerto aeropuerto = new Aeropuerto();

        agente.explorarSitio(banco, pistas);
        agente.explorarSitio(aeropuerto, pistas);

        assertEquals(3, reloj.darHora());
    }

    @Test
    public void visitoEdificiosTresVeces(){
        Banco banco = new Banco();
        Puerto puerto = new Puerto();
        Bolsa bolsa = new Bolsa();

        agente.explorarSitio(banco, pistas);
        agente.explorarSitio(puerto, pistas);
        agente.explorarSitio(bolsa, pistas);

        assertEquals(6, reloj.darHora());
    }

}