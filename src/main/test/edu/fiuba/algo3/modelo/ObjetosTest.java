package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Caso.Objeto;
import edu.fiuba.algo3.modelo.Caso.ObjetosValiosos;
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Factory.CreadorObjetos;
import edu.fiuba.algo3.modelo.Factory.CreadorPaises;
import edu.fiuba.algo3.modelo.Factory.Factory;
import edu.fiuba.algo3.modelo.Mapa.Paises.Paises;
import edu.fiuba.algo3.modelo.Policia.Investigador;
import edu.fiuba.algo3.modelo.Policia.Novato;
import edu.fiuba.algo3.modelo.Policia.Sargento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    public void buscarObjetoComun() throws NoExisteError {
        Objeto tesoroMontreal = listaDeObjetos.buscar("Tesoro Nacional de Montreal",1);
        Assertions.assertTrue(tesoroMontreal.equals("Tesoro Nacional de Montreal"));
    }

    @Test
    public void buscarObjetoValioso() throws NoExisteError {
        Objeto elMichiDorado = listaDeObjetos.buscar("Leon dorado",2);
        Assertions.assertTrue(elMichiDorado.equals("Leon dorado"));
    }

    @Test
    public void buscarObjetoMuyValioso() throws NoExisteError {
        Objeto lasGurizas = listaDeObjetos.buscar("Rockettes",3);
        Assertions.assertTrue(lasGurizas.equals("Rockettes"));
    }

    @Test
    public void buscarObjetoInexistenteTiraException() {
        assertThrows(NoExisteError.class,() -> listaDeObjetos.buscar("El teclado de Mati", 3));
    }

    @Test
    public void seRobaUnObjetoNivel1() {
        Objeto robado = listaDeObjetos.robarObjetoPorNivel(new Novato());
        Assertions.assertTrue(robado.tieneValor(1));
    }

    @Test
    public void seRobaUnObjetoNivel2() {
        Objeto robado = listaDeObjetos.robarObjetoPorNivel(new Investigador());
        Assertions.assertTrue(robado.tieneValor(2));
    }

    @Test
    public void seRobaUnObjetoNivel3() {
        Objeto robado = listaDeObjetos.robarObjetoPorNivel(new Sargento());
        Assertions.assertTrue(robado.tieneValor(3));
    }

    @Test
    public void paisesDeEscapeObjetoComun() throws NoExisteError {
        Objeto tesoroMontreal = listaDeObjetos.buscar("Tesoro Nacional de Montreal",1);
        Assertions.assertEquals(4,tesoroMontreal.cantidadDePaisesDeEscape());
    }

    @Test
    public void paisesDeEscapeObjetoValioso() throws NoExisteError {
        Objeto elMichiDorado = listaDeObjetos.buscar("Leon dorado",2);
        Assertions.assertEquals(5,elMichiDorado.cantidadDePaisesDeEscape());
    }

    @Test
    public void paisesDeEscapeObjetoMuyValioso() throws NoExisteError {
        Objeto lasGurizas = listaDeObjetos.buscar("Rockettes",3);
        Assertions.assertEquals(7,lasGurizas.cantidadDePaisesDeEscape());
    }
}
