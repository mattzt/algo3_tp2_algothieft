package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Fachada.Fachada;
import edu.fiuba.algo3.modelo.Paises.Pais;
import edu.fiuba.algo3.modelo.Paises.PaisNoExisteError;
import edu.fiuba.algo3.modelo.Paises.Paises;
import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.Policia.Policia;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class CasosDeUsoTest {
    Fachada creador = new Fachada();
    Paises todosLosPaises = creador.crearPaises();
    Policia nuevoPoli;

    public CasosDeUsoTest() throws FileNotFoundException {
    }

    @Before
    public void setUpCase1() throws PaisNoExisteError {
        Pais canada = todosLosPaises.buscarPais("Canada");
        nuevoPoli = new Policia("Matias",canada);
//        Objeto = todosLosObjetos.robar("Tesoro Nacional de Montreal"); -> Específicamente ese objeto.
//        Criminal = todosLosSospechosos.filtrarSospechoso(Femenino); -> Elegir uno al azar, todos son femeninos y cumplen.
//        Crear banco -> Setearlo a canada
    }

    @Before
    public void setUpCase3() throws PaisNoExisteError {
        Pais canada = todosLosPaises.buscarPais("Canada");
        nuevoPoli = new Policia("Matias", canada);
    }

    @Test
    public void casoDeUso1() throws PaisNoExisteError {
        setUpCase1();
        Assertions.assertTrue(nuevoPoli.seEncuentraEn("Montreal"));
//        Pista unaPista = nuevoPoli.explorarSitio(Banco,pistas);
//        Assertions.assertTrue(unaPista.getClass().equals(Pista.class));
    }

    @Test
    public void casoDeUso3() throws FileNotFoundException, PaisNoExisteError {
        setUpCase3();
        Pais mexico = todosLosPaises.buscarPais("Mexico");
        nuevoPoli.viajarApais(mexico);
        Assertions.assertTrue(nuevoPoli.seEncuentraEn("Mexico"));
    }
}
