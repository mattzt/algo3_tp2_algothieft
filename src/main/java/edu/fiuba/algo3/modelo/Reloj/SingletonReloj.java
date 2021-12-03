package edu.fiuba.algo3.modelo.Reloj;

public class SingletonReloj {
    private DiaDeLaSemana dia;
    private int hora;
    private static SingletonReloj instance;

    private SingletonReloj()
    {
        hora = 0;
        dia = new Lunes();
    }

    public static SingletonReloj getInstance(){
        if(instance == null){
            instance = new SingletonReloj();
        }
        return instance;
    }
    public int avanzarReloj(int horas){
        int horaFinal = hora+horas;
        if (horaFinal>=24){
            dia = dia.siguienteDia();
            horaFinal = horaFinal - 24;
            if (horaFinal >= 24) return avanzarReloj(horaFinal);
        }
        hora = horaFinal;
        return horaFinal;
    }


    public int darHora(){return hora;}
}