package edu.fiuba.algo3.modelo.Caso;
import edu.fiuba.algo3.modelo.Mapa.Paises.Pais;
import edu.fiuba.algo3.modelo.Mapa.Paises.Paises;
import edu.fiuba.algo3.modelo.Pistas.RepositorioPistas;
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



    public Caso (Sospechosos listaDeSospechosos, ObjetosValiosos listaDeObjetos, Paises listaDePaises, Policia nuevoPolicia){
        policia = nuevoPolicia;
        ladron = listaDeSospechosos.elegirCriminalAleatorio();
        objetoRobado = listaDeObjetos.robarObjetoPorNivel(policia.presentarPlaca());
    }

    public Criminal getCriminal(){
        return ladron;
    }

    public String nombreObjeto(){
        return objetoRobado.getNombreObjeto();
    }

    public void crearRutaDeEscape(RepositorioPistas repositorio, Paises paises){
        repositorio.crearRutaDeEscape(paises, policia, objetoRobado);
    }
}
