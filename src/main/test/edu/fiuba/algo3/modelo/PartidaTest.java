package edu.fiuba.algo3.modelo;

import com.tngtech.archunit.lang.ArchRule;
import edu.fiuba.algo3.modelo.Criminales.Caracteristica;
import edu.fiuba.algo3.modelo.Criminales.Pelo.Rubio;
import edu.fiuba.algo3.modelo.Criminales.Sexo.SexoFemenino;
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Policia.Policia;
import edu.fiuba.algo3.modelo.Reloj.Momento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PartidaTest {
    Partida unaPartida = Partida.getInstance();
    Caracteristica rubio = new Rubio();

    PartidaTest() throws NoExisteError, IOException {
    }

    @BeforeEach
    void setUp(){
        unaPartida.resetearFiltros();
    }

    @Test
    void singletonFuncionaComoDeberia() throws NoExisteError, IOException {
        Assertions.assertEquals(unaPartida,Partida.getInstance());
    }

    @Test
    void getPolicia() {
        Policia unPolicia = unaPartida.getPolicia();
        unPolicia.setNombre("Juli");
        assertTrue(unPolicia.es("Juli"));
    }

    @Test
    void filtrarYRevisarCantidadDeSospechosos() {
        unaPartida.filtrar(rubio);
        assertEquals(2,unaPartida.cantidadSospechosos());
    }

    @Test
    void resetearFiltros() {
        unaPartida.resetearFiltros();
        assertEquals(10,unaPartida.cantidadSospechosos());

    }

    @Test
    void emitirOrdenYarrestar() {
        unaPartida.resetearFiltros();
        Caracteristica femenino = new SexoFemenino();
        unaPartida.filtrar(femenino);
        unaPartida.filtrar(rubio);
        unaPartida.emitirOrden();
        assertEquals("Arrestaste al criminal! El criminal era Dazzle Annie",unaPartida.arrestar());

    }
}