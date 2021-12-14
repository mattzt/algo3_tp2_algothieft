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
    Paises todosLosPaises;
    Factory factory;
    String rutaArchivoDistancias = "src/main/java/edu/fiuba/algo3/modelo/Resources/DataPaises.txt";

    @BeforeEach
    public void setUp() {
        todosLosPaises = new Paises();
        factory = new CreadorPaises();
    }

    @Test
    public void agregarPais() {
        Pais atlantis = new Pais("Atlantis","Atlantis-City");
        todosLosPaises.agregar(atlantis);
        assertEquals(1,todosLosPaises.size());
    }

    @Test
    public void crearPaises() throws IOException, NoExisteError {
        todosLosPaises = (Paises) factory.crear(rutaArchivoDistancias);
        Assertions.assertEquals(30,todosLosPaises.size());
    }

    @Test
    public void buscarPais() throws NoExisteError, IOException {
        todosLosPaises = (Paises) factory.crear(rutaArchivoDistancias);
        Pais argentina = todosLosPaises.buscar("Argentina");
        assertEquals("Argentina", argentina.getNombre());
    }

    @Test
    public void buscarPaisInexistenteLanzaException() {
        NoExisteError except = assertThrows(NoExisteError.class,
                ()-> todosLosPaises.buscar("Argentina"));
    }

    @Test
    public void rutaDeEscapeParaObjetoComunTiene4Paises() throws NoExisteError, IOException {
        todosLosPaises = (Paises) factory.crear(rutaArchivoDistancias);
        Pais origenDelObjeto = todosLosPaises.buscar("Argentina");
        ArrayList<Pais> rutaDeEscape = todosLosPaises.elegirRutaDeEscapePorNivel(origenDelObjeto,4);
        Assertions.assertEquals(4,rutaDeEscape.size());
    }

    @Test
    public void testSetPaisesConexos() throws NoExisteError, IOException {
        todosLosPaises = (Paises) factory.crear(rutaArchivoDistancias);
        todosLosPaises.setPaisesConexos();
        Pais unPais = todosLosPaises.buscar("Argentina");
        Assertions.assertFalse(unPais.puedeAgregarConexos());
    }
}