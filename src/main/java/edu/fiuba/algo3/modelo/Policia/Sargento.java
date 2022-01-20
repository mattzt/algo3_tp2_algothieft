package edu.fiuba.algo3.modelo.Policia;

public class Sargento extends Rango{

    public Sargento(){
        casosResueltos = 20;
        nombre = "Sargento";
    }

    @Override
    public int velocidadViaje(){
        return 1500;
    }

    @Override
    public Rango promover(){
        return this;
    }

    @Override
    public int nivelDeLosObjetosBuscados() {
        return 3;
    }

    @Override
    public Boolean es(String unRango) {
        return unRango.equals("Sargento");
    }

    @Override
    public String toString(){
        return "DIFICIL";
    }
}
