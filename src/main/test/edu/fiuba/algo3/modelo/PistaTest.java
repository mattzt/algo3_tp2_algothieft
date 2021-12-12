package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Edificios.Banco;
import edu.fiuba.algo3.modelo.Edificios.Biblioteca;
import edu.fiuba.algo3.modelo.Fachada.Fachada;
import edu.fiuba.algo3.modelo.Paises.Pais;
import edu.fiuba.algo3.modelo.Paises.PaisNoExisteError;
import edu.fiuba.algo3.modelo.Paises.Paises;
import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.Policia.Policia;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class PistaTest {

    Policia nuevoPoli;
    Partida partida;


    @BeforeEach
    public void setUp() throws PaisNoExisteError, IOException {
        Pais canada = new Pais("Rusia", "Moscu");
        nuevoPoli = new Policia("Carlos",canada);
        partida = new Partida(nuevoPoli);
    }

    @Test
    public void pidePistaBancariaSeLADa() throws PaisNoExisteError {
        Assertions.assertTrue(nuevoPoli.seEncuentraEn("Moscu"));
        Pista unaPista = nuevoPoli.explorarSitio(new Banco(), partida.obtenerPistas());
        Assertions.assertTrue((unaPista.darPista()).equals("Dijo que queria cambiar su dinero por Rublos"));
        Pista unaPistaNueva = nuevoPoli.explorarSitio(new Biblioteca(), partida.obtenerPistas());
        Assertions.assertTrue((unaPistaNueva.darPista()).equals("Dijo que iba a estudiar la historia de sus grandes filosofos"));

    }
}
