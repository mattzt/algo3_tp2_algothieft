package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Criminales.Accesorios.Accesorios;
import edu.fiuba.algo3.modelo.Criminales.Accesorios.Tatuaje;
import edu.fiuba.algo3.modelo.Criminales.Caracteristicas;
import edu.fiuba.algo3.modelo.Criminales.Hobbies.Hobbies;
import edu.fiuba.algo3.modelo.Criminales.Hobbies.Tenis;
import edu.fiuba.algo3.modelo.Criminales.Pelo.Rubio;
import edu.fiuba.algo3.modelo.Criminales.Sexo.SexoFemenino;
import edu.fiuba.algo3.modelo.Criminales.Sospechosos;
import edu.fiuba.algo3.modelo.Criminales.Vehiculo.Limusina;
import edu.fiuba.algo3.modelo.Factory.CreadorCaracteristicas;
import edu.fiuba.algo3.modelo.Factory.CreadorCriminales;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class CriminalTest {
    CreadorCriminales creadorCriminales = new CreadorCriminales();
    Sospechosos listaCriminales = creadorCriminales.crear("src/main/java/edu/fiuba/algo3/modelo/Resources/sospechosos.txt");

    public CriminalTest() throws FileNotFoundException {
    }

    @Test
    public void testSeCreanCriminales(){
        Assertions.assertEquals(10,listaCriminales.size());
    }

    @Test
    public void testfiltrarCriminales(){
        CreadorCaracteristicas creadorCaracteristicas = new CreadorCaracteristicas();
        SexoFemenino sexoFemenino = new SexoFemenino();
        Rubio peloRubio = new Rubio();
        Hobbies tenis = new Tenis();
        Accesorios tatuaje = new Tatuaje();
        Limusina limusina = new Limusina();
        Caracteristicas caracteristicasBuscadas = new Caracteristicas(sexoFemenino,peloRubio,tenis,tatuaje,limusina);
        Sospechosos listaFiltrada = listaCriminales.cumplenConCaracteristicas(caracteristicasBuscadas);
        Assertions.assertEquals(1,listaFiltrada.size());
    }
}
