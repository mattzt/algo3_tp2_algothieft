package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Criminales.Pelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PeloTest {

    @Test
    public void castanioTest(){
        Castanio castanio = new Castanio();
        assertTrue(castanio.equals(new Castanio()));
    }

    @Test
    public void negroTest(){
        Negro negro = new Negro();
        assertTrue(negro.equals(new Negro()));
    }

    @Test
    public void rojoTest(){
        Rojo rojo = new Rojo();
        assertTrue(rojo.equals(new Rojo()));
    }

    @Test
    public void rubioTest(){
        Rubio rubio = new Rubio();
        assertTrue(rubio.equals(new Rubio()));
    }

    @Test
    public void pistasNoSonNulas(){
        Castanio castanio = new Castanio();
        Negro negro = new Negro();
        Rojo rojo = new Rojo();
        Rubio rubio = new Rubio();

        assertNotNull(castanio.crearPista());
        assertNotNull(negro.crearPista());
        assertNotNull(rojo.crearPista());
        assertNotNull(rubio.crearPista());
    }
}
