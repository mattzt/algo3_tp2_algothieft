package edu.fiuba.algo3.modelo.Caso;
import edu.fiuba.algo3.modelo.Mapa.Paises.Pais;
import edu.fiuba.algo3.modelo.Mapa.Paises.Paises;
import edu.fiuba.algo3.modelo.Policia.Rango;
import edu.fiuba.algo3.modelo.Criminales.Criminal;
import edu.fiuba.algo3.modelo.Criminales.Sospechosos;

import java.util.ArrayList;

public class Caso {
    private final Criminal ladron;
    private Objeto objetoRobado;
    private ArrayList<Pais> rutaDeEscape;



    public Caso (Sospechosos listaDeSospechosos, ObjetosValiosos listaDeObjetos, Paises listaDePaises, Rango rangoPolicia){
        ladron = listaDeSospechosos.elegirCriminalAleatorio();
        objetoRobado = listaDeObjetos.robarObjetoPorNivel(rangoPolicia);
        rutaDeEscape = listaDePaises.elegirRutaDeEscapePorNivel(objetoRobado.paisDeOrigen(), objetoRobado.cantidadDePaisesDeEscape());
    }

}
