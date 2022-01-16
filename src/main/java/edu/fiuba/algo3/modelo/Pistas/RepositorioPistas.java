package edu.fiuba.algo3.modelo.Pistas;

import edu.fiuba.algo3.modelo.Caso.Objeto;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Listable;
import edu.fiuba.algo3.modelo.Mapa.Paises.Pais;
import edu.fiuba.algo3.modelo.Mapa.Paises.Paises;
import edu.fiuba.algo3.modelo.Policia.Policia;

import java.util.ArrayList;

public class RepositorioPistas implements Listable {
    private final ArrayList<Pista> posiblesPistas;
    private ArrayList<Pais> rutaDeEscape;
    private Policia policia;

    public RepositorioPistas(ArrayList<Pista> pistas) {
        posiblesPistas = pistas;
    }


    public Pista obtenerPistaPara(Edificio edificio){
        Pais siguiente = this.siguientePais();
        Pista pistaActual = null;
        boolean encontrada = false;
        int i = 0;

        while(!encontrada && i < posiblesPistas.size()){
            pistaActual = posiblesPistas.get(i);
            if(pistaActual.esTipo(edificio) && pistaActual.apuntaHacia(siguiente)){
                encontrada = true;
            }
            i++;
        }
        return pistaActual;
    }

    @Override
    public int size() {
        return posiblesPistas.size();
    }

    public void crearRutaDeEscape(Paises paises, Policia policia, Objeto objetoRobado){
        this.policia = policia;
        rutaDeEscape = paises.elegirRutaDeEscapePorNivel(policia, objetoRobado.cantidadDePaisesDeEscape());
    }

    public Pais siguientePais() {
        Pais paisActual = policia.getPaisActual();
        Pais siguiente = rutaDeEscape.get(0);
        int indiceActual;

        if(rutaDeEscape.contains(paisActual)) {
            indiceActual = rutaDeEscape.indexOf(paisActual);

            if(indiceActual + 1 < rutaDeEscape.size())
                siguiente = rutaDeEscape.get(indiceActual + 1);
            else
                siguiente = rutaDeEscape.get(indiceActual);
        }

        return siguiente;
    }

    public boolean estaEnUltimoPais(){
        int tamanio = rutaDeEscape.size();
        Pais ultimo = rutaDeEscape.get(tamanio - 1);
        Pais actual = policia.getPaisActual();

        return ultimo.equals(actual);
    }
}
