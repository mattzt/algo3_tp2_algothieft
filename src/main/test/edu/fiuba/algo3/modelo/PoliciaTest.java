package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Arma.ArmaBlanca;
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Mapa.Paises.Pais;
import edu.fiuba.algo3.modelo.Edificios.*;
import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.Pistas.RepositorioPistas;
import edu.fiuba.algo3.modelo.Policia.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class PoliciaTest {
    private Policia agente;
    private RepositorioPistas pistas;


     @BeforeEach
     public void setUp() throws IOException, NoExisteError {
         agente = new Policia();
         Pais francia = new Pais("Francia", "Paris");
         Edificios edificios = new Edificios();
         edificios.agregar(new Banco());

         francia.setEdificios(edificios);
         agente.setPaisEnDondeEstoy(francia);

         Partida partida = Partida.getInstance();
         pistas = partida.obtenerPistas();
     }

     @Test
     public void testNombreYCiudad(){
         agente.setNombre("Claudia");
         Pais francia = new Pais("Francia", "Paris");
         Pais unPais = agente.getPaisActual();
         assertTrue(unPais.equals(francia));
     }

    @Test
    public void explorarSitio() {
        Banco banco = new Banco();

        Pista pista = agente.explorarSitio(banco, pistas);

        assertEquals(pista.darPista(), "Dijo que queria cambiar su dinero por Rublos");
    }

    @Test
    public void policiaEsHerido(){
        ArmaBlanca arma = new ArmaBlanca();
        arma.hacerDanio(agente);

        assertEquals(agente.mirarLaHora(), 2);
        assertEquals("Lunes",agente.mirarDia().diaDeHoy());
    }

    @Test
    public void velocidadNovato(){
         Novato novato = new Novato();
         assertTrue(novato.es("Novato"));
         assertEquals(900,novato.velocidadViaje());
    }

    @Test
    public void promoverNovato(){
        Rango novato = new Novato();
        for (int i=0;i<5;i++) novato.aumentarCasosResueltos();
        Rango promovido = novato.promover();
        assertTrue(promovido.es("Detective"));
        assertEquals(1100,promovido.velocidadViaje());
    }

    @Test
    public void promoverDetective(){
        Rango detective = new Detective();
        Rango promovido = detective.promover();
        assertFalse(promovido.es("Detective"));
        for (int i=0;i<10;i++) detective.aumentarCasosResueltos();
        promovido = detective.promover();
        assertTrue(promovido.es("Investigador"));
        assertEquals(1300,promovido.velocidadViaje());
    }

    @Test
    public void promoverInvestigador(){
        Rango investigador = new Investigador();
        Rango promovido = investigador.promover();
        assertFalse(promovido.es("Sargento"));
        for (int i=0;i<20;i++) investigador.aumentarCasosResueltos();
        promovido = investigador.promover();
        assertTrue(promovido.es("Sargento"));
    }

    @Test
    public void promoverSargento(){
        Rango sargento = new Sargento();
        Rango promovido = sargento.promover();
        assertTrue(promovido.es("Sargento"));
        assertEquals(1500,promovido.velocidadViaje());
    }

    @Test
    public void testToString(){
        Rango novato = new Novato();
        Rango detective = new Detective();
        Rango investigador = new Investigador();
        Rango sargento = new Sargento();

        assertEquals("FACIL",novato.toString());
        assertEquals("FACIL",detective.toString());
        assertEquals("NORMAL",investigador.toString());
        assertEquals("DIFICIL",sargento.toString());
    }

}