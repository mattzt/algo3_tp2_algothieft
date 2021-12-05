package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Fachada.Fachada;
import edu.fiuba.algo3.modelo.Factory.Factory;
import edu.fiuba.algo3.modelo.Paises.Pais;
import edu.fiuba.algo3.modelo.Paises.PaisNoExisteError;
import edu.fiuba.algo3.modelo.Paises.Paises;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class PaisesTest {
    Paises todosLosPaises;
    Factory factory;
    String rutaArchivoDistancias = "src/main/java/edu/fiuba/algo3/modelo/Resources/DataPaises.txt";

    @BeforeEach
    public void setUp() {
        todosLosPaises = new Paises();
        factory = new Factory();
    }

    @Test
    public void agregarPais() {
        Pais atlantis = new Pais("Atlantis","Atlantis-City");
        todosLosPaises.agregarPais(atlantis);
        Assertions.assertEquals(1,todosLosPaises.size());
    }

    @Test
    public void crearPaises() throws FileNotFoundException {
        todosLosPaises = factory.crearPaises(rutaArchivoDistancias);
        Assertions.assertEquals(30,todosLosPaises.size());
    }

    @Test
    public void buscarPais() throws PaisNoExisteError, FileNotFoundException {
        todosLosPaises = factory.crearPaises(rutaArchivoDistancias);
        Pais buscado = todosLosPaises.buscarPais("Argentina");
        Assertions.assertTrue(buscado.equals("Argentina"));
    }

    @Test
    public void buscarPaisInexistenteLanzaException() {
        PaisNoExisteError except = Assertions.assertThrows(PaisNoExisteError.class,
                ()-> todosLosPaises.buscarPais("Argentina"));
    }
}