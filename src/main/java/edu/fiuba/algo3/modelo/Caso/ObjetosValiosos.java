package edu.fiuba.algo3.modelo.Caso;

import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Listable;
import edu.fiuba.algo3.modelo.Policia.Rango;
import edu.fiuba.algo3.modelo.Randomizador;

import java.util.ArrayList;

public class ObjetosValiosos implements Listable {
    ArrayList<Objeto> objetosComunes;
    ArrayList<Objeto> objetosValiosos;
    ArrayList<Objeto> objetosMuyValiosos;

    public ObjetosValiosos() {
        objetosComunes = new ArrayList<>();
        objetosValiosos = new ArrayList<>();
        objetosMuyValiosos = new ArrayList<>();
    }

    public void agregar(Objeto nuevoObjeto, int valor) {
        ArrayList<Objeto> listaDeObjetosValiosos = elegirListaCorrecta(valor);
        listaDeObjetosValiosos.add(nuevoObjeto);
    }

    public Objeto buscar(String nombreObjeto, int valor) throws NoExisteError {
        ArrayList<Objeto> listaDeObjetosValiosos = elegirListaCorrecta(valor);
        for(Objeto objeto: listaDeObjetosValiosos){
            if (objeto.equals(nombreObjeto)) return objeto;
        }
        throw new NoExisteError("El objeto no esta creado");
    }

    private ArrayList<Objeto> elegirListaCorrecta(int valor){
        if (valor==1) return objetosComunes;
        if (valor==2) return objetosValiosos;
        return objetosMuyValiosos;
    }

    @Override
    public int size() {
        return (objetosComunes.size()+objetosValiosos.size()+objetosMuyValiosos.size());
    }

    public Objeto robarObjetoPorNivel(Rango rangoPolicia) {
        int valorObjeto = rangoPolicia.nivelDeLosObjetosBuscados();
        ArrayList<Objeto> listaDeObjetosValiosos = elegirListaCorrecta(valorObjeto);
        return listaDeObjetosValiosos.get(Randomizador.indiceRandom(listaDeObjetosValiosos));
    }
}
