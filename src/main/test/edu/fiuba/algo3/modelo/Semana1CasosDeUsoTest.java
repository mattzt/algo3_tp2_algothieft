package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Arma.ArmaBlanca;
import edu.fiuba.algo3.modelo.Caso.Objeto;
import edu.fiuba.algo3.modelo.Edificios.*;
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Factory.CreadorPaises;
import edu.fiuba.algo3.modelo.Factory.CreadorPistas;
import edu.fiuba.algo3.modelo.Factory.Factory;
import edu.fiuba.algo3.modelo.Mapa.Paises.Pais;
import edu.fiuba.algo3.modelo.Mapa.Paises.Paises;
import edu.fiuba.algo3.modelo.Pistas.*;
import edu.fiuba.algo3.modelo.Policia.Policia;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Semana1CasosDeUsoTest {
    Factory creador = new CreadorPaises();
    Paises todosLosPaises = (Paises) creador.crear("src/main/java/edu/fiuba/algo3/modelo/Resources/DataPaises.txt");
    Pais canada = todosLosPaises.buscar("Canada");
    Policia nuevoPoli = new Policia();
    Objeto tesoroMontreal = new Objeto("Tesoro Nacional de Montreal",canada,1);
    Banco unBanco = new Banco();
    Biblioteca unaBiblioteca = new Biblioteca();
    Aeropuerto unAeropuerto = new Aeropuerto();
    Puerto unPuerto = new Puerto();
    CreadorPistas creadorPistas = new CreadorPistas();
    RepositorioPistas repo = (RepositorioPistas) creadorPistas.crear("src/main/java/edu/fiuba/algo3/modelo/Resources/PistasFaciles.txt");


    public Semana1CasosDeUsoTest() throws IOException, NoExisteError {
        Edificios edificios = new Edificios();
        edificios.agregar(unBanco);
        edificios.agregar(unaBiblioteca);
        edificios.agregar(unAeropuerto);
        edificios.agregar(unPuerto);

        canada.setEdificios(edificios);
        nuevoPoli.setPaisInicial(canada);
    }

    @Test
    public void casoDeUso1() {
        Pista unaPista = nuevoPoli.visitarEdificio(unBanco,repo);
        Assertions.assertTrue(nuevoPoli.seEncuentraEn(canada));
        Assertions.assertTrue(tesoroMontreal.equals("Tesoro Nacional de Montreal"));
        Assertions.assertEquals(PistaBanco.class,unaPista.getClass());
    }

    @Test
    public void casoDeUso2() {
        Pista unaPista = nuevoPoli.visitarEdificio(unBanco,repo);
        Assertions.assertEquals(PistaBanco.class, unaPista.getClass());

        Pista unaSegundaPista = nuevoPoli.visitarEdificio(unBanco,repo);
        Assertions.assertEquals(PistaBanco.class,unaSegundaPista.getClass());

        Pista unaTercerPista = nuevoPoli.visitarEdificio(unaBiblioteca,repo);
        Assertions.assertEquals(PistaBiblioteca.class,unaTercerPista.getClass());
    }

    @Test
    public void casoDeUso3() throws FileNotFoundException, NoExisteError {
        nuevoPoli.resetearReloj();
        Pais mexico = todosLosPaises.buscar("Mexico");
        nuevoPoli.viajarApais(mexico);
        Assertions.assertTrue(nuevoPoli.seEncuentraEn(mexico));
        Assertions.assertEquals(11,nuevoPoli.mirarLaHora());
    }

    @Test
    public void casoDeUso4() {
        for (int i=0;i<3;i++){
            Pista pistaAeropuerto = nuevoPoli.visitarEdificio(unAeropuerto,repo);
            Assertions.assertEquals(PistaAeropuerto.class,pistaAeropuerto.getClass());
        }
        for (int j=0;j<55;j++){
            Pista pistaPuerto = nuevoPoli.visitarEdificio(unPuerto,repo);
            Assertions.assertEquals(PistaPuerto.class,pistaPuerto.getClass());
        }
    }

    @Test
    public void casoDeUso5() {
        nuevoPoli.resetearReloj();
        ArmaBlanca daga = new ArmaBlanca();
        nuevoPoli.recibirDanio(daga);
        Assertions.assertEquals(10,nuevoPoli.mirarLaHora());
        nuevoPoli.dormir();
        Assertions.assertEquals(18,nuevoPoli.mirarLaHora());
    }
}
