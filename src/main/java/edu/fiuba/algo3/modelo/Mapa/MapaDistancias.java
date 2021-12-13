package edu.fiuba.algo3.modelo.Mapa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class MapaDistancias {
    private final HashMap<String,Integer> dataDistPaises;

    public MapaDistancias(){
        dataDistPaises = new HashMap<>();
    }

    public int calcularDistanciaDeHasta(String nombrePaisOrigen, String nombrePaisDestino) throws FileNotFoundException {
        String rutaArchivoDistancias = "src/main/java/edu/fiuba/algo3/modelo/Resources/DistanciaPaises.txt";
        File archivoDistancias = new File(rutaArchivoDistancias);
        Scanner scanner = new Scanner(archivoDistancias);
        this.parsearDataDistancia(scanner);
        return calcularDistancia(nombrePaisOrigen,nombrePaisDestino,scanner);
    }

    private void parsearDataDistancia(Scanner scanner) {
        String[] clavePaises = scanner.nextLine().split("\\s+");
        int value = 0;
        for (String clave: clavePaises) {
            dataDistPaises.put(clave, value);
            value++;
        }
    }

    private int calcularDistancia(String nombrePaisOrigen, String nombrePaisDestino,Scanner scanner){
        String siguienteLinea = null;
        int claveOrigen = dataDistPaises.get(nombrePaisOrigen);
        int claveDestino = dataDistPaises.get(nombrePaisDestino);
        for (int i=0;i<=claveOrigen;i++){
            siguienteLinea = scanner.nextLine();
        }
        assert siguienteLinea != null;
        String[] distanciasPaisOrigen = siguienteLinea.split("\\s+");
        return Integer.parseInt(distanciasPaisOrigen[claveDestino]);
    }
}
