package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Hobbies.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HobbiesTest {

    @Test
    public void alpinismoTest(){
        Alpinismo alpinismo = new Alpinismo();
        assertEquals("Alpinismo", alpinismo.valor());
    }

    @Test
    public void croquetTest(){
        Croquet croquet = new Croquet();
        assertEquals("Croquet", croquet.valor());
    }

    @Test
    public void musicaTest(){
        Musica musica = new Musica();
        assertEquals("Musica", musica.valor());
    }

    @Test
    public void natacionTest(){
        Natacion natacion = new Natacion();
        assertEquals("Natacion", natacion.valor());
    }

    @Test
    public void paracaidismoTest(){
        Paracaidismo paracaidismo = new Paracaidismo();
        assertEquals("Paracaidismo", paracaidismo.valor());
    }

    @Test
    public void tenisTest(){
        Tenis tenis = new Tenis();
        assertEquals("Tenis", tenis.valor());
    }
}
