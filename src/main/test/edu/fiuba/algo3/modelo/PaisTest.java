package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Edificios.Edificios;
import edu.fiuba.algo3.modelo.Fachada.Fachada;
import edu.fiuba.algo3.modelo.Paises.Pais;
import edu.fiuba.algo3.modelo.Paises.Paises;
import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.Pistas.RepositorioPistas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.FileNotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class PaisTest {
    Pais argentina;
    Fachada calcDist;
    Pista unaPista;
    Edificio unEdificio;
    Paises paisesConexos;
    Edificios edificiosPublicos;
    RepositorioPistas pistas;

    @BeforeEach
    public void init() throws FileNotFoundException {
        argentina = new Pais("Argentina","Buenos Aires");
        calcDist = mock(Fachada.class);
        unaPista = mock(Pista.class);
        pistas = mock(RepositorioPistas.class);
        paisesConexos = mock(Paises.class);
        edificiosPublicos = mock(Edificios.class);
        unEdificio = mock(Edificio.class);
        argentina.setPaisesConexos(paisesConexos);
        argentina.setEdificios(edificiosPublicos);

        when(calcDist.calcularDistanciaDeHasta("Argentina","Peru")).thenReturn(3138);
        when(unEdificio.visitar(pistas)).thenReturn(unaPista);
    }

    @Test
    public void paisSeCreaCorrectamente(){
        Assertions.assertTrue(argentina.equals("Argentina"));
    }

    @Test
    public void distanciaArgentinaPeru() throws FileNotFoundException {
        Pais peru = new Pais("Peru","Lima");
        Assertions.assertEquals(3138,argentina.distanciaA(peru));
    }

    @Test
    public void visitarEdificio(){
        Assertions.assertEquals(unaPista,argentina.visitarEdificio(unEdificio, pistas));
    }

    @Test
    public void settersYGetters(){
        Assertions.assertEquals(edificiosPublicos,argentina.getEdificios());
        Assertions.assertEquals(paisesConexos,argentina.getPaisesConexos());
    }
}
