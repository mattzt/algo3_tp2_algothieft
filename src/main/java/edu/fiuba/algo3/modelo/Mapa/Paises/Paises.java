package edu.fiuba.algo3.modelo.Mapa.Paises;

import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Listable;
import edu.fiuba.algo3.modelo.Randomizador;
import java.util.ArrayList;

public class Paises implements Listable {
    private final ArrayList<Pais> paises;

    public Paises() {
        paises = new ArrayList<>();
    }

    public void agregar(Pais nuevoPais) {
        paises.add(nuevoPais);
    }

    public Pais buscar(String nombrePais) throws NoExisteError {
        for(Pais pais: paises){
            if (nombrePais.equals(pais.getNombre())) return pais;
        }
        throw new NoExisteError("El país no esta creado");
    }

    public int size() {
        return paises.size();
    }

    public ArrayList<Pais> elegirRutaDeEscapePorNivel(Pais paisDelObjeto, int cantidadDePaisesDeEscape) {
        ArrayList<Pais> listaTodosLosPaises = new ArrayList<>(paises);
        ArrayList<Pais> rutaDeEscape = new ArrayList<>();
        rutaDeEscape.add(paisDelObjeto);
        listaTodosLosPaises.remove(paisDelObjeto);
        while (rutaDeEscape.size()!=cantidadDePaisesDeEscape){
            Pais nuevoPaisDeEscape = listaTodosLosPaises.remove(Randomizador.indiceRandom(listaTodosLosPaises));
            rutaDeEscape.add(nuevoPaisDeEscape);
        }
        return rutaDeEscape;
    }

    public void setPaisesConexos(){
        for (Pais pais : paises){
            ArrayList<Pais> listaTodosLosPaises = new ArrayList<>(paises);
            while (pais.puedeAgregarConexos()){
                Pais unPaisConexo = listaTodosLosPaises.remove(Randomizador.indiceRandom(listaTodosLosPaises));
                if (unPaisConexo.puedeAgregarConexos()){
                    pais.agregarPaisConexo(unPaisConexo);
                    unPaisConexo.agregarPaisConexo(pais);
                }
            }
        }
    }
}
