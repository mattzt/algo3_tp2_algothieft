package edu.fiuba.algo3.modelo.Factory;

import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Listable;

import java.io.IOException;

public interface Factory {
    Listable crear(String rutaArchivo) throws IOException, NoExisteError;
}
