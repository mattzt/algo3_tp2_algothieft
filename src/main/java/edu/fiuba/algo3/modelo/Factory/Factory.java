package edu.fiuba.algo3.modelo.Factory;

import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Listas.Listable;

import java.io.FileNotFoundException;

public interface Factory {
    Listable crear(String rutaArchivo) throws FileNotFoundException, NoExisteError;
}
