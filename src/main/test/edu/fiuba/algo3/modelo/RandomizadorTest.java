package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Arma.Arma;
import edu.fiuba.algo3.modelo.Policia.Policia;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class RandomizadorTest {

    @Test
    public void randomNumber(){
        ArrayList<String> unArray = new ArrayList<>();
        for (int i=0;i<10;i++) unArray.add("unaPalabra");
        int unNumero = Randomizador.indiceRandom(unArray);
        Assertions.assertTrue(unNumero<unArray.size());
    }

    @Test
    public void devuelveArmaAlAzar(){
        Arma arma = Randomizador.armaRandom();
        Policia policia = new Policia();

        policia.recibirDanio(arma);

        assertNotEquals(policia.mirarLaHora(), 7);

    }

}