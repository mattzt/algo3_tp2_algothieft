package edu.fiuba.algo3.modelo.Mapa.Paises;

import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Edificios.Edificios;
import edu.fiuba.algo3.modelo.Mapa.MapaDistancias;
import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.Pistas.RepositorioPistas;

import java.io.FileNotFoundException;

public class Pais {
    private String nombre;
    private String ciudadDestacada;
    private Paises paisesConexos;
    private Edificios edificiosPublicos;

    public Pais(String nombrePais, String nombreCiudadDestacada){
        nombre = nombrePais;
        ciudadDestacada = nombreCiudadDestacada;
    }

    public int distanciaA(Pais otroPais) throws FileNotFoundException {
            String nombrePaisDestino = otroPais.getNombre();
            MapaDistancias mapaDistancias = new MapaDistancias();
            return mapaDistancias.calcularDistanciaDeHasta(nombre,nombrePaisDestino);
    }

    public Pista visitarEdificio(Edificio unEdificio, RepositorioPistas pistas){
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

    public Edificios getEdificios() {
        return edificiosPublicos;
    }

    public Paises getPaisesConexos() {
        return paisesConexos;
    }

    public boolean equals(String unNombre){
        return nombre.equals(unNombre) || ciudadDestacada.equals(unNombre);
    }
}
