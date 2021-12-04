package edu.fiuba.algo3.modelo.Paises;

import edu.fiuba.algo3.modelo.Fachada.Fachada;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Paises {
    private ArrayList<Pais> paises;
    private Fachada creadorDePaises;

    public Paises() {
        paises = new ArrayList<>();
    }

    public void agregarPais(Pais nuevoPais) {
        paises.add(nuevoPais);
    }

    public Paises crearPaises() throws FileNotFoundException {
        return creadorDePaises.crearPaises();
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

    public void setCreadorDePaises(Fachada creadorDePaises) {
        this.creadorDePaises = creadorDePaises;
    }
}
