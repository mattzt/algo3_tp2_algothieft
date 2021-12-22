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
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Factory.*;
import edu.fiuba.algo3.modelo.Mapa.Paises.Pais;
import edu.fiuba.algo3.modelo.Mapa.Paises.Paises;
import edu.fiuba.algo3.modelo.Policia.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Semana2CasoDeUsoTest {
    Factory creador = new CreadorPaises();
    Paises todosLosPaises = (Paises) creador.crear("src/main/java/edu/fiuba/algo3/modelo/Resources/DataPaises.txt");
    Factory creadorCriminales = new CreadorCriminales();
    Sospechosos todosLosSospechosos = (Sospechosos) creadorCriminales.crear("src/main/java/edu/fiuba/algo3/modelo/Resources/sospechosos.txt");
    Factory creadorObjetos = new CreadorObjetos(todosLosPaises);
    ObjetosValiosos todosLosObjetos = (ObjetosValiosos) creadorObjetos.crear("src/main/java/edu/fiuba/algo3/modelo/Resources/ObjetosValiosos.txt");
    Pais canada = todosLosPaises.buscar("Canada");
    Pais mexico = todosLosPaises.buscar("Mexico");
    Policia nuevoPoli = new Policia();
    ComputadoraInterpol computadora;
    Caso caso = new Caso(todosLosSospechosos,todosLosObjetos,todosLosPaises,new Novato());

    public Semana2CasoDeUsoTest() throws NoExisteError, IOException {
        computadora = new ComputadoraInterpol(todosLosSospechosos);
        nuevoPoli.setComputadora(computadora);
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
        nuevoPoli.setPaisEnDondeEstoy(canada);

        assertTrue(nuevoPoli.seEncuentraEn(canada));
        Assertions.assertEquals(0, nuevoPoli.mirarLaHora());
        caso.asignarCasoAPolicia(nuevoPoli);
        nuevoPoli.viajarApais(mexico);
        assertTrue(nuevoPoli.seEncuentraEn(mexico));
        assertTrue(nuevoPoli.mirarLaHora()>1);
    }

    @Test
    public void casoDeUso3() {
        computadora = new ComputadoraInterpol(todosLosSospechosos);

        nuevoPoli.ingresarDato(new Rubio());
        nuevoPoli.ingresarDato(new SexoFemenino());
        nuevoPoli.ingresarDato(new Tenis());
        nuevoPoli.ingresarDato(new Tatuaje());
        nuevoPoli.ingresarDato(new Limusina());
        Assertions.assertEquals(1, nuevoPoli.cantidadSospechosos());
    }

    @Test
    public void casoDeUso4() {
        computadora = new ComputadoraInterpol(todosLosSospechosos);

        nuevoPoli.ingresarDato(new SexoFemenino());
        nuevoPoli.ingresarDato(new Castanio());
        nuevoPoli.ingresarDato(new Tenis());
        nuevoPoli.ingresarDato(new Joyas());
        nuevoPoli.ingresarDato(new Descapotable());

        Criminal arrestado = nuevoPoli.arrestar();

        Assertions.assertNull(arrestado);

    }



    @Test
    public void casoDeUso5() {
        computadora = new ComputadoraInterpol(todosLosSospechosos);

        arrestarSeisVeces();

        Rango rangoNuevo =  nuevoPoli.presentarPlaca();

        assertTrue(rangoNuevo.equals(new Detective()));


        Pais mexico = new Pais("Mexico", "Ciudad-de-Mexico");
        Objeto objetoRobado = new Objeto("Incan Gold Mask", mexico, 1);
        Caso nuevoCaso = new Caso(todosLosSospechosos,todosLosObjetos,todosLosPaises,rangoNuevo);

        nuevoCaso.asignarCasoAPolicia(nuevoPoli);

        nuevoPoli.ingresarDato(new SexoFemenino());
        nuevoPoli.ingresarDato(new Castanio());
        nuevoPoli.ingresarDato(new Tenis());
        nuevoPoli.ingresarDato(new Joyas());
        nuevoPoli.ingresarDato(new Descapotable());

        nuevoPoli.emitirOrdenArresto();

        Criminal resultado = nuevoPoli.arrestar();


        Caracteristicas caracteristicas = new Caracteristicas(null,null,null,null,null);
        Criminal prueba = new Criminal("Carmen Sandiego", caracteristicas);

        assertTrue(resultado.equals(prueba));
    }



    private void arrestarSeisVeces(){
        for(int i = 0; i < 6; i ++) {
            nuevoPoli.ingresarDato(new SexoFemenino());
            nuevoPoli.ingresarDato(new Castanio());
            nuevoPoli.ingresarDato(new Tenis());
            nuevoPoli.ingresarDato(new Joyas());
            nuevoPoli.ingresarDato(new Descapotable());

            nuevoPoli.emitirOrdenArresto();

            nuevoPoli.arrestar();

            nuevoPoli.resetearSospechosos();
        }
    }
}
