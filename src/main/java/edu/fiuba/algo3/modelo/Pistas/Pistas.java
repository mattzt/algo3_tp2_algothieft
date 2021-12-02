package edu.fiuba.algo3.modelo.Pistas;

import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Personas.Agente;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Pistas {
    ArrayList<Pista> posiblesPistas;

    public Pistas(Agente agente) throws IOException {
        int arrestos = agente.cantidadArrestos();
        posiblesPistas = obtenerPistasDeDificultad(arrestos);
    }


    public Pista obtenerPistaPara(Edificio edificio){
        Iterator<Pista> iterador = posiblesPistas.iterator();
        Pista pistaActual = null;
        while(iterador.hasNext()){
            pistaActual = iterador.next();
            if(pistaActual.esTipo(edificio)){
                posiblesPistas.remove(pistaActual);
                break;
            }
        }
        return pistaActual;
    }


    public ArrayList<Pista> obtenerPistasDeDificultad(int arrestos) throws IOException {
        String rutas;
        if(arrestos < 5){
            rutas = "C:\\Users\\Agustin\\IdeaProjects\\algo3_tp2_algothieft\\src\\main\\java\\edu\\fiuba\\algo3\\modelo\\Resources\\PistasFaciles.txt";
        }
        else if(arrestos < 15){
            rutas = "C:\\Users\\Agustin\\IdeaProjects\\algo3_tp2_algothieft\\src\\main\\java\\edu\\fiuba\\algo3\\modelo\\Resources\\PistasMedios.txt";
        }
        else{
            rutas = "C:\\Users\\Agustin\\IdeaProjects\\algo3_tp2_algothieft\\src\\main\\java\\edu\\fiuba\\algo3\\modelo\\Resources\\PistasDificiles.txt";
        }
        return cargarPistasDificultad(rutas);
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
