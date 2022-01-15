package edu.fiuba.algo3.modelo.Factory;

import edu.fiuba.algo3.modelo.Edificios.*;
import edu.fiuba.algo3.modelo.Mapa.Paises.Pais;
import edu.fiuba.algo3.modelo.Mapa.Paises.Paises;

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
            Edificios edificios = crearEdificios();
            String[] dataPaises = scanner.nextLine().split("\\s+");
            String nombrePais = dataPaises[0];
            String nombreCiudad = dataPaises[1];
            Pais nuevoPais = new Pais(nombrePais,nombreCiudad);
            nuevoPais.setEdificios(edificios);
            paises.agregar(nuevoPais);
        }
        paises.setPaisesConexos();
        return paises;
    }

    private Edificios crearEdificios(){
        Edificios edificiosDelPais = new Edificios();
        edificiosDelPais.agregar(new Aeropuerto());
        edificiosDelPais.agregar(new Banco());
        edificiosDelPais.agregar(new Biblioteca());
        edificiosDelPais.agregar(new Bolsa());
        edificiosDelPais.agregar(new Puerto());

        return edificiosDelPais;
    }
}
