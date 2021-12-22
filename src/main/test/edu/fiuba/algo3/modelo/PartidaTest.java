package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Caso.Caso;
import edu.fiuba.algo3.modelo.Criminales.Accesorios.Joyas;
import edu.fiuba.algo3.modelo.Criminales.Caracteristica;
import edu.fiuba.algo3.modelo.Criminales.Caracteristicas;
import edu.fiuba.algo3.modelo.Criminales.Criminal;
import edu.fiuba.algo3.modelo.Criminales.Hobbies.Tenis;
import edu.fiuba.algo3.modelo.Criminales.Pelo.Castanio;
import edu.fiuba.algo3.modelo.Criminales.Sexo.SexoFemenino;
import edu.fiuba.algo3.modelo.Criminales.Vehiculo.Descapotable;
import edu.fiuba.algo3.modelo.Edificios.Banco;
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.Policia.Policia;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PartidaTest {
    Partida partida = Partida.getInstance();

    @BeforeEach
    public void setUp(){
        partida.resetearFiltros();
    }

    public PartidaTest() throws NoExisteError, IOException {
    }


    @Test
    public void filtrarSospechosos() {
        partida.filtrar(new SexoFemenino());
        partida.filtrar(new Tenis());
        partida.filtrar(new Castanio());
        partida.filtrar(new Joyas());
        partida.filtrar(new Descapotable());

        assertEquals(partida.cantidadSospechosos(), 1);
    }

    @Test
    public void cantidadDeSospechososArrancaEn10() {
        partida.resetearFiltros();
        assertEquals(partida.cantidadSospechosos(), 10);
    }

    @Test
    public void filtrosSeReseteanCorrectamente()  {
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
    public void noSeArrestaSiNoHayOrden() {
        partida.filtrar(new SexoFemenino());
        partida.filtrar(new Tenis());
        partida.filtrar(new Castanio());
        partida.filtrar(new Joyas());
        partida.filtrar(new Descapotable());

        Criminal atrapado = partida.arrestar();

        assertNull(atrapado);
    }

    @Test
    public void sePuedeArrestarConOrden() {
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
    public void visitarEdificioDevuelvePista() {
        Pista pista = partida.visitarEdificio(new Banco());
        Assert.assertEquals("Dijo que queria cambiar su dinero por Rublos", pista.darPista());

    }

    @Test
    public void resetRelojYobtenerMomento() {
        partida.resetearReloj();
        String fecha = partida.obtenerMomento().obtenerFecha();
        assertEquals("Lunes, 0hs.",fecha);
    }
}
