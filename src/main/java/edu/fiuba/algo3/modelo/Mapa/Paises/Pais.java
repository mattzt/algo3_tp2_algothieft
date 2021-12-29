package edu.fiuba.algo3.modelo.Mapa.Paises;

import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Edificios.Edificios;
import edu.fiuba.algo3.modelo.Mapa.MapaDistancias;
import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.Pistas.RepositorioPistas;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Pais {
    private final String nombre;
    private final String ciudadDestacada;
    private Paises paisesConexos;
    private Edificios edificiosPublicos;

    public Pais(String nombrePais, String nombreCiudadDestacada){
        nombre = nombrePais;
        ciudadDestacada = nombreCiudadDestacada;
        paisesConexos = new Paises();
    }

    public int distanciaA(Pais otroPais) throws FileNotFoundException {
            String nombrePaisDestino = otroPais.getNombre();
            MapaDistancias mapaDistancias = new MapaDistancias();
            return mapaDistancias.calcularDistanciaDeHasta(nombre,nombrePaisDestino);
    }

    public Pista visitarEdificio(Edificio unEdificio, RepositorioPistas pistas){
        return edificiosPublicos.visitarEdificio(unEdificio, pistas);
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

    public int cantidadDePaisesConexos(){
        return paisesConexos.size();
    }

    public boolean equals(Pais unPais){
        String unNombre = unPais.getNombre();
        return nombre.equals(unNombre) || ciudadDestacada.equals(unNombre);
    }

    public void agregarPaisConexo(Pais pais) {
        paisesConexos.agregar(pais);
    }

    public boolean puedeAgregarConexos() {
        return paisesConexos.size()<3;
    }

    public int visitasTotales(){

        return edificiosPublicos.visitasTotales();
    }
}
