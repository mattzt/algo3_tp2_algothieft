package edu.fiuba.algo3.modelo.Factory;

import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Paises.Pais;
import edu.fiuba.algo3.modelo.Paises.Paises;
import edu.fiuba.algo3.modelo.Pistas.*;
import edu.fiuba.algo3.modelo.Policia.Policia;
import edu.fiuba.algo3.modelo.Policia.Rango;

import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;


public class CreadorPistas implements Factory{


    @Override
    public RepositorioPistas crear(String rutaArchivo) throws IOException {
        ArrayList<Pista> posiblesPistas = cargarPistas(rutaArchivo);
        return new RepositorioPistas(posiblesPistas);
    }

    private ArrayList<Pista> cargarPistas(String ruta) throws IOException {
        ArrayList<Pista> pistas = new ArrayList<>();
        File archivo = new File (ruta);
        FileReader fr = new FileReader (archivo);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        while((linea=br.readLine())!=null){
            Pista nueva = crearPistaSegunLinea(linea);
            pistas.add(nueva);
        }
        return pistas;
    }

    private Pista crearPistaSegunLinea(String linea){
        Pista resultado = null;
        if(linea.contains("|AEROPUERTO|")){
            resultado = new PistaAeropuerto(linea);
        } else if(linea.contains("|BANCO|")){
            resultado = new PistaBanco(linea);
        } else if(linea.contains("|BIBLIOTECA|")){
            resultado = new PistaBiblioteca(linea);
        } else if(linea.contains("|BOLSA|")){
            resultado = new PistaBolsa(linea);
        } else if(linea.contains("|PUERTO|")){
            resultado = new PistaPuerto(linea);
        }
        return resultado;
    }
}
