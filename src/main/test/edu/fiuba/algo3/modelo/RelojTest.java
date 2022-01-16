package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Edificios.Puerto;
import edu.fiuba.algo3.modelo.IntervaloTiempo.*;
import edu.fiuba.algo3.modelo.Reloj.Reloj;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RelojTest {
    Reloj reloj = new Reloj();
    @Test
    public void seCreaRelojCorrectamenteInicializado() {
        Assertions.assertTrue(reloj.equals("Lunes",0));
    }

    @Test
    public void relojAvanzaCorrectamenteExplorarEdificioPrimeraVez() {
        IntervaloTiempoExplorarEdificio intervalo = new IntervaloTiempoExplorarEdificio(1);
        reloj.avanzarReloj(intervalo);
        Assertions.assertTrue(reloj.equals("Lunes",1));
    }

    @Test
    public void relojAvanzaCorrectamenteExplorarEdificioSegundaVez() {
        IntervaloTiempoExplorarEdificio intervalo = new IntervaloTiempoExplorarEdificio(2);
        reloj.avanzarReloj(intervalo);
        Assertions.assertTrue(reloj.equals("Lunes",2));
    }
    @Test
    public void relojAvanzaCorrectamenteExplorarEdificioTerceraVez() {
        IntervaloTiempoExplorarEdificio intervalo = new IntervaloTiempoExplorarEdificio(3);
        reloj.avanzarReloj(intervalo);
        Assertions.assertTrue(reloj.equals("Lunes",3));
    }
    @Test
    public void relojAvanzaCorrectamenteExplorarEdificioMasDeTres() {
        IntervaloTiempoExplorarEdificio intervalo = new IntervaloTiempoExplorarEdificio(1);
        reloj.avanzarReloj(intervalo);
        intervalo = new IntervaloTiempoExplorarEdificio(2);
        reloj.avanzarReloj(intervalo);
        intervalo = new IntervaloTiempoExplorarEdificio(3);
        reloj.avanzarReloj(intervalo);
        Assertions.assertTrue(reloj.equals("Lunes",6));
    }
    @Test
    public void  RelojAvanzaCorrectamenteViajeaPais() {
        IntervaloTiempoViajeaPais intervaloPais = new IntervaloTiempoViajeaPais(25, 500);
        reloj.avanzarReloj(intervaloPais);
        Assertions.assertTrue(reloj.equals("Lunes",20));
    }
    @Test
    public void RelojAvanzaCorrectamenteDormir() {
        IntervaloTiempoDormir intervaloDormir = new IntervaloTiempoDormir();
        reloj.avanzarReloj(intervaloDormir);
        Assertions.assertTrue(reloj.equals("Lunes",8));
    }
    @Test
    public void RelojAvanzaCorrectamenteHeridaArmaFuego() {
        IntervaloHeridaArmaDeFuego intervaloHeridaArmaDeFuego = new IntervaloHeridaArmaDeFuego();
        reloj.avanzarReloj(intervaloHeridaArmaDeFuego);
        Assertions.assertTrue(reloj.equals("Lunes",4));
    }

    @Test
    public void RelojAvanzaCorrectamenteIncapacitacionArma() {
        IntervaloIncapacitacionArma intervaloIncapacitacionArma = new IntervaloIncapacitacionArma(2);
        reloj.avanzarReloj(intervaloIncapacitacionArma);
        Assertions.assertTrue(reloj.equals("Lunes",2));
    }
    @Test
    public void RelojAvanzaCorrectamenteEmitirArresto() {
        IntervaloTiempoEmitirArresto intervaloTiempoEmitirArresto = new IntervaloTiempoEmitirArresto();
        reloj.avanzarReloj(intervaloTiempoEmitirArresto);
        Assertions.assertTrue(reloj.equals("Lunes",3));
    }
    @Test
    public void RelojPasaDeDia() {
        IntervaloTiempoViajeaPais intervaloTiempoViajeaPais = new IntervaloTiempoViajeaPais(25, 500);
        IntervaloTiempoDormir intervaloTiempoDormir = new IntervaloTiempoDormir();
        reloj.avanzarReloj(intervaloTiempoViajeaPais);
        reloj.avanzarReloj(intervaloTiempoDormir);
        Assertions.assertTrue(reloj.equals("Martes",4));
    }
    @Test
    public void RelojCombinarAcciones()
    {
        IntervaloTiempoViajeaPais intervaloTiempoViajeaPais = new IntervaloTiempoViajeaPais(25, 500);
        IntervaloTiempoDormir intervaloTiempoDormir = new IntervaloTiempoDormir();
        IntervaloTiempoExplorarEdificio intervaloTiempoExplorarEdificio = new IntervaloTiempoExplorarEdificio(3);
        IntervaloHeridaArmaDeFuego intervaloHeridaArmaDeFuego = new IntervaloHeridaArmaDeFuego();
        IntervaloTiempoViajeaPais intervaloTiempoViajeaPais1 = new IntervaloTiempoViajeaPais(10, 150);
        reloj.avanzarReloj(intervaloTiempoViajeaPais);
        reloj.avanzarReloj(intervaloTiempoDormir);
        reloj.avanzarReloj(intervaloTiempoExplorarEdificio);
        reloj.avanzarReloj(intervaloHeridaArmaDeFuego);
        reloj.avanzarReloj(intervaloTiempoViajeaPais1);
        Assertions.assertTrue(reloj.equals("Miercoles",2));
    }

}