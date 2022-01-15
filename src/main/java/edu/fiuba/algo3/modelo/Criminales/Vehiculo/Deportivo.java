package edu.fiuba.algo3.modelo.Criminales.Vehiculo;

public class Deportivo implements Vehiculos{

    @Override
    public String valor() {
        return "Deportivo";
    }

    @Override
    public String crearPista() {
        return "Nop, solo recuerdo que vino en un hermoso auto deportivo";
    }

}
