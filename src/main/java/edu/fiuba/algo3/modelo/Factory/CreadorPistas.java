package edu.fiuba.algo3.modelo.Factory;

import edu.fiuba.algo3.modelo.Criminales.Caracteristicas;
import edu.fiuba.algo3.modelo.Criminales.Criminal;
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
            if (pistaAeropuerto != "null") {pistas.add(new PistaAeropuerto(pistaPais, pistaAeropuerto));}
            if (pistaBanco != "null") {pistas.add(new PistaBanco(pistaPais, pistaBanco));}
            if (pistaBolsa != "null") {pistas.add(new PistaBolsa(pistaPais, pistaBolsa));}
            if (pistaPuerto != "null") {pistas.add(new PistaAeropuerto(pistaPais, pistaPuerto));}
            if (pistaBiblioteca != "null") {pistas.add(new PistaCaracteristicasCriminal(pistaPais, pistaBiblioteca));}
        }
        return pistas;
    }

}
