package edu.fiuba.algo3.modelo.IntervaloTiempo;

public class IntervaloTiempoDormir implements  IntervaloTiempo{
    @Override
    public int pasarTiempo(int horas) {
        if(horas >= 22 || horas < 4)
            return horas + 8;
        return horas;
    }
}
