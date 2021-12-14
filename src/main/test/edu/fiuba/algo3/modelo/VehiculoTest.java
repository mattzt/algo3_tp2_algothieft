package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Criminales.Vehiculo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class VehiculoTest {

    @Test
    public void deportivoTest(){
        Deportivo deportivo = new Deportivo();
        assertTrue(deportivo.equals(new Deportivo()));
    }

    @Test
    public void descapotableTest(){
        Descapotable descapotable = new Descapotable();
        assertTrue(descapotable.equals(new Descapotable()));
    }

    @Test
    public void limusinaTest(){
        Limusina limusina = new Limusina();
        assertTrue(limusina.equals(new Limusina()));
    }

    @Test
    public void motoTest(){
        Moto moto = new Moto();
        assertTrue(moto.equals(new Moto()));
    }
}
