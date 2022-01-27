package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Caso.Caso;
import edu.fiuba.algo3.modelo.Caso.ObjetosValiosos;
import edu.fiuba.algo3.modelo.Criminales.Criminal;
import edu.fiuba.algo3.modelo.Criminales.Sospechosos;
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Factory.CreadorCriminales;
import edu.fiuba.algo3.modelo.Factory.CreadorObjetos;
import edu.fiuba.algo3.modelo.Factory.CreadorPaises;
import edu.fiuba.algo3.modelo.Mapa.Paises.Paises;
import edu.fiuba.algo3.modelo.Policia.Novato;
import edu.fiuba.algo3.modelo.Policia.Policia;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;


public class CasoTest {

    private Caso unCaso;
    private final Sospechosos sospechosos;
    private final ObjetosValiosos listaDeObjetos;

    public CasoTest() throws FileNotFoundException, NoExisteError {
        CreadorCriminales factoryCriminales = new CreadorCriminales();
        sospechosos = factoryCriminales.crear("src/main/java/edu/fiuba/algo3/modelo/Resources/Sospechosos.txt");

        CreadorPaises factoryPaises = new CreadorPaises();
        Paises paises = factoryPaises.crear("src/main/java/edu/fiuba/algo3/modelo/Resources/DataPaises.txt");

        CreadorObjetos factoryObjetos = new CreadorObjetos(paises);
        listaDeObjetos = factoryObjetos.crear("src/main/java/edu/fiuba/algo3/modelo/Resources/ObjetosValiosos.txt");
    }

    @BeforeEach
    public void setUp(){
        unCaso = new Caso(sospechosos, listaDeObjetos, new Policia());
    }

    @Test
    public void criminalExiste() {
        Assertions.assertNotNull(unCaso.getCriminal());
    }

    @Test
    public void nombreDelObjeto(){
        Assertions.assertNotNull(unCaso.nombreObjeto());
    }

    @Test
    public void crearPistasDelCriminal(){
        ArrayList<String> lista = unCaso.pistasDelCriminal();

        Assertions.assertEquals(5, lista.size());
    }
}