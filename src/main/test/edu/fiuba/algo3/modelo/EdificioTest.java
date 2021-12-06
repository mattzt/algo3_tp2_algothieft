package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Ciudades.Ciudad;
import edu.fiuba.algo3.modelo.Edificios.*;
import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.Pistas.RepositorioPistas;
import edu.fiuba.algo3.modelo.Policia.Policia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

public class EdificioTest {
    private Pista resultado;
    private RepositorioPistas pistas;


    @BeforeEach
    public void setUp() throws IOException {
        Policia policia = new Policia("pepe", new Ciudad());
        Partida partida = new Partida(policia);
        resultado = null;
        pistas = partida.obtenerPistas();
    }

    @Test
    public void visitarBancoTest(){
        Banco banco = new Banco();

        resultado = banco.visitar(pistas);

        assertEquals(resultado.darPista(), "Dijo que queria cambiar su dinero por Rublos");
    }

    @Test
    public void visitarBibliotecaTest(){
        Biblioteca biblioteca = new Biblioteca();

        resultado = biblioteca.visitar(pistas);

        assertEquals(resultado.darPista(), "Dijo que iba a estudiar la historia de sus grandes filosofos");

    }

    @Test
    public void visitarBolsaTest(){
        Bolsa bolsa = new Bolsa();

        resultado = bolsa.visitar(pistas);

        assertEquals(resultado.darPista(), "Dijo que le interesaban un pais que basaba su economia en la agricultura");

    }

    @Test
    public void visitarAeropuertoTest(){
        Aeropuerto aeropuerto = new Aeropuerto();

        resultado = aeropuerto.visitar(pistas);

        assertEquals(resultado.darPista(), "Tomo un avion con una bandera roja y blanca. Dijo que habia estado tomando clases de frances");

    }

    @Test
    public void visitarPuertoTest(){
        Puerto puerto = new Puerto();

        resultado = puerto.visitar(pistas);

        assertEquals(resultado.darPista(), "Estaba buscando un barco con una bandera celeste y blanca");

    }

}
