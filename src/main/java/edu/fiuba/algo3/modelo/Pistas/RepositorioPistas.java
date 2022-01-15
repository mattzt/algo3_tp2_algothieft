package edu.fiuba.algo3.modelo.Pistas;

import edu.fiuba.algo3.modelo.Caso.Objeto;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Listable;
import edu.fiuba.algo3.modelo.Mapa.Paises.Pais;
import edu.fiuba.algo3.modelo.Mapa.Paises.Paises;
import edu.fiuba.algo3.modelo.Policia.Policia;

import java.util.ArrayList;
import java.util.Iterator;

public class RepositorioPistas implements Listable {
    private final ArrayList<Pista> posiblesPistas;
    private ArrayList<Pais> rutaDeEscape;
    private Policia policia;

    public RepositorioPistas(ArrayList<Pista> pistas) {
        posiblesPistas = pistas;
    }


    public Pista obtenerPistaPara(Edificio edificio){
        Pais siguiente = this.siguientePais();
        Iterator<Pista> iterador = posiblesPistas.iterator();
        Pista pistaActual = null;
        boolean encontrada = false;
        while(iterador.hasNext() && !encontrada){
            pistaActual = iterador.next();
            if((pistaActual.esTipo(edificio)) && (pistaActual.apuntaHacia(siguiente))){
                encontrada = true;
            }
        }
        return pistaActual;
    }

    @Override
    public int size() {
        return posiblesPistas.size();
    }

    public void crearRutaDeEscape(Paises paises, Policia policia, Objeto objetoRobado){
        this.policia = policia;
        rutaDeEscape = paises.elegirRutaDeEscapePorNivel(policia, objetoRobado.paisDeOrigen(), objetoRobado.cantidadDePaisesDeEscape());
    }

    public Pais siguientePais() {
        Iterator<Pais> iter = rutaDeEscape.iterator();
        Pais siguiente = iter.next();


        if (policia.getPaisActual().equals(siguiente)){
            siguiente = iter.next();
        }
        return siguiente;
    }
}
