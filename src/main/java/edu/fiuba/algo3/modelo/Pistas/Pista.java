package edu.fiuba.algo3.modelo.Pistas;


public interface Pista {
    public String pista = null;


    public Pista obtenerPistaBanco(BaseDatosPistas pistas);

    public Pista obtenerPistaBolsa(BaseDatosPistas pistas);

    public Pista obtenerPistaAeropuerto(BaseDatosPistas pistas);

    public Pista obtenerPistaPuerto(BaseDatosPistas pistas);

    public Pista obtenerPistaBiblioteca(BaseDatosPistas pistas);

    public String darPista(){
        return pista;
    }

}
