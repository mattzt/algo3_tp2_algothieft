package edu.fiuba.algo3.modelo.Criminales.Hobbies;

import edu.fiuba.algo3.modelo.Criminales.Caracteristica;

public interface Hobbies extends Caracteristica {

    static Hobbies crear(String unHobbie){
        if (unHobbie.equals("Alpinismo")) return new Alpinismo();
        if (unHobbie.equals("Croquet")) return new Croquet();
        if (unHobbie.equals("Musica")) return new Musica();
        if (unHobbie.equals("Natacion")) return new Natacion();
        if (unHobbie.equals("Paracaidismo")) return new Paracaidismo();
        return new Tenis();
    }
}
