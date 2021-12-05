package edu.fiuba.algo3.modelo.Paises;
import java.util.ArrayList;

public class Paises {
    private ArrayList<Pais> paises;

    public Paises() {
        paises = new ArrayList<>();
    }

    public void agregarPais(Pais nuevoPais) {
        paises.add(nuevoPais);
    }

    public Pais buscarPais(String nombrePais) throws PaisNoExisteError {
        for(Pais pais: paises){
            if (pais.equals(nombrePais)) return pais;
        }
        throw new PaisNoExisteError("El país no esta creado");
    }

    public int size() {
        return paises.size();
    }
}
