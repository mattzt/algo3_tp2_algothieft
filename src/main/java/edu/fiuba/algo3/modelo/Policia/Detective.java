package edu.fiuba.algo3.modelo.Policia;

public class Detective extends Rango{

    public Detective(){
        casosResueltos = 5;
        nombre = "Detective";
    }

    @Override
    public int velocidadViaje(){
        return 1100;
    }

    @Override
    public Rango promover(){
        if(casosResueltos < 10)
            return this;
        return new Investigador();
    }

    @Override
    public int nivelDeLosObjetosBuscados() {
        return 2;
    }

    @Override
    public Boolean es(String unRango) {
        return unRango.equals("Detective");
    }

    @Override
    public String toString(){
        return "FACIL";
    }
}
