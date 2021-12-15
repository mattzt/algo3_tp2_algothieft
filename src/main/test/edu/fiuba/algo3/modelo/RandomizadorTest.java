package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class RandomizadorTest {

    @Test
    public void randomNumber(){
        ArrayList<String> unArray = new ArrayList<>();
        for (int i=0;i<10;i++) unArray.add("unaPalabra");
        int unNumero = Randomizador.indiceRandom(unArray);
        Assertions.assertTrue(unNumero<unArray.size());
    }

}