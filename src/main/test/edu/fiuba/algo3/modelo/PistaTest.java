package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Edificios.Banco;
import edu.fiuba.algo3.modelo.Edificios.Biblioteca;
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Mapa.Paises.Pais;
import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.Policia.Policia;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class PistaTest {

    Policia nuevoPoli;
    Partida partida;
    Pais rusia;


    @BeforeEach
    public void setUp() throws NoExisteError, IOException {
        rusia = new Pais("Rusia", "Moscu");
        nuevoPoli = new Policia();
        partida = Partida.getInstance();
    }

    @Test
    public void pidePistaBancariaSeLADa() {
        Assertions.assertTrue(nuevoPoli.seEncuentraEn(rusia));
        Pista unaPista = nuevoPoli.explorarSitio(new Banco(), partida.obtenerPistas());
        Assertions.assertEquals("Dijo que queria cambiar su dinero por Rublos", (unaPista.darPista()));
        Pista unaPistaNueva = nuevoPoli.explorarSitio(new Biblioteca(), partida.obtenerPistas());
        Assertions.assertEquals("Dijo que iba a estudiar la historia de sus grandes filosofos", (unaPistaNueva.darPista()));

    }
}
