package edu.fiuba.algo3.modelo.Factory;

import edu.fiuba.algo3.modelo.Listable;
import edu.fiuba.algo3.modelo.Pistas.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class CreadorPistas implements Factory{

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

            pistas.add(new PistaAeropuerto(pistaPais, pistaAeropuerto));
            pistas.add(new PistaBanco(pistaPais, pistaBanco));
            pistas.add(new PistaBolsa(pistaPais, pistaBolsa));
            pistas.add(new PistaPuerto(pistaPais, pistaPuerto));
            pistas.add(new PistaBiblioteca(pistaPais, pistaBiblioteca));
        }
        return pistas;
    }

}
