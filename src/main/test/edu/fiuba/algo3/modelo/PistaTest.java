package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Edificios.Banco;
import edu.fiuba.algo3.modelo.Edificios.Biblioteca;
import edu.fiuba.algo3.modelo.Edificios.Edificios;
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
        Edificios edificios = new Edificios();
        edificios.agregar(new Banco());
        edificios.agregar(new Biblioteca());

        rusia.setEdificios(edificios);
        nuevoPoli = new Policia();
        nuevoPoli.setPaisEnDondeEstoy(rusia);
        partida = Partida.getInstance();
    }

    @Test
    public void pidePistaBancariaSeLADa() {
        Assertions.assertTrue(nuevoPoli.seEncuentraEn(rusia));
        Pista unaPista = nuevoPoli.visitarEdificio(new Banco(), partida.obtenerPistas());
        Assertions.assertEquals("Dijo que queria cambiar su dinero por Rublos", (unaPista.darPista()));
        Pista unaPistaNueva = nuevoPoli.visitarEdificio(new Biblioteca(), partida.obtenerPistas());
        Assertions.assertEquals("Dijo que iba a estudiar la historia de sus grandes filosofos", (unaPistaNueva.darPista()));

    }
}
