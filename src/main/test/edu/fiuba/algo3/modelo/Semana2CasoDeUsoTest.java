package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Arma.ArmaBlanca;
import edu.fiuba.algo3.modelo.Caso.Caso;
import edu.fiuba.algo3.modelo.Caso.Objeto;
import edu.fiuba.algo3.modelo.Caso.ObjetosValiosos;
import edu.fiuba.algo3.modelo.ComputadoraInterpol.ComputadoraInterpol;
import edu.fiuba.algo3.modelo.Criminales.Accesorios.Joyas;
import edu.fiuba.algo3.modelo.Criminales.Accesorios.Tatuaje;
import edu.fiuba.algo3.modelo.Criminales.Caracteristicas;
import edu.fiuba.algo3.modelo.Criminales.Criminal;
import edu.fiuba.algo3.modelo.Criminales.Hobbies.Tenis;
import edu.fiuba.algo3.modelo.Criminales.Pelo.Castanio;
import edu.fiuba.algo3.modelo.Criminales.Pelo.Rubio;
import edu.fiuba.algo3.modelo.Criminales.Sexo.SexoFemenino;
import edu.fiuba.algo3.modelo.Criminales.Sospechosos;
import edu.fiuba.algo3.modelo.Criminales.Vehiculo.Descapotable;
import edu.fiuba.algo3.modelo.Criminales.Vehiculo.Limusina;
import edu.fiuba.algo3.modelo.Edificios.Aeropuerto;
import edu.fiuba.algo3.modelo.Edificios.Banco;
import edu.fiuba.algo3.modelo.Edificios.Biblioteca;
import edu.fiuba.algo3.modelo.Edificios.Puerto;
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Factory.CreadorCriminales;
import edu.fiuba.algo3.modelo.Factory.CreadorPaises;
import edu.fiuba.algo3.modelo.Factory.CreadorPistas;
import edu.fiuba.algo3.modelo.Factory.Factory;
import edu.fiuba.algo3.modelo.Mapa.Paises.Pais;
import edu.fiuba.algo3.modelo.Mapa.Paises.Paises;
import edu.fiuba.algo3.modelo.Pistas.*;
import edu.fiuba.algo3.modelo.Policia.Detective;
import edu.fiuba.algo3.modelo.Policia.Investigador;
import edu.fiuba.algo3.modelo.Policia.Policia;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.internal.junit.DefaultTestFinishedEvent;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Semana2CasoDeUsoTest {
    Factory creador = new CreadorPaises();
    Paises todosLosPaises = (Paises) creador.crear("src/main/java/edu/fiuba/algo3/modelo/Resources/DataPaises.txt");
    Pais canada = todosLosPaises.buscar("Canada");
    Pais mexico = todosLosPaises.buscar("Mexico");
    Policia nuevoPoli = new Policia("Carlos", canada);
    ComputadoraInterpol computadora;
    Caracteristicas caracteristicas = new Caracteristicas(null, null, null, null, null);
    Criminal sospechoso = new Criminal("nombreCriminal",caracteristicas);
    Caso caso = new Caso(new Sospechosos(), new ObjetosValiosos());
    Objeto tesoroMontreal = new Objeto("Tesoro Nacional de Montreal",canada,1);
    Banco unBanco = new Banco();
    Biblioteca unaBiblioteca = new Biblioteca();
    Aeropuerto unAeropuerto = new Aeropuerto();
    Puerto unPuerto = new Puerto();
    CreadorPistas creadorPistas = new CreadorPistas();
    RepositorioPistas repo = (RepositorioPistas) creadorPistas.crear("src/main/java/edu/fiuba/algo3/modelo/Resources/PistasFaciles.txt");

    public Semana2CasoDeUsoTest() throws NoExisteError, IOException {
    }


    @Test
    public void casoDeUso1() {
        nuevoPoli.rangoPoliciaEs(new Detective());
        Assertions.assertEquals(0, nuevoPoli.mirarLaHora());
        nuevoPoli.recibirDanio(new ArmaBlanca());
        Assertions.assertEquals(2, nuevoPoli.mirarLaHora());
        nuevoPoli.dormir();
        Assertions.assertEquals(10, nuevoPoli.mirarLaHora());
    }

    @Test
    public void casoDeUso2() throws FileNotFoundException {
        nuevoPoli.rangoPoliciaEs(new Investigador());
        Assertions.assertTrue(nuevoPoli.seEncuentraEn(canada));
        Assertions.assertEquals(0, nuevoPoli.mirarLaHora());
        caso.asignarCasoAPolicia(nuevoPoli);
        nuevoPoli.viajarApais(mexico);
        Assertions.assertTrue(nuevoPoli.seEncuentraEn(mexico));
        Assertions.assertTrue(nuevoPoli.mirarLaHora()>1);
    }

    @Test
    public void casoDeUso3() throws FileNotFoundException {
        CreadorCriminales creadorCriminales = new CreadorCriminales();
        Sospechosos listaSospechosos = creadorCriminales.crear("src/main/java/edu/fiuba/algo3/modelo/Resources/sospechosos.txt");
        Sospechosos listaFiltrada;
        computadora = new ComputadoraInterpol(listaSospechosos);
        nuevoPoli.ingresarDato(computadora, new Rubio());
        nuevoPoli.ingresarDato(computadora, new SexoFemenino());
        nuevoPoli.ingresarDato(computadora, new Tenis());
        nuevoPoli.ingresarDato(computadora, new Tatuaje());
        listaFiltrada = nuevoPoli.ingresarDato(computadora, new Limusina());
        Assertions.assertEquals(1,listaFiltrada.size());
    }

    @Test
    public void casoDeUso4() throws FileNotFoundException {
        CreadorCriminales creadorCriminales = new CreadorCriminales();
        Sospechosos listaSospechosos = creadorCriminales.crear("src/main/java/edu/fiuba/algo3/modelo/Resources/sospechosos.txt");
        computadora = new ComputadoraInterpol(listaSospechosos);

        nuevoPoli.ingresarDato(computadora, new SexoFemenino());
        nuevoPoli.ingresarDato(computadora, new Castanio());
        nuevoPoli.ingresarDato(computadora, new Tenis());
        nuevoPoli.ingresarDato(computadora, new Joyas());
        nuevoPoli.ingresarDato(computadora, new Descapotable());

        String arrestar = nuevoPoli.arrestar(computadora);

        Assertions.assertEquals(arrestar, "No pudiste arrestar al criminal porque no tenias orden de arresto :( El criminal era Carmen Sandiego");

    }

    @Test
    public void casoDeUso5() {

    }
}
