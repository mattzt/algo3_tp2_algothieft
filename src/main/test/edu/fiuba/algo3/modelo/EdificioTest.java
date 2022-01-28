package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Edificios.*;
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Factory.CreadorPistas;
import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.Pistas.RepositorioPistas;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class EdificioTest {

    private final RepositorioPistas repositorioPistas;
    private Edificio aeropuerto;
    private Edificio biblioteca;
    private Edificio banco;
    private Edificio bolsa;
    private Edificio puerto;

    public EdificioTest() throws IOException, NoExisteError {
        aeropuerto = new Aeropuerto();
        biblioteca = new Biblioteca();
        banco = new Banco();
        bolsa = new Bolsa();
        puerto = new Puerto();

        Partida partida = Partida.getInstance();
        repositorioPistas = partida.obtenerPistas();
    }

    @BeforeEach
    public void setUp(){
        aeropuerto = new Aeropuerto();
        biblioteca = new Biblioteca();
        banco = new Banco();
        bolsa = new Bolsa();
        puerto = new Puerto();
    }

    @Test
    public void visitarEdificiosDevuelvenPistasNoNulas(){
        Pista pistaAero = aeropuerto.visitar(repositorioPistas);
        Pista pistaBiblio = biblioteca.visitar(repositorioPistas);
        Pista pistaBanco = banco.visitar(repositorioPistas);
        Pista pistaBolsa = bolsa.visitar(repositorioPistas);
        Pista pistaPuerto = puerto.visitar(repositorioPistas);

        assertNotNull(pistaAero.darPista());
        assertNotNull(pistaBiblio.darPista());
        assertNotNull(pistaBanco.darPista());
        assertNotNull(pistaBolsa.darPista());
        assertNotNull(pistaPuerto.darPista());
    }

    @Test
    public void nombresSonCorrectos(){
        assertEquals("Aeropuerto", aeropuerto.getNombre());
        assertEquals("Biblioteca", biblioteca.getNombre());
        assertEquals("Bolsa", bolsa.getNombre());
        assertEquals("Banco", banco.getNombre());
        assertEquals("Puerto", puerto.getNombre());
    }

    @Test
    public void equalsFunciona(){
        Aeropuerto aero = new Aeropuerto();
        assertTrue(aeropuerto.equals(aero));
        assertTrue(banco.equals(new Banco()));
        assertTrue(biblioteca.equals(new Biblioteca()));
        assertTrue(bolsa.equals(new Bolsa()));
        assertTrue(puerto.equals(new Puerto()));
    }

    @Test
    public void visitarEdificio(){
        Edificios edificios = setUpEdificios();

        Pista pista = edificios.visitarEdificio(new Aeropuerto(), repositorioPistas);

        assertNotNull(pista.darPista());
    }

    @Test
    public void calculaVisitasTotales(){
        Edificios edificios = setUpEdificios();

        edificios.visitarEdificio(new Aeropuerto(), repositorioPistas);
        edificios.visitarEdificio(new Banco(), repositorioPistas);
        edificios.visitarEdificio(new Puerto(), repositorioPistas);

        assertEquals(3, edificios.visitasTotales());
    }

    private Edificios setUpEdificios(){
        Edificios edificios = new Edificios();

        edificios.agregar(aeropuerto);
        edificios.agregar(biblioteca);
        edificios.agregar(bolsa);
        edificios.agregar(banco);
        edificios.agregar(puerto);

        return edificios;
    }
}
