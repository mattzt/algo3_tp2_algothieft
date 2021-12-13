package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Caso.Objeto;
import edu.fiuba.algo3.modelo.Caso.ObjetosValiosos;
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Factory.CreadorObjetos;
import edu.fiuba.algo3.modelo.Factory.CreadorPaises;
import edu.fiuba.algo3.modelo.Factory.Factory;
import edu.fiuba.algo3.modelo.Mapa.Paises.Paises;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObjetosTest {
    String rutaArchivoObjetos = "src/main/java/edu/fiuba/algo3/modelo/Resources/ObjetosValiosos.txt";
    CreadorPaises factoryPaises = new CreadorPaises();
    Paises paises = factoryPaises.crear("src/main/java/edu/fiuba/algo3/modelo/Resources/DataPaises.txt");
    Factory factory = new CreadorObjetos(paises);
    ObjetosValiosos listaDeObjetos = (ObjetosValiosos) factory.crear(rutaArchivoObjetos);

    public ObjetosTest() throws IOException, NoExisteError {
    }

    @Test
    public void objetosSeCreanCorrectamente() {
        assertEquals(29,listaDeObjetos.size());
    }

    @Test
    public void buscarObjetoCreado() throws NoExisteError {
        Objeto tesoroMontreal = listaDeObjetos.buscar("Tesoro Nacional de Montreal");
        Assertions.assertTrue(tesoroMontreal.equals("Tesoro Nacional de Montreal"));
    }
}
