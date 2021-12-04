package edu.fiuba.algo3.modelo.Policia;

import edu.fiuba.algo3.modelo.Ciudades.Ciudad;
import edu.fiuba.algo3.modelo.Edificios.Banco;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.Pistas.RepositorioPistas;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

public class EdificioTest {

    @Test
    public void visitarBancoTest() throws IOException {
        Policia policia = new Policia("pepe", new Ciudad());
        Partida partida = new Partida(policia);
        Banco banco = new Banco();
        Pista resultado;

        RepositorioPistas pistas = partida.obtenerPistas();

        resultado = policia.explorarSitio(banco, pistas);

        assertEquals(resultado.darPista(), "Dijo que queria cambiar su dinero por Rublos");
    }
}
