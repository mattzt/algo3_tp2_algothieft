package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Arma.Arma;
import edu.fiuba.algo3.modelo.Arma.ArmaBlanca;
import edu.fiuba.algo3.modelo.Arma.ArmaDeFuego;

import java.util.ArrayList;
import java.util.Random;

public class Randomizador {

    public static int indiceRandom(ArrayList<?> unaLista){
        Random randomize = new Random();
        return randomize.nextInt(unaLista.size());
    }

    public static Arma armaRandom(){
        Random random = new Random();
        int numero = random.nextInt();

        if(numero % 2 == 0)
            return new ArmaBlanca();

        return new ArmaDeFuego();
    }
}
