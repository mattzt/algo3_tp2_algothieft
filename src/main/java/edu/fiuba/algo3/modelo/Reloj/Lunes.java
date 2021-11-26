package edu.fiuba.algo3.modelo.Reloj;

public class Lunes implements DiaDeLaSemana{

    @Override
    public DiaDeLaSemana siguienteDia(){
        return new Martes();
    }

    @Override
    public String diaDeHoy() {
        return "Lunes";
    }
}
