package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Criminales.Hobbies.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
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
        assertTrue(tenis.equals(new Tenis()));
    }

    @Test
    public void pistasSeCreanNoNulas(){
        Alpinismo alpinismo = new Alpinismo();
        Croquet croquet = new Croquet();
        Musica musica = new Musica();
        Natacion natacion = new Natacion();
        Paracaidismo paracaidismo = new Paracaidismo();
        Tenis tenis = new Tenis();

        assertNotNull(alpinismo.crearPista());
        assertNotNull(croquet.crearPista());
        assertNotNull(musica.crearPista());
        assertNotNull(natacion.crearPista());
        assertNotNull(paracaidismo.crearPista());
        assertNotNull(tenis.crearPista());
    }
}
