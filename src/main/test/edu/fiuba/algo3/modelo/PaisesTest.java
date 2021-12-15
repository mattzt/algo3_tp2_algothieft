package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Factory.CreadorPaises;
import edu.fiuba.algo3.modelo.Factory.Factory;
import edu.fiuba.algo3.modelo.Mapa.Paises.Pais;
import edu.fiuba.algo3.modelo.Mapa.Paises.Paises;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PaisesTest {
    String rutaArchivoDistancias = "src/main/java/edu/fiuba/algo3/modelo/Resources/DataPaises.txt";
    Factory factory = new CreadorPaises();
    Paises todosLosPaises = (Paises) factory.crear(rutaArchivoDistancias);

    public PaisesTest() throws NoExisteError, IOException {
    }

    @Test
    public void agregarPais() {
        Pais atlantis = new Pais("Atlantis","Atlantis-City");
        todosLosPaises.agregar(atlantis);
        assertEquals(31,todosLosPaises.size());
    }

    @Test
    public void crearPaises() {
        Assertions.assertEquals(30,todosLosPaises.size());
    }

    @Test
    public void buscarPais() throws NoExisteError {
        assertEquals("Argentina", todosLosPaises.buscar("Argentina").getNombre());
    }

    @Test
    public void buscarPaisInexistenteLanzaException() {
        NoExisteError except = assertThrows(NoExisteError.class,
                ()-> todosLosPaises.buscar("Narnia"));
    }

    @Test
    public void rutaDeEscapeParaObjetoComunTiene4Paises() throws NoExisteError {
        Pais origenDelObjeto = todosLosPaises.buscar("Argentina");
        ArrayList<Pais> rutaDeEscape = todosLosPaises.elegirRutaDeEscapePorNivel(origenDelObjeto,4);
        Assertions.assertEquals(4,rutaDeEscape.size());
    }

    @Test
    public void testSetPaisesConexosMasivo() {
        todosLosPaises.setPaisesConexos();
        Assertions.assertTrue(todosLosPaises.testConexosCompletos());
    }
}