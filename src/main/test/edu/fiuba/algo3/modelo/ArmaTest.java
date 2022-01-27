package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Arma.Arma;
import edu.fiuba.algo3.modelo.Arma.ArmaBlanca;
import edu.fiuba.algo3.modelo.Arma.ArmaDeFuego;
import edu.fiuba.algo3.modelo.Policia.Policia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArmaTest {

    private Policia policia;

    @BeforeEach
    public void setUp(){
        policia = new Policia();
    }

    @Test
    public void ataqueUnaVezArmaBlanca(){
        Arma arma = new ArmaBlanca();

        assertEquals(policia.mirarLaHora(), 7);

        policia.recibirDanio(arma);

        assertEquals(policia.mirarLaHora(), 9);
    }

    @Test
    public void ataqueDosVecesArmaBlanca(){
        Arma arma = new ArmaBlanca();

        assertEquals(policia.mirarLaHora(), 7);

        policia.recibirDanio(arma);
        policia.recibirDanio(arma);

        assertEquals(policia.mirarLaHora(), 10);
    }

    @Test
    public void ataqueArmaDeFuego(){
        Arma arma = new ArmaDeFuego();

        assertEquals(policia.mirarLaHora(), 7);

        policia.recibirDanio(arma);

        assertEquals(policia.mirarLaHora(), 11);
    }
}
