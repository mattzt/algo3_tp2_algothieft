package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Arma.Arma;
import edu.fiuba.algo3.modelo.Arma.ArmaDeFuego;
import edu.fiuba.algo3.modelo.ComputadoraInterpol.ComputadoraInterpol;
import edu.fiuba.algo3.modelo.Criminales.Sexo.SexoFemenino;
import edu.fiuba.algo3.modelo.Criminales.Sospechosos;
import edu.fiuba.algo3.modelo.Factory.CreadorCriminales;
import edu.fiuba.algo3.modelo.Mapa.Paises.Pais;
import edu.fiuba.algo3.modelo.Policia.Novato;
import edu.fiuba.algo3.modelo.Policia.Policia;
import edu.fiuba.algo3.modelo.Reloj.Martes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.text.MaskFormatter;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class PoliciaTest {

    private final Policia policia;

    public PoliciaTest() throws FileNotFoundException {
        policia = new Policia();
        CreadorCriminales factoryCriminales = new CreadorCriminales();
        Sospechosos sospechosos = factoryCriminales.crear("src/main/java/edu/fiuba/algo3/modelo/Resources/Sospechosos.txt");
        policia.setComputadora(new ComputadoraInterpol(sospechosos));
    }

    @BeforeEach
    public void setUp(){
        policia.setPaisEnDondeEstoy(new Pais("Francia", "Paris"));
    }

    @Test
    public void viajarAPais() throws FileNotFoundException {
        Pais egipto = new Pais("Egipto", "Cairo");

        policia.viajarApais(egipto);

        assertSame(policia.getPaisActual(), egipto);
    }

    @Test
    public void duermeYPasaElTiempo(){
        assertEquals(policia.mirarLaHora(), 7);
        avanzarHastaHoraDeDormir();

        assertEquals(policia.mirarLaHora(), 23);

        policia.dormir();

        assertEquals(policia.mirarLaHora(), 7);
        assertTrue(policia.mirarDia().equals(new Martes()));

    }

    private void avanzarHastaHoraDeDormir(){
        Arma arma = new ArmaDeFuego();
        policia.recibirDanio(arma);
        policia.recibirDanio(arma);
        policia.recibirDanio(arma);
        policia.recibirDanio(arma);
    }

    @Test
    public void sospechososSeReseteanCorrectamente(){
        policia.ingresarDato(new SexoFemenino());

        assertEquals(policia.cantidadSospechosos(), 5);

        policia.resetearSospechosos();

        assertEquals(policia.cantidadSospechosos(), 10);
    }

    @Test
    public void relojSeReseteaCorrectamente(){
        assertEquals(policia.mirarLaHora(), 7);

        policia.recibirDanio(new ArmaDeFuego());

        assertEquals(policia.mirarLaHora(), 11);

        policia.resetearReloj();

        assertEquals(policia.mirarLaHora(), 7);
    }

    @Test
    public void nombreSeSeteaCorrectamente(){
        policia.setNombre("Pepe");
        assertEquals("Pepe", policia.getNombre());
    }

    @Test
    public void rangoInicialEsNovato(){
        assertTrue(policia.getRango().es("Novato"));
    }
}
