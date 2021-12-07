package edu.fiuba.algo3.modelo.Factory;

import edu.fiuba.algo3.modelo.Paises.Pais;
import edu.fiuba.algo3.modelo.Paises.Paises;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CreadorPaises implements Factory {

    @Override
    public Paises crear(String rutaArchivo) throws FileNotFoundException {
        File archivoData = new File(rutaArchivo);
        Scanner scanner = new Scanner(archivoData);
        Paises paises = new Paises();

        String encabezado = scanner.nextLine();
        while (scanner.hasNextLine()){
            String[] dataPaises = scanner.nextLine().split("\\s+");
            String nombrePais = dataPaises[0];
            String nombreCiudad = dataPaises[1];
            Pais nuevoPais = new Pais(nombrePais,nombreCiudad);
            paises.agregar(nuevoPais);
        }
        return paises;
    }
}
