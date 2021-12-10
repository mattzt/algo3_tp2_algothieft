package edu.fiuba.algo3.modelo.ComputadoraInterpol;

import edu.fiuba.algo3.modelo.Criminales.Caracteristicas;
import edu.fiuba.algo3.modelo.Criminales.Sospechosos;

public class ComputadoraInterpol{
    RegistradorInput registradorInput;
    Sospechosos sospechosos;

    public ComputadoraInterpol(){
        registradorInput = new RegistradorInput();
        sospechosos = new Sospechosos();
    }

    public void ingresarDatos(){
        int input = registradorInput.pedirCaracteristica();
        Caracteristicas caracteristica = registradorInput.procesarInput(input);

        while(caracteristica == null){
            input = registradorInput.pedirCaracteristica();
            caracteristica = registradorInput.procesarInput(input);
        }
        sospechosos.filtrarSospechosos(caracteristica);
    }
}
