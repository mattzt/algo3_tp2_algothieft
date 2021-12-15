package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Criminales.Accesorios.Anillo;
import edu.fiuba.algo3.modelo.Criminales.Accesorios.Cicatriz;
import edu.fiuba.algo3.modelo.Criminales.Accesorios.Joyas;
import edu.fiuba.algo3.modelo.Criminales.Accesorios.Tatuaje;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccesoriosTest {

    @Test
    public void anilloTest(){
        Anillo anillo = new Anillo();
        assertTrue(anillo.equals(new Anillo()));
    }

    @Test
    public void cicatrizTest(){
        Cicatriz cicatriz = new Cicatriz();
        assertTrue(cicatriz.equals(new Cicatriz()));
    }

    @Test
    public void joyasTest(){
        Joyas joyas = new Joyas();
        assertTrue(joyas.equals(new Joyas()));
    }

    @Test
    public void tatuajeTest(){
        Tatuaje tatuaje = new Tatuaje();
        assertTrue(tatuaje.equals(new Tatuaje()));
    }
}
