package edu.fiuba.algo3.modelo.Pistas;

import edu.fiuba.algo3.modelo.Edificios.Edificio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;

public class PistasMedio implements RangoPista{
    public PistasMedio(){
        File archivo = new File ("C:\\Users\\Agustin\\IdeaProjects\\algo3_tp2_algothieft\\src\\main\\java\\edu\\fiuba\\algo3\\modelo\\Resources\\PistasMedios.txt");
        FileReader fr = new FileReader (archivo);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        while((linea=br.readLine())!=null){
            pistas.add(linea)
        }

    }


    @Override
    public String obtenerPistaEdificio(Edificio edificio) {
        Iterator<String> iterador = pistas.iterator();
        while(iterador.hasNext()){
            String pistaActual = iterador.next();
            if(pistaActual.contains('**')){
                return pistaActual;
            }
        }
    }
}
