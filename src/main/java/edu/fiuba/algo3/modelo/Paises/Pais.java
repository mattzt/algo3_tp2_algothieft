package edu.fiuba.algo3.modelo.Paises;

import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Edificios.Edificios;
import edu.fiuba.algo3.modelo.Fachada.Fachada;
import edu.fiuba.algo3.modelo.Pistas.Pista;

public class Pais {
    private String nombre;
    private String capital;
    private Paises paisesConexos;
    private Edificios edificiosPublicos;
    private Fachada calcDist;

    public Pais(String nombrePais, String nombreCapital){
        nombre = nombrePais;
        capital = nombreCapital;
    }

    public int distanciaA(Pais otroPais){
            String nombrePaisDestino = otroPais.getNombre();
            return calcDist.calcularDistanciaDeHasta(nombre,nombrePaisDestino);
    }

    public Pista visitarEdificio(Edificio unEdificio){
        return unEdificio.visitar();
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
    };

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
