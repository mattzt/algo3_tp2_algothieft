package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.modelo.IntervaloTiempo.*;
import edu.fiuba.algo3.modelo.Reloj.Lunes;
import edu.fiuba.algo3.modelo.Reloj.Martes;
import edu.fiuba.algo3.modelo.Reloj.Reloj;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RelojTest {
    Reloj reloj;

    @BeforeEach
    public void setUp(){
        reloj = new Reloj();
    }

    @Test
    public void seCreaRelojCorrectamenteInicializado() {
        assertEquals(7, reloj.verHora());
        Assertions.assertTrue(reloj.verDia().equals(new Lunes()));
    }

    @Test
    public void relojAvanzaCorrectamenteDuemiendo() {
        reloj.avanzarReloj(new IntervaloTiempoViajeaPais(75,1800));
        reloj.avanzarReloj(new IntervaloTiempoDormir());
        Assertions.assertTrue(reloj.verDia().equals(new Martes()));
        assertEquals(7, reloj.verHora());
    }

    @Test
    public void relojAvanzaCorrectamenteEmitiendoOrden() {
        reloj.avanzarReloj(new IntervaloTiempoEmitirArresto());
        Assertions.assertTrue(reloj.verDia().equals(new Lunes()));
        assertEquals(10, reloj.verHora());
    }

    @Test
    public void tiempoHerido() {
        reloj.avanzarReloj(new IntervaloHeridaArmaDeFuego());
        Assertions.assertTrue(reloj.verDia().equals(new Lunes()));

    }

    @Test
    public void viajeAPais() {
        reloj.avanzarReloj(new IntervaloTiempoViajeaPais(900, 1800));
        Assertions.assertTrue(reloj.verDia().equals(new Lunes()));
        assertEquals(9, reloj.verHora());
    }

}