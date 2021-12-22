package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.modelo.ComputadoraInterpol.ComputadoraInterpol;
import edu.fiuba.algo3.modelo.Criminales.Accesorios.Joyas;
import edu.fiuba.algo3.modelo.Criminales.Hobbies.Tenis;
import edu.fiuba.algo3.modelo.Criminales.Pelo.Castanio;
import edu.fiuba.algo3.modelo.Criminales.Sexo.*;
import edu.fiuba.algo3.modelo.Criminales.Sospechosos;
import edu.fiuba.algo3.modelo.Factory.CreadorCriminales;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class ComputadoraInterpolTest {
    private ComputadoraInterpol computadora;
    private Sospechosos listaDeSospechosos;


    @BeforeEach
    public void setUp() throws IOException {
        CreadorCriminales constructorSospechosos = new CreadorCriminales();
        listaDeSospechosos = constructorSospechosos.crear("src/main/java/edu/fiuba/algo3/modelo/Resources/sospechosos.txt");
        computadora = new ComputadoraInterpol(listaDeSospechosos);
    }

    @Test
    public void noSePuedeEmitirOrdenSiNoHaySospechosos(){
        computadora.ingresarCaracteristica(new SexoFemenino());
        computadora.ingresarCaracteristica(new SexoMasculino());
        assertFalse(computadora.sePuedeEmitirOrden());
    }

    @Test
    public void sePuedeResetearLista(){
        computadora.ingresarCaracteristica(new SexoMasculino());

        assertEquals(listaDeSospechosos.size(), 5);

        computadora.resetearSospechosos();

        computadora.ingresarCaracteristica(new SexoFemenino());

        assertEquals(listaDeSospechosos.size(), 5);
    }

    @Test
    public void filtraCorrectamente(){
        computadora.ingresarCaracteristica(new SexoFemenino());
        computadora.ingresarCaracteristica(new Joyas());
        computadora.ingresarCaracteristica(new Castanio());

        assertEquals(2, listaDeSospechosos.size());

        computadora.ingresarCaracteristica(new Tenis());

        assertEquals(1, listaDeSospechosos.size());
    }
}