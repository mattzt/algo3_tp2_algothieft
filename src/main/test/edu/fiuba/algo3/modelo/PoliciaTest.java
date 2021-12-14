package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Arma.ArmaBlanca;
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Mapa.Paises.Pais;
import edu.fiuba.algo3.modelo.Edificios.*;
import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.Pistas.RepositorioPistas;
import edu.fiuba.algo3.modelo.Policia.Policia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PoliciaTest {
     private Policia agente;
     private Partida partida;
     private RepositorioPistas pistas;


     @BeforeEach
     public void setUp() throws IOException, NoExisteError {
         agente = new Policia("tobias", new Pais("Argentina","Buenos Aires"));
         partida = new Partida(agente);
         pistas = partida.obtenerPistas();
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
    }

}