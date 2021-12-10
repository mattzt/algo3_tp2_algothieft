package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.modelo.ComputadoraInterpol.ComputadoraInterpol;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ComputadoraInterpolTest {
    ComputadoraInterpol computadora;

    @BeforeEach
    public void setUp(){
        computadora = new ComputadoraInterpol();
    }

    @Test
    public void computadoraTomaDatos(){
        computadora.ingresarDatos();
    }
}