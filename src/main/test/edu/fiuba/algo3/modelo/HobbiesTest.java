package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Criminales.Hobbies.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HobbiesTest {

    @Test
    public void alpinismoTest(){
        Alpinismo alpinismo = new Alpinismo();
        assertTrue(alpinismo.equals(new Alpinismo()));
    }

    @Test
    public void croquetTest(){
        Croquet croquet = new Croquet();
        assertTrue(croquet.equals(new Croquet()));
    }

    @Test
    public void musicaTest(){
        Musica musica = new Musica();
        assertTrue(musica.equals(new Musica()));
    }

    @Test
    public void natacionTest(){
        Natacion natacion = new Natacion();
        assertTrue(natacion.equals(new Natacion()));
    }

    @Test
    public void paracaidismoTest(){
        Paracaidismo paracaidismo = new Paracaidismo();
        assertTrue(paracaidismo.equals(new Paracaidismo()));
    }

    @Test
    public void tenisTest(){
        Tenis tenis = new Tenis();
        assertTrue(tenis.equals(new Alpinismo()));
    }
}
