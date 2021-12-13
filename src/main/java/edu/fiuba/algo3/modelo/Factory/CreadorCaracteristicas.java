package edu.fiuba.algo3.modelo.Factory;

import edu.fiuba.algo3.modelo.Criminales.Accesorios.Accesorios;
import edu.fiuba.algo3.modelo.Criminales.Caracteristicas;
import edu.fiuba.algo3.modelo.Criminales.Hobbies.Hobbies;
import edu.fiuba.algo3.modelo.Criminales.Pelo.Pelo;
import edu.fiuba.algo3.modelo.Criminales.Sexo.Sexo;
import edu.fiuba.algo3.modelo.Criminales.Vehiculo.Vehiculos;

public class CreadorCaracteristicas {

    public Caracteristicas crear(String sexoSospechoso, String hobbieSospechoso,
                                 String peloSospechoso, String accesorioSospechoso, String vehiculoSospechoso) {
        Sexo sexoDelCriminal;
        Hobbies hobbiesDelCriminal;
        Pelo peloDelCriminal;
        Accesorios accesoriosDelCriminal;
        Vehiculos vehiculoDelCriminal;

        sexoDelCriminal = Sexo.crear(sexoSospechoso);
        hobbiesDelCriminal = Hobbies.crear(hobbieSospechoso);
        peloDelCriminal = Pelo.crear(peloSospechoso);
        accesoriosDelCriminal = Accesorios.crear(accesorioSospechoso);
        vehiculoDelCriminal = Vehiculos.crear(vehiculoSospechoso);
        return new Caracteristicas(sexoDelCriminal, peloDelCriminal, hobbiesDelCriminal,accesoriosDelCriminal,vehiculoDelCriminal);
    }
}
