package edu.fiuba.algo3.modelo.Paises;

import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Listas.Listable;

import java.util.ArrayList;

public class Paises implements Listable {
    private final ArrayList<Pais> paises;

    public Paises() {
        paises = new ArrayList<>();
    }

    public void agregar(Pais nuevoPais) {
        paises.add(nuevoPais);
    }

    public Pais buscar(String nombrePais) throws NoExisteError {
        for(Pais pais: paises){
            if (pais.equals(nombrePais)) return pais;
        }
        throw new NoExisteError("El país no esta creado");
    }

    public int size() {
        return paises.size();
    }
}
