package edu.fiuba.algo3.modelo.Factory;

import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Listas.Listable;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Factory {
    Listable crear(String rutaArchivo) throws IOException, NoExisteError;
}
