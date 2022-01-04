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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;



public class CasoTest {
    CreadorCriminales factoryCriminales = new CreadorCriminales();
    Sospechosos sospechosos = factoryCriminales.crear("src/main/java/edu/fiuba/algo3/modelo/Resources/sospechosos.txt");

    CreadorPaises factoryPaises = new CreadorPaises();
    Paises paises = factoryPaises.crear("src/main/java/edu/fiuba/algo3/modelo/Resources/DataPaises.txt");

    CreadorObjetos factoryObjetos = new CreadorObjetos(paises);
    ObjetosValiosos listaDeObjetos = factoryObjetos.crear("src/main/java/edu/fiuba/algo3/modelo/Resources/ObjetosValiosos.txt");

    Caso unCaso = new Caso(sospechosos,listaDeObjetos,paises,new Novato());

    public CasoTest() throws FileNotFoundException, NoExisteError {
    }

    @Test
    public void getCriminal() {
        Assertions.assertEquals(Criminal.class, unCaso.getCriminal().getClass());
    }
}