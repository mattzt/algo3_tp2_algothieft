package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Criminales.Accesorios.Tatuaje;
import edu.fiuba.algo3.modelo.Criminales.Criminal;
import edu.fiuba.algo3.modelo.Criminales.Hobbies.Tenis;
import edu.fiuba.algo3.modelo.Criminales.Pelo.Rubio;
import edu.fiuba.algo3.modelo.Criminales.Sexo.SexoFemenino;
import edu.fiuba.algo3.modelo.Criminales.Sospechosos;
import edu.fiuba.algo3.modelo.Criminales.Vehiculo.Limusina;
import edu.fiuba.algo3.modelo.Factory.CreadorCriminales;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class CriminalTest {
    CreadorCriminales creadorCriminales = new CreadorCriminales();
    Sospechosos listaCriminales = creadorCriminales.crear("src/main/java/edu/fiuba/algo3/modelo/Resources/Sospechosos.txt");

    public CriminalTest() throws FileNotFoundException {
    }

    @Test
    public void testSeCreanCriminales(){
        Assertions.assertEquals(10,listaCriminales.size());
    }

    @Test
    public void testfiltrarCriminales(){
        Sospechosos listaFiltrada;
        listaFiltrada = listaCriminales.filtrar(new SexoFemenino());
        listaFiltrada = listaFiltrada.filtrar(new Rubio());
        listaFiltrada = listaFiltrada.filtrar(new Tenis());
        listaFiltrada = listaFiltrada.filtrar(new Tatuaje());
        listaFiltrada = listaFiltrada.filtrar(new Limusina());

        Assertions.assertEquals(1,listaFiltrada.size());
    }

    @Test
    public void testElegirCriminalAleatorio(){
        Criminal unCriminal = listaCriminales.elegirCriminalAleatorio();
        Criminal unCriminal2 = listaCriminales.elegirCriminalAleatorio();
        while (unCriminal.equals(unCriminal2)){
            unCriminal2 = listaCriminales.elegirCriminalAleatorio();
        }
        Assertions.assertFalse(unCriminal.es(unCriminal2));
    }

    @Test
    public void testArrestarTeniendoVariasOpciones(){
        listaCriminales.resetear();
        Sospechosos listaFiltrada = listaCriminales.filtrar(new Rubio());
        Assertions.assertNull(listaFiltrada.arrestar());
    }
}
