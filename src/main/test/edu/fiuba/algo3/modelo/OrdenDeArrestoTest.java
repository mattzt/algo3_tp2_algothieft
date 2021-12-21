package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.ComputadoraInterpol.ComputadoraInterpol;
import edu.fiuba.algo3.modelo.Criminales.Accesorios.Joyas;
import edu.fiuba.algo3.modelo.Criminales.Hobbies.Tenis;
import edu.fiuba.algo3.modelo.Criminales.Pelo.Castanio;
import edu.fiuba.algo3.modelo.Criminales.Sexo.SexoFemenino;
import edu.fiuba.algo3.modelo.Criminales.Vehiculo.Descapotable;
import edu.fiuba.algo3.modelo.Factory.CreadorCriminales;
import edu.fiuba.algo3.modelo.Mapa.Paises.Pais;
import edu.fiuba.algo3.modelo.Policia.Policia;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrdenDeArrestoTest {
    private Policia policia;

    @Before
    public void init() throws FileNotFoundException {
        CreadorCriminales creadorCriminales = new CreadorCriminales();
        ComputadoraInterpol computadora = new ComputadoraInterpol(creadorCriminales.crear("src/main/java/edu/fiuba/algo3/modelo/Resources/sospechosos.txt"));
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

        String resultado = policia.arrestar();

        assertEquals(resultado, "Arrestaste al criminal!" + " El criminal era Carmen Sandiego");

    }
}
