package edu.fiuba.algo3.modelo.Paises;

import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Edificios.Edificios;
import edu.fiuba.algo3.modelo.Fachada.Fachada;
import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.Pistas.Pistas;

import java.io.FileNotFoundException;

public class Pais {
    private String nombre;
    private String ciudadDestacada;
    private Paises paisesConexos;
    private Edificios edificiosPublicos;
    private Fachada calcDist;

    public Pais(String nombrePais, String nombreCiudadDestacada){
        nombre = nombrePais;
        ciudadDestacada = nombreCiudadDestacada;
    }

    public int distanciaA(Pais otroPais) throws FileNotFoundException {
            String nombrePaisDestino = otroPais.getNombre();
            return calcDist.calcularDistanciaDeHasta(nombre,nombrePaisDestino);
    }

    public Pista visitarEdificio(Edificio unEdificio, Pistas pistas){
        return unEdificio.visitar(pistas);
    }

    public String getNombre() {
        return nombre;
    }

    public void setPaisesConexos(Paises conjuntoDePaises){
        paisesConexos = conjuntoDePaises;
    }

    public void setEdificios(Edificios edificios){
        edificiosPublicos = edificios;
    }

    public void setCalculadoraDistancia(Fachada unaCalculadora){
        calcDist = unaCalculadora;
    }

    public Edificios getEdificios() {
        return edificiosPublicos;
    }

    public Paises getPaisesConexos() {
        return paisesConexos;
    }

    public boolean equals(String unNombre){
        return nombre.equals(unNombre);
    }
}
