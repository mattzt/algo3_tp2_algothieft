package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Criminales.Accesorios.Joyas;
import edu.fiuba.algo3.modelo.Criminales.Criminal;
import edu.fiuba.algo3.modelo.Criminales.Hobbies.Tenis;
import edu.fiuba.algo3.modelo.Criminales.Pelo.Castanio;
import edu.fiuba.algo3.modelo.Criminales.Sexo.SexoFemenino;
import edu.fiuba.algo3.modelo.Criminales.Vehiculo.Descapotable;
import edu.fiuba.algo3.modelo.Edificios.Banco;
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Pistas.Pista;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PartidaTest {
    @Test
    public void filtrarSospechosos() throws NoExisteError, IOException {
        Partida partida = Partida.getInstance();
        partida.resetearFiltros();
        partida.filtrar(new SexoFemenino());
        partida.filtrar(new Tenis());
        partida.filtrar(new Castanio());
        partida.filtrar(new Joyas());
        partida.filtrar(new Descapotable());

        assertEquals(partida.cantidadSospechosos(), 1);
    }

    @Test
    public void cantidadDeSospechososArrancaEn10() throws NoExisteError, IOException {
        Partida partida = Partida.getInstance();
        partida.resetearFiltros();
        assertEquals(partida.cantidadSospechosos(), 10);
    }

    @Test
    public void filtrosSeReseteanCorrectamente() throws NoExisteError, IOException {
        Partida partida = Partida.getInstance();
        partida.resetearFiltros();

        partida.filtrar(new SexoFemenino());
        partida.filtrar(new Tenis());
        partida.filtrar(new Castanio());
        partida.filtrar(new Joyas());
        partida.filtrar(new Descapotable());

        assertEquals(partida.cantidadSospechosos(), 1);

        partida.resetearFiltros();

        assertEquals(partida.cantidadSospechosos(), 10);
    }

    @Test
    public void noSeArrestaSiNoHayOrden() throws NoExisteError, IOException {
        Partida partida = Partida.getInstance();
        partida.resetearFiltros();

        partida.filtrar(new SexoFemenino());
        partida.filtrar(new Tenis());
        partida.filtrar(new Castanio());
        partida.filtrar(new Joyas());
        partida.filtrar(new Descapotable());

        Criminal atrapado = partida.arrestar();

        assertNull(atrapado);
    }

    @Test
    public void sePuedeArrestarConOrden() throws NoExisteError, IOException {
        Partida partida = Partida.getInstance();
        partida.resetearFiltros();

        partida.filtrar(new SexoFemenino());
        partida.filtrar(new Tenis());
        partida.filtrar(new Castanio());
        partida.filtrar(new Joyas());
        partida.filtrar(new Descapotable());

        partida.emitirOrden();
        Criminal atrapado = partida.arrestar();

        assertNotNull(atrapado);
    }

    @Test
    public void visitarEdificioDevuelvePista() throws NoExisteError, IOException {
        Partida partida = Partida.getInstance();

        Pista pista = partida.visitarEdificio(new Banco());

        assertTrue(pista.darPista().equals("Dijo que queria cambiar su dinero por Rublos"));

    }

}
