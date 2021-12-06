package edu.fiuba.algo3.modelo.ComputadoraInterpol;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class ComputadoraInterpolTest {

    @Test
    public void createTest()
    {
        String rutaAtributos = "E:\\atributos.txt";
        ComputadoraInterpol compu = new ComputadoraInterpol(rutaAtributos);
    }


    @Test
    void ingresarDatos()
    {
        String rutaAtributos = "E:\\atributos.txt";
        ComputadoraInterpol compu = new ComputadoraInterpol(rutaAtributos);
        compu.IngresarDatos();
    }
}