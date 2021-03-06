package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Edificios.Edificios;
import edu.fiuba.algo3.modelo.Mapa.MapaDistancias;
import edu.fiuba.algo3.modelo.Mapa.Paises.Pais;
import edu.fiuba.algo3.modelo.Mapa.Paises.Paises;
import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.Pistas.RepositorioPistas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import java.io.FileNotFoundException;

public class PaisTest {
    Pais argentina = new Pais("Argentina","Buenos Aires");
    MapaDistancias calcDist = mock(MapaDistancias.class);
    Pista unaPista = mock(Pista.class);
    Edificio unEdificio = mock(Edificio.class);
    Paises paisesConexos = mock(Paises.class);
    Edificios edificiosPublicos = mock(Edificios.class);
    RepositorioPistas pistas = mock(RepositorioPistas.class);

    @BeforeEach
    public void init() throws FileNotFoundException {
        argentina.setPaisesConexos(paisesConexos);
        argentina.setEdificios(edificiosPublicos);
        when(calcDist.calcularDistanciaDeHasta("Argentina","Peru")).thenReturn(3138);
        Pais siguientePais = new Pais("Peru", "Lima");
        when(unEdificio.visitar(pistas)).thenReturn(unaPista);
    }

    @Test
    public void paisSeCreaCorrectamente(){
        Assertions.assertEquals("Argentina",argentina.getNombre());
    }

    @Test
    public void distanciaArgentinaPeru() throws FileNotFoundException {
        Pais peru = new Pais("Peru","Lima");
        Assertions.assertEquals(3138,argentina.distanciaA(peru));
    }

    @Test
    public void settersYGetters(){
        Assertions.assertEquals(edificiosPublicos,argentina.getEdificios());
        Assertions.assertEquals(paisesConexos,argentina.getPaisesConexos());
    }
}
