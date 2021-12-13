package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Arma.ArmaBlanca;
import edu.fiuba.algo3.modelo.Caso.Caso;
import edu.fiuba.algo3.modelo.Caso.Objeto;
import edu.fiuba.algo3.modelo.Caso.ObjetosValiosos;
import edu.fiuba.algo3.modelo.ComputadoraInterpol.ComputadoraInterpol;
import edu.fiuba.algo3.modelo.Criminales.Caracteristicas;
import edu.fiuba.algo3.modelo.Criminales.Criminal;
import edu.fiuba.algo3.modelo.Criminales.Pelo.Rubio;
import edu.fiuba.algo3.modelo.Criminales.Sexo.SexoFemenino;
import edu.fiuba.algo3.modelo.Criminales.Sospechosos;
import edu.fiuba.algo3.modelo.Edificios.Aeropuerto;
import edu.fiuba.algo3.modelo.Edificios.Banco;
import edu.fiuba.algo3.modelo.Edificios.Biblioteca;
import edu.fiuba.algo3.modelo.Edificios.Puerto;
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
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
    ComputadoraInterpol computadora = nuevoPoli.obtenerComputadora();
    Caracteristicas caracteristicas = new Caracteristicas(null, null, null, null, null);
    Criminal sospechoso = new Criminal(caracteristicas);
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
        Assertions.assertTrue(nuevoPoli.mirarLaHora()==0);
        nuevoPoli.recibirDanio(new ArmaBlanca());
        Assertions.assertTrue(nuevoPoli.mirarLaHora()==2);
        nuevoPoli.dormir();
        Assertions.assertTrue(nuevoPoli.mirarLaHora()==10);
    }

    @Test
    public void casoDeUso2() throws FileNotFoundException {
        nuevoPoli.rangoPoliciaEs(new Investigador());
        Assertions.assertTrue(nuevoPoli.seEncuentraEn(canada));
        Assertions.assertTrue(nuevoPoli.mirarLaHora()==0);
        caso.asignarCasoAPolicia(nuevoPoli);
        nuevoPoli.viajarApais(mexico);
        Assertions.assertTrue(nuevoPoli.seEncuentraEn(mexico));
        Assertions.assertTrue(nuevoPoli.mirarLaHora()>1);
    }

    @Test
    public void casoDeUso3(){
        nuevoPoli.agregarDatoSospechosoPelo(computadora, new Rubio());
        nuevoPoli.agregarDatoSospechosoSexo(computadora, new SexoFemenino());
        Assertions.assertEquals(Sospechosos.getClass(), computadora.buscarSospechosos());
    }

    @Test
    public void casoDeUso4() {
    }

    @Test
    public void casoDeUso5() {

    }
}
