package edu.fiuba.algo3.modelo.Factory;

import edu.fiuba.algo3.modelo.Caso.Caso;
import edu.fiuba.algo3.modelo.Listable;
import edu.fiuba.algo3.modelo.Pistas.*;
import edu.fiuba.algo3.modelo.Randomizador;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


public class CreadorPistas implements Factory{

    private ArrayList<String> pistasCaracteristicas;

    public CreadorPistas(Caso caso){
        pistasCaracteristicas = caso.pistasDelCriminal();
    }

    @Override
    public Listable crear(String rutaArchivo) throws IOException {
        ArrayList<Pista> posiblesPistas = cargarPistas(rutaArchivo);
        return new RepositorioPistas(posiblesPistas);
    }

    private ArrayList<Pista> cargarPistas(String ruta) throws IOException {
        ArrayList<Pista> pistas = new ArrayList<>();
        File archivo = new File (ruta);
        Scanner scanner = new Scanner(archivo);
        while (scanner.hasNextLine()){
            String[] dataPista = scanner.nextLine().split(",");
            String pistaPais = dataPista[0];
            String pistaAeropuerto = dataPista[1];
            String pistaBanco = dataPista[2];
            String pistaBolsa = dataPista[3];
            String pistaPuerto = dataPista[4];
            String pistaBiblioteca = dataPista[5];

            int indice;

            if (Objects.equals(pistaAeropuerto, "null")){
                indice = Randomizador.indiceRandom(pistasCaracteristicas);
                pistaAeropuerto = pistasCaracteristicas.get(indice);
            }
            pistas.add(new PistaAeropuerto(pistaPais, pistaAeropuerto));

            if (Objects.equals(pistaBanco, "null")){
                indice = Randomizador.indiceRandom(pistasCaracteristicas);
                pistaBanco = pistasCaracteristicas.get(indice);
            }
            pistas.add(new PistaBanco(pistaPais, pistaBanco));

            if (Objects.equals(pistaBolsa, "null")){
                indice = Randomizador.indiceRandom(pistasCaracteristicas);
                pistaBolsa = pistasCaracteristicas.get(indice);
            }
            pistas.add(new PistaBolsa(pistaPais, pistaBolsa));

            if (Objects.equals(pistaPuerto, "null")){
                indice = Randomizador.indiceRandom(pistasCaracteristicas);
                pistaPuerto = pistasCaracteristicas.get(indice);
            }
            pistas.add(new PistaPuerto(pistaPais, pistaPuerto));

            if (Objects.equals(pistaBiblioteca, "null")){
                indice = Randomizador.indiceRandom(pistasCaracteristicas);
                pistaBiblioteca = pistasCaracteristicas.get(indice);
            }
            pistas.add(new PistaBiblioteca(pistaPais, pistaBiblioteca));

        }
        return pistas;
    }

}
