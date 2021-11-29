package edu.fiuba.algo3.modelo.Reloj;

public class Reloj {
    private DiaDeLaSemana dia;
    private int hora;

    public Reloj(){
        hora = 0;
        dia = new Lunes();
    }

    public int avanzarReloj(int horas){
        int horaFinal = hora+horas;
        if (horaFinal>=24){
            dia = dia.siguienteDia();
            horaFinal = horaFinal - 24;
        }
        hora = horaFinal;
        return horaFinal;
    }
}
