package edu.fiuba.algo3.modelo.Pistas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class pistaDificultad {

    public ArrayList<String> obtenerPistasDeDificultad(int arrestos){
        String rutas;
        if(arrestos < 5){
            rutas = "../Resources/PistasFaciles.txt";
        }
        else if(arrestos < 15){
            rutas = "../Resources/PistasMedios.txt";
        }
        else{
            rutas = "../Resources/PistasDificiles.txt";
        }
        return cargarPistasDificultad(rutas);
    }

    private ArrayList<String> cargarPistasDificultad(String ruta){
        ArrayList<String> pistas = new ArrayList<>();
        File archivo = new File(ruta);
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        while((linea = br.readLine()) != null){
            pistas.add(linea);
        }
        return pistas;
    }

}
