package edu.fiuba.algo3.modelo.Factory;


import edu.fiuba.algo3.modelo.Caso.ObjetosValiosos;
import edu.fiuba.algo3.modelo.Caso.Objeto;
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Paises.Pais;
import edu.fiuba.algo3.modelo.Paises.Paises;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CreadorObjetos implements Factory{
    Paises listaDePaises;

    public CreadorObjetos(Paises listaDePaises){
        this.listaDePaises = listaDePaises;
    }

    @Override
    public ObjetosValiosos crear(String rutaArchivo) throws FileNotFoundException, NoExisteError {
        File archivoData = new File(rutaArchivo);
        Scanner scanner = new Scanner(archivoData);
        ObjetosValiosos listaObjetos = new ObjetosValiosos();

        String encabezado = scanner.nextLine();
        while (scanner.hasNextLine()) {
            String[] dataObjetos = scanner.nextLine().split(",");
            String nombreObjeto = dataObjetos[0];
            Pais paisOrigen = listaDePaises.buscar(dataObjetos[1]);
            int valor = Integer.parseInt(dataObjetos[2]);
            Objeto nuevoObjeto = new Objeto(nombreObjeto,paisOrigen,valor);
            listaObjetos.agregar(nuevoObjeto);
        }
        return listaObjetos;
    }
}
