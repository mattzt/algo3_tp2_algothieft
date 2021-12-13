package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Vehiculo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VehiculoTest {

    @Test
    public void deportivoTest(){
        Deportivo deportivo = new Deportivo();
        assertEquals("Deportivo", deportivo.valor());
    }

    @Test
    public void descapotableTest(){
        Descapotable descapotable = new Descapotable();
        assertEquals("Descapotable", descapotable.valor());
    }

    @Test
    public void limusinaTest(){
        Limusina limusina = new Limusina();
        assertEquals("Limusina", limusina.valor());
    }

    @Test
    public void motoTest(){
        Moto moto = new Moto();
        assertEquals("Moto", moto.valor());
    }
}
