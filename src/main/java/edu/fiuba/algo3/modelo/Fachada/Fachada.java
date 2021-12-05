package edu.fiuba.algo3.modelo.Fachada;

import edu.fiuba.algo3.modelo.Paises.Pais;
import edu.fiuba.algo3.modelo.Paises.Paises;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Fachada {
    private final HashMap<String,Integer> dataDistPaises;

    public Fachada(){
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

    public Paises crearPaises() throws FileNotFoundException {
        String rutaArchivoData = "src/main/java/edu/fiuba/algo3/modelo/Resources/DataPaises.txt";
        File archivoData = new File(rutaArchivoData);
        Scanner scanner = new Scanner(archivoData);
        Paises paises = new Paises();

        String encabezado = scanner.nextLine();
        while (scanner.hasNextLine()){
            String[] dataPaises = scanner.nextLine().split("\\s+");
            String nombrePais = dataPaises[0];
            String nombreCiudad = dataPaises[1];
            Pais nuevoPais = new Pais(nombrePais,nombreCiudad);
            paises.agregarPais(nuevoPais);
        }
        return paises;
    }
}
