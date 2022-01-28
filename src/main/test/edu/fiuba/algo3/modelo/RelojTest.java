package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.modelo.IntervaloTiempo.*;
import edu.fiuba.algo3.modelo.Reloj.*;
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

    @Test
    public void visitaAEdificio1vez(){
        reloj.avanzarReloj(new IntervaloTiempoExplorarEdificio(0));
        assertEquals(reloj.verHora(), 8);
    }

    @Test
    public void visitaEdificioPor2daVez(){
        reloj.avanzarReloj(new IntervaloTiempoExplorarEdificio(1));
        assertEquals(reloj.verHora(), 9);
    }

    @Test
    public void visitaEdificioPor3eraVez(){
        reloj.avanzarReloj(new IntervaloTiempoExplorarEdificio(2));
        assertEquals(reloj.verHora(), 10);
    }

    @Test
    public void diasPasanCorrectamente(){
        assertTrue(reloj.verDia().equals(new Lunes()));

        avanzarDia();
        assertTrue(reloj.verDia().equals(new Martes()));

        avanzarDia();
        assertTrue(reloj.verDia().equals(new Miercoles()));

        avanzarDia();
        assertTrue(reloj.verDia().equals(new Jueves()));

        avanzarDia();
        assertTrue(reloj.verDia().equals(new Viernes()));

        avanzarDia();
        assertTrue(reloj.verDia().equals(new Sabado()));

        avanzarDia();
        assertTrue(reloj.verDia().equals(new Domingo()));

        avanzarDia();
        assertTrue(reloj.verDia().equals(new Lunes()));
    }

    private void avanzarDia(){
        reloj.avanzarReloj(new IntervaloHeridaArmaDeFuego());
        reloj.avanzarReloj(new IntervaloHeridaArmaDeFuego());
        reloj.avanzarReloj(new IntervaloHeridaArmaDeFuego());
        reloj.avanzarReloj(new IntervaloHeridaArmaDeFuego());
        reloj.avanzarReloj(new IntervaloHeridaArmaDeFuego());
        reloj.avanzarReloj(new IntervaloHeridaArmaDeFuego());
    }

    @Test
    public void seReseteaCorrectamente(){
        reloj.avanzarReloj(new IntervaloHeridaArmaDeFuego());

        assertEquals(reloj.verHora(), 11);
        assertTrue(reloj.verDia().equals(new Lunes()));

        reloj.reset();

        assertEquals(reloj.verHora(), 7);
        assertTrue(reloj.verDia().equals(new Lunes()));    }

}