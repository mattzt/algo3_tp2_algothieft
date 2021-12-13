package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.modelo.ComputadoraInterpol.ComputadoraInterpol;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;


public class ComputadoraInterpolTest {
    ComputadoraInterpol computadora;

    @BeforeEach
    public void setUp(){
        computadora = new ComputadoraInterpol();
    }

    @Test
    public void noSePuedeEmitirOrdenSiNoHaySospechosos(){
        assertFalse(computadora.sePuedeEmitirOrden());
    }

}