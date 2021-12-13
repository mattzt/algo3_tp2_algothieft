package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.modelo.ComputadoraInterpol.ComputadoraInterpol;
import edu.fiuba.algo3.modelo.Criminales.Sospechosos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;


public class ComputadoraInterpolTest {
    ComputadoraInterpol computadora;
    Sospechosos listaDeSospechosos;


    @BeforeEach
    public void setUp(){
        listaDeSospechosos = new Sospechosos();
        computadora = new ComputadoraInterpol(listaDeSospechosos);
    }

    @Test
    public void noSePuedeEmitirOrdenSiNoHaySospechosos(){
        assertFalse(computadora.sePuedeEmitirOrden());
    }

}