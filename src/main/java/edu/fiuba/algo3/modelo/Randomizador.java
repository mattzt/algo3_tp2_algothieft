package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Random;

public class Randomizador {

    public static int indiceRandom(ArrayList<?> unaLista){
        Random randomize = new Random();
        return randomize.nextInt(unaLista.size());
    }
}
