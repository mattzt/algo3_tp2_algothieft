package edu.fiuba.algo3.modelo.Reloj;

public class Reloj {
    private DiaDeLaSemana dia;
    private int hora;

    public Reloj(){
        hora = 0;
        dia = new Lunes();
    }

    public int avanzarReloj(int horas){
        int horaFinal = hora + horas;
        if (horaFinal>=24){
            dia = dia.siguienteDia();
            horaFinal = horaFinal - 24;
            if (horaFinal >= 24) return avanzarReloj(horaFinal);
        }
        hora = horaFinal;
        return horaFinal;
    }

    public Boolean equals(String dia, int hora){
        return this.dia.diaDeHoy().equals(dia) && (this.hora==hora);
    }

    public int verHora() {
        return hora;
    }

    public DiaDeLaSemana verDia(){
        return dia;
    }

    public void reset() {
        hora = 0;
        dia = new Lunes();
    }
}
