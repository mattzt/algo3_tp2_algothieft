package edu.fiuba.algo3.modelo.Fachada;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Fachada {
    private HashMap<String,Integer> dataDistPaises;

    public Fachada(){
        dataDistPaises = new HashMap<>();
    }

    public int calcularDistanciaDeHasta(String nombrePaisOrigen, String nombrePaisDestino) throws FileNotFoundException {
        int distancia = 0;
        String rutaArchivoDistancias = "src/main/java/edu/fiuba/algo3/modelo/Resources/DistanciaPaises.txt";
        File archivoDistancias = new File(rutaArchivoDistancias);
        Scanner scanner = new Scanner(archivoDistancias);
        this.parsearData(scanner);
        String siguienteLinea = null;

        int lineas = 0;
        int claveOrigen = dataDistPaises.get(nombrePaisOrigen);
        int claveDestino = dataDistPaises.get(nombrePaisDestino);
        for (int i=0;i<=claveOrigen;i++){
            siguienteLinea = scanner.nextLine();
        }
        assert siguienteLinea != null;
        String[] distanciasPaisOrigen = siguienteLinea.split("\\s+");
        return Integer.parseInt(distanciasPaisOrigen[claveDestino]);
    }

    private void parsearData(Scanner scanner) {
        String[] clavePaises = scanner.nextLine().split("\\s+");
        int value = 0;
        for (String clave: clavePaises) {
            dataDistPaises.put(clave, value);
            value++;
        }
    }
}
