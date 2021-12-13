package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Criminales.Pelo.Castanio;
import edu.fiuba.algo3.modelo.Criminales.Pelo.Negro;
import edu.fiuba.algo3.modelo.Criminales.Pelo.Rojo;
import edu.fiuba.algo3.modelo.Criminales.Pelo.Rubio;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PeloTest {

    @Test
    public void castanioTest(){
        Castanio castanio = new Castanio();
        assertEquals("Castanio", castanio.valor());
    }

    @Test
    public void negroTest(){
        Negro negro = new Negro();
        assertEquals("Negro", negro.valor());
    }

    @Test
    public void rojoTest(){
        Rojo rojo = new Rojo();
        assertEquals("Rojo", rojo.valor());
    }

    @Test
    public void rubioTest(){
        Rubio rubio = new Rubio();
        assertEquals("Rubio", rubio.valor());
    }
}
