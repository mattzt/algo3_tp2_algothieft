package edu.fiuba.algo3.modelo.Caso;
import edu.fiuba.algo3.modelo.Mapa.Paises.Pais;
import edu.fiuba.algo3.modelo.Mapa.Paises.Paises;
import edu.fiuba.algo3.modelo.Policia.Policia;
import edu.fiuba.algo3.modelo.Policia.Rango;
import edu.fiuba.algo3.modelo.Criminales.Criminal;
import edu.fiuba.algo3.modelo.Criminales.Sospechosos;

import java.util.ArrayList;
import java.util.Iterator;

public class Caso {
    private final Criminal ladron;
    private Policia policia;
    private Objeto objetoRobado;
    private ArrayList<Pais> rutaDeEscape;



    public Caso (Sospechosos listaDeSospechosos, ObjetosValiosos listaDeObjetos, Paises listaDePaises, Rango rangoPolicia){
        ladron = listaDeSospechosos.elegirCriminalAleatorio();
        objetoRobado = listaDeObjetos.robarObjetoPorNivel(rangoPolicia);
        rutaDeEscape = listaDePaises.elegirRutaDeEscapePorNivel(objetoRobado.paisDeOrigen(), objetoRobado.cantidadDePaisesDeEscape());
    }



    public void asignarCasoAPolicia(Policia nuevoPoli) {
        policia = nuevoPoli;
    }

    public Criminal getCriminal(){
        return ladron;
    }

    public Pais siguientePais() {
        Pais siguiente = null;
        Iterator<Pais> iter = rutaDeEscape.iterator();
        while (iter.hasNext()) {
            if (policia.getPaisActual()==iter.next()){
                siguiente = iter.next();
            }
        }
        return siguiente;
    }
}
