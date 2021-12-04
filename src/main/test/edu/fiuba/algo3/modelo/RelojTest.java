package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.modelo.Reloj.Reloj;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RelojTest {
    Reloj reloj;
    int horasDeUnDia;

    @BeforeEach
    public void setUp(){
        reloj = new Reloj();
        horasDeUnDia = 24;
    }

    @Test
    public void seCreaRelojCorrectamenteInicializado() {
        Assertions.assertTrue(reloj.equals("Lunes",0));
    }

    @Test
    public void relojAvanzaCorrectamente() {
        reloj.avanzarReloj(15);
        Assertions.assertTrue(reloj.equals("Lunes",15));
    }

    @Test
    public void relojAvanzaCorrectamente2() {
        reloj.avanzarReloj(16);
        Assertions.assertFalse(reloj.equals("Lunes",15));
    }

    @Test
    public void pasarlunesAMartes0Horas() {
        reloj.avanzarReloj(horasDeUnDia);
        Assertions.assertTrue(reloj.equals("Martes",0));
    }

    @Test
    public void pasarlunesAMartes23Horas() {
        reloj.avanzarReloj(horasDeUnDia+23);
        Assertions.assertTrue(reloj.equals("Martes",23));
    }

    @Test
    public void pasarlunesAMiercoles0Horas() {
        int horasDeLunesAMiercoles = horasDeUnDia*2;
        reloj.avanzarReloj(horasDeLunesAMiercoles);
        Assertions.assertTrue(reloj.equals("Miercoles",0));
    }

    @Test
    public void pasarLunesAJueves() {
        int horasParaElJueves = horasDeUnDia*3;
        reloj.avanzarReloj(horasParaElJueves);
        Assertions.assertTrue(reloj.equals("Jueves",0));
    }

    @Test
    public void pasarDiasHabiles() {
        int horasParaElViernes = horasDeUnDia*4;
        reloj.avanzarReloj(horasParaElViernes);
        Assertions.assertTrue(reloj.equals("Viernes",0));
    }

    @Test
    public void pasarAlFinde() {
        int horasParaElSabado = horasDeUnDia*5;
        reloj.avanzarReloj(horasParaElSabado);
        Assertions.assertTrue(reloj.equals("Sabado",0));
    }

    @Test
    public void pasarAlDomingo() {
        int horasDeLunesADomingo = horasDeUnDia*6;
        reloj.avanzarReloj(horasDeLunesADomingo);
        Assertions.assertTrue(reloj.equals("Domingo",0));
    }

    @Test
    public void pasarTodaLaSemana() {
        int horasDeUnaSemana = horasDeUnDia*7;
        reloj.avanzarReloj(horasDeUnaSemana);
        Assertions.assertTrue(reloj.equals("Lunes",0));
    }

}