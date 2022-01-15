package edu.fiuba.algo3.modelo.Criminales.Vehiculo;

public class Moto implements Vehiculos{

    @Override
    public String valor() {
        return "Moto";
    }

    @Override
    public String crearPista() {
        return "Si, habia venido en moto. La estaciono en la entrada";
    }

}
