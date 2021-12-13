package edu.fiuba.algo3.modelo.Criminales.Vehiculo;

import edu.fiuba.algo3.modelo.Criminales.Sexo.Sexo;

public abstract  class Vehiculos {

    public abstract String valor();

    public  boolean vehiculoEsIgualA(Vehiculos vehiculo){
        return (vehiculo.getClass()==this.getClass());
    }

}
