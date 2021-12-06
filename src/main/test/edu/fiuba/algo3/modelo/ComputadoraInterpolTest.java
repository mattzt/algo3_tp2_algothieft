package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.modelo.ComputadoraInterpol.ComputadoraInterpol;
import org.junit.jupiter.api.Test;

public class ComputadoraInterpolTest {

    @Test
    public void createTest()
    {
        String rutaAtributos = "src/main/java/edu/fiuba/algo3/modelo/Resources/atributos.txt";
        ComputadoraInterpol compu = new ComputadoraInterpol(rutaAtributos);
    }


    @Test
    public void ingresarDatos()
    {
        String rutaAtributos = "src/main/java/edu/fiuba/algo3/modelo/Resources/atributos.txt";
        ComputadoraInterpol compu = new ComputadoraInterpol(rutaAtributos);
        compu.IngresarDatos();
    }
}