package edu.fiuba.algo3.modelo.Criminales.Hobbies;

public interface Hobbies {

    static Hobbies crear(String unHobbie){
        if (unHobbie.equals("Alpinismo")) return new Alpinismo();
        if (unHobbie.equals("Croquet")) return new Croquet();
        if (unHobbie.equals("Musica")) return new Musica();
        if (unHobbie.equals("Natacion")) return new Natacion();
        if (unHobbie.equals("Paracaidismo")) return new Paracaidismo();
        return new Tenis();
    }

    String valor();

    default boolean hobbiesEsIgualA(Hobbies hobbies){
        return this.valor().equals(hobbies.valor());
    }
}
