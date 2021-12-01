package edu.fiuba.algo3.modelo.Pistas;

import edu.fiuba.algo3.modelo.Personas.Agente;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

public class BaseDatosPistas {
    ArrayList<String> posiblesPistas;

    public BaseDatosPistas(Agente agente){
        int arrestos = agente.cantidadArrestos();
        posiblesPistas = obtenerPistasDeDificultad(arrestos);
    }

    public String buscarPista(String buscado){
        Iterator<String> iterador = posiblesPistas.iterator();
        String pistaActual = "";
        while(iterador.hasNext()){
            String pistaActual = iterador.next();
            if(pistaActual.contains(buscado)){
                pistaActual = pistaActual.replace(buscado, "");
                posiblesPistas.remove(String pistaActual);
                break;
            }
        }
        return pistaActual;
    }

    public ArrayList<String> obtenerPistasDeDificultad(int arrestos){
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

    private ArrayList<String> cargarPistasDificultad(String ruta){
        ArrayList<String> pistas = new ArrayList<>();
        File archivo = new File (ruta);
        FileReader fr = new FileReader (archivo);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        while((linea=br.readLine())!=null){
            pistas.add(linea);
        }
        return pistas;
    }

}
