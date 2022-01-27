package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.ComputadoraInterpol.ComputadoraInterpol;
import edu.fiuba.algo3.modelo.ComputadoraInterpol.Emitida;
import edu.fiuba.algo3.modelo.ComputadoraInterpol.NoEmitida;
import edu.fiuba.algo3.modelo.ComputadoraInterpol.OrdenDeArresto;
import edu.fiuba.algo3.modelo.Criminales.Accesorios.Joyas;
import edu.fiuba.algo3.modelo.Criminales.Caracteristicas;
import edu.fiuba.algo3.modelo.Criminales.Criminal;
import edu.fiuba.algo3.modelo.Criminales.Hobbies.Tenis;
import edu.fiuba.algo3.modelo.Criminales.Pelo.Castanio;
import edu.fiuba.algo3.modelo.Criminales.Sexo.SexoFemenino;
import edu.fiuba.algo3.modelo.Criminales.Vehiculo.Descapotable;
import edu.fiuba.algo3.modelo.Factory.CreadorCriminales;
import edu.fiuba.algo3.modelo.Policia.Policia;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class OrdenDeArrestoTest {
    private Policia policia;

    @Before
    public void init() throws FileNotFoundException {
        CreadorCriminales creadorCriminales = new CreadorCriminales();
        ComputadoraInterpol computadora = new ComputadoraInterpol(creadorCriminales.crear("src/main/java/edu/fiuba/algo3/modelo/Resources/Sospechosos.txt"));
        policia = new Policia();
        policia.setComputadora(computadora);
    }

    private void reducirSospechosos(){
        policia.ingresarDato(new SexoFemenino());
        policia.ingresarDato(new Descapotable());
        policia.ingresarDato(new Tenis());
        policia.ingresarDato(new Castanio());
        policia.ingresarDato(new Joyas());
    }

    @Test
    public void arrestarConOrdenEmitida(){
        reducirSospechosos();

        policia.emitirOrdenArresto();

        Criminal resultado = policia.arrestar();

        Caracteristicas caracteristicas = new Caracteristicas(null, null, null, null,null);

        Criminal carmen = new Criminal("Carmen Sandiego", caracteristicas);

        assertTrue(resultado.equals(carmen));

    }

    @Test
    public void equalsNoEmitida(){
        NoEmitida noEmitida = new NoEmitida();

        assertTrue(noEmitida.equals(new NoEmitida()));
    }

    @Test
    public void equalsEmitida(){
        Emitida emitida = new Emitida();

        assertTrue(emitida.equals(new Emitida()));
    }

    @Test
    public void noSePuedeEmitirOrdenSiYaFueEmitida(){
        OrdenDeArresto emitida = new Emitida();

        assertFalse(emitida.sePuedeEmitirOrden());
    }

    @Test
    public void siNoFueEmitidaSePuedeEmitir(){
        OrdenDeArresto noEmitida = new NoEmitida();

        assertTrue(noEmitida.sePuedeEmitirOrden());
    }

    @Test
    public void nombresNoSonNulos(){
        OrdenDeArresto emitida = new Emitida();
        OrdenDeArresto noEmitida = new NoEmitida();

        assertNotNull(emitida.nombre());
        assertNotNull(noEmitida.nombre());
    }
}
