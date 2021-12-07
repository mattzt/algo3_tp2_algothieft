package edu.fiuba.algo3.modelo;

import com.tngtech.archunit.lang.ArchRule;
import edu.fiuba.algo3.modelo.Caso.Objeto;
import edu.fiuba.algo3.modelo.Criminales.Criminal;
import edu.fiuba.algo3.modelo.Edificios.Banco;
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Factory.CreadorPaises;
import edu.fiuba.algo3.modelo.Factory.Factory;
import edu.fiuba.algo3.modelo.Paises.Pais;
import edu.fiuba.algo3.modelo.Paises.Paises;
import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.Pistas.PistaBanco;
import edu.fiuba.algo3.modelo.Pistas.RepositorioPistas;
import edu.fiuba.algo3.modelo.Policia.Policia;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CasosDeUsoTest {
    Factory creador = new CreadorPaises();
    Paises todosLosPaises = (Paises) creador.crear("src/main/java/edu/fiuba/algo3/modelo/Resources/DataPaises.txt");
    Policia nuevoPoli;
    Objeto tesoroMontreal;
    Banco unBanco;
    RepositorioPistas repo;
    Pista unaPista;
    Criminal criminal;

    public CasosDeUsoTest() throws FileNotFoundException, NoExisteError {
    }

    @Before
    public void setUpCase1() throws NoExisteError, IOException {
        Pais canada = todosLosPaises.buscar("Canada");
        nuevoPoli = new Policia("Matias",canada);
        tesoroMontreal = new Objeto("Tesoro Nacional de Montreal",canada,1);
        String[] sexoDelCriminal = {"Femenino","El sospechoso era una mujer"};
        criminal = new Criminal(sexoDelCriminal,null,null,null,null);
        repo = new RepositorioPistas(nuevoPoli);
        unBanco = new Banco();
    }

    @Before
    public void setUpCase3() throws NoExisteError {
        Pais canada = todosLosPaises.buscar("Canada");
        nuevoPoli = new Policia("Matias", canada);
    }

    @Test
    public void casoDeUso1() throws NoExisteError, IOException {
        setUpCase1();
        Assertions.assertTrue(nuevoPoli.seEncuentraEn("Montreal"));
        Assertions.assertTrue(tesoroMontreal.equals("Tesoro Nacional de Montreal"));
        Assertions.assertEquals(criminal.sexo(),"Femenino");
        unaPista = nuevoPoli.explorarSitio(unBanco,repo);
        Assertions.assertEquals(unaPista.getClass(), PistaBanco.class);
    }

    @Test
    public void casoDeUso3() throws FileNotFoundException, NoExisteError {
        setUpCase3();
        Pais mexico = todosLosPaises.buscar("Mexico");
        nuevoPoli.viajarApais(mexico);
        Assertions.assertTrue(nuevoPoli.seEncuentraEn("Mexico"));
    }
}
