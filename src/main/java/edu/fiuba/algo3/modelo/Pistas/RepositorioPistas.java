package edu.fiuba.algo3.modelo.Pistas;

import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Policia.Policia;
import edu.fiuba.algo3.modelo.Policia.Rango;

import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

public class RepositorioPistas {
    ArrayList<Pista> posiblesPistas;
    Hashtable<String, String> rutasDeArchivosPistas = new Hashtable();


    public RepositorioPistas(Policia policia) throws IOException {
        Rango rango = policia.presentarPlaca();
        rutasDeArchivosPistas.put("FACIL","src/main/java/edu/fiuba/algo3/modelo/Resources/PistasFaciles.txt" );
        rutasDeArchivosPistas.put("NORMAL","src/main/java/edu/fiuba/algo3/modelo/Resources/PistasMedios.txt");
        rutasDeArchivosPistas.put("DIFICIL","src/main/java/edu/fiuba/algo3/modelo/Resources/PistasDificiles.txt");
        posiblesPistas = obtenerPistasDeDificultad(rango);
    }


    public Pista obtenerPistaPara(Edificio edificio){
        Iterator<Pista> iterador = posiblesPistas.iterator();
        Pista pistaActual = null;
        while(iterador.hasNext()){
            pistaActual = iterador.next();
            if(pistaActual.esTipo(edificio)){
//                posiblesPistas.remove(pistaActual);
                break;
            }
        }
        return pistaActual;
    }


    public ArrayList<Pista> obtenerPistasDeDificultad(Rango rango) throws IOException {
        return cargarPistasDificultad(rutasDeArchivosPistas.get(rango.toString()));
    }

    private ArrayList<Pista> cargarPistasDificultad(String ruta) throws IOException {
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
