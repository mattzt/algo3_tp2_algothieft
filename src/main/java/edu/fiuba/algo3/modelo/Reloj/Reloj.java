package edu.fiuba.algo3.modelo.Reloj;

import edu.fiuba.algo3.modelo.IntervaloTiempo.IntervaloTiempo;

public class Reloj {
    private DiaDeLaSemana dia;
    private int hora;

    public Reloj(){
        hora = 7;
        dia = new Lunes();
    }

    public void avanzarReloj(IntervaloTiempo unIntervalo){
        int horaFinal = unIntervalo.pasarTiempo(hora);
        if (horaFinal >= 24){
            dia = dia.siguienteDia();
            horaFinal = horaFinal - 24;
        }
        hora = horaFinal;
    }

    public int verHora() {
        return hora;
    }

    public DiaDeLaSemana verDia(){
        return dia;
    }

    public void reset() {
        hora = 7;
        dia = new Lunes();
    }
}
