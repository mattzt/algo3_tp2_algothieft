package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Accesorios.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccesoriosTest {

    @Test
    public void anilloTest(){
        Anillo anillo = new Anillo();
        assertEquals("Anillo", anillo.valor());
    }

    @Test
    public void cicatrizTest(){
        Cicatriz cicatriz = new Cicatriz();
        assertEquals("Cicatriz", cicatriz.valor());
    }

    @Test
    public void joyasTest(){
        Joyas joyas = new Joyas();
        assertEquals("Joyas", joyas.valor());
    }

    @Test
    public void tatuajeTest(){
        Tatuaje tatuaje = new Tatuaje();
        assertEquals("Tatuaje", tatuaje.valor());
    }

}
