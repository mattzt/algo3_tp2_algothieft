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

    public void ingresarDatosSospechoso(){
        int input = registradorInput.pedirCaracteristica();
        Caracteristicas caracteristica = registradorInput.mostrarOpciones(input);

        while(caracteristica == null){
            input = registradorInput.pedirCaracteristica();
            caracteristica = registradorInput.mostrarOpciones(input);
        }
        sospechosos.filtrarSospechosos(caracteristica);
    }

    public boolean sePuedeEmitirOrden(){
        if(sospechosos.cantidadSospechosos() == 1) {
            System.out.println("Aun no podes emitir una orden de arresto! Quedan mas de 1 sospechosos posibles\n");
            return false;
        }
        return true;
    }
}
