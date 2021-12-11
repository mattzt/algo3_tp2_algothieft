package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.modelo.ComputadoraInterpol.ComputadoraInterpol;
import edu.fiuba.algo3.modelo.Policia.Policia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.mockito.Mockito.*;


public class ComputadoraInterpolTest {
    ComputadoraInterpol computadora;


    @BeforeEach
    public void setUp(){
        computadora = new ComputadoraInterpol();

    }

}