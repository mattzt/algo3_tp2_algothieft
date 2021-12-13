package edu.fiuba.algo3.modelo.Criminales;

import edu.fiuba.algo3.modelo.Criminales.Accesorios.Accesorios;
import edu.fiuba.algo3.modelo.Criminales.Hobbies.Hobbies;
import edu.fiuba.algo3.modelo.Criminales.Pelo.Pelo;
import edu.fiuba.algo3.modelo.Criminales.Sexo.Sexo;
import edu.fiuba.algo3.modelo.Criminales.Vehiculo.Vehiculos;

public class Caracteristicas {
    private Sexo sexo;
    private Pelo pelo;
    private Hobbies hobbies;
    private Accesorios accesorios;
    private Vehiculos vehiculo;

    public Caracteristicas(Sexo nuevoSexo, Pelo nuevoPelo, Hobbies nuevoHobbie, Accesorios nuevoAccesorio, Vehiculos nuevoVehiculo){
        sexo = nuevoSexo;
        pelo = nuevoPelo;
        hobbies = nuevoHobbie;
        accesorios = nuevoAccesorio;
        vehiculo = nuevoVehiculo;
    }

    public Sexo sexo(){
        return sexo;
    }

    public Pelo pelo(){
        return pelo;
    }

    public Hobbies hobbies(){
        return hobbies;
    }

    public Accesorios accesorios(){
        return accesorios;
    }

    public Vehiculos vehiculo(){
        return vehiculo;
    }



    public boolean tieneCaracteristicasIguales(Caracteristicas buscada) {
        Boolean esIgual = false;
        if (sexo.sexoEsIgualA(buscada.sexo())) {
            esIgual = true;
        }
        if (pelo.peloEsIgualA(buscada.pelo())) {
            esIgual = true;
        }
        if (hobbies.hobbiesEsIgualA(buscada.hobbies())) {
            esIgual = true;
        }
        if (accesorios.accesoriosEsIgualA(buscada.accesorios())) {
            esIgual = true;
        }
        if (vehiculo.vehiculoEsIgualA(buscada.vehiculo())) {
            esIgual = true;
        }
        return (esIgual == true);
    }

    public void establecerPelo(Pelo peloNuevo) {
        pelo = peloNuevo;
    }

    public void establecerHobbies(Hobbies hobbieNuevo) {
        hobbies = hobbieNuevo;
    }

    public void establecerAccesorio(Accesorios accesorio) {
        accesorios = accesorio;
    }

    public void establecerVehiculo(Vehiculos vehiculoNuevo) {
        vehiculo = vehiculoNuevo;
    }

    public void establecerSexo(Sexo sexoNuevo) {
        sexo = sexoNuevo;
    }
}


