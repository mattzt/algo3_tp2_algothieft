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
            String pistaCaracteristica = dataPista[5];
            Pista nueva = null;
            if (pistaAeropuerto != null) {nueva = new PistaAeropuerto(pistaPais, pistaAeropuerto);}
            if (pistaBanco != null) {nueva = new PistaBanco(pistaPais, pistaBanco);}
            if (pistaAeropuerto != null) {nueva = new PistaAeropuerto(pistaPais, pistaAeropuerto);}
            if (pistaBolsa != null) {nueva = new PistaBolsa(pistaPais, pistaBolsa);}
            if (pistaPuerto != null) {nueva = new PistaAeropuerto(pistaPais, pistaPuerto);}
            if (pistaCaracteristica != null) {nueva = new PistaCaracteristicasCriminal(pistaPais, pistaCaracteristica);}
            pistas.add(nueva);
        }
        return pistas;
    }

}
