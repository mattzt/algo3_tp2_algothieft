package edu.fiuba.algo3.modelo.ComputadoraInterpol;

import edu.fiuba.algo3.modelo.Criminales.Accesorios.*;
import edu.fiuba.algo3.modelo.Criminales.Caracteristicas;
import edu.fiuba.algo3.modelo.Criminales.Hobbies.*;
import edu.fiuba.algo3.modelo.Criminales.Pelo.*;
import edu.fiuba.algo3.modelo.Criminales.Sexo.*;
import edu.fiuba.algo3.modelo.Criminales.Vehiculo.Deportivo;
import edu.fiuba.algo3.modelo.Criminales.Vehiculo.Descapotable;
import edu.fiuba.algo3.modelo.Criminales.Vehiculo.Limusina;
import edu.fiuba.algo3.modelo.Criminales.Vehiculo.Moto;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RegistradorInput {

    public int pedirCaracteristica() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        System.out.println("Que caracteristica desea agregar?\n" +
                "1- Sexo\n" +
                "2- Hobbie\n" +
                "3- Pelo\n" +
                "4- Accesorio\n" +
                "5- Vehiculo\n");

        do {
            try {
                System.out.println("Ingrese un numero del 1 al 5");
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Este input no es valido, intente nuevamente. Debe ser un entero del 1 al 5");
            }
            scanner.nextLine();
        } while (opcion <= 0 || opcion > 5);

        return opcion;
    }

    private Caracteristicas pedirSexo(){
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        Caracteristicas caracteristica = null;
        System.out.println("De que sexo es el criminal?\n" +
                "1- Masculino\n" +
                "2- Femenino\n" +
                "3- Volver\n");

        do {
            try {
                System.out.println("Ingrese un numero del 1 al 3");
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Este input no es valido, intente nuevamente. Debe ser un entero del 1 al 3");
            }
            scanner.nextLine();
        } while (opcion <= 0 || opcion > 3);

        if (opcion == 1)
            caracteristica = new SexoMasculino();

        else if(opcion == 2)
            caracteristica = new SexoFemenino();

        return caracteristica;
    }

    private Caracteristicas evaluarHobbie(int opcion){
        Caracteristicas caracteristica;
        switch (opcion){
            case 1:
                caracteristica = new Alpinismo();
                break;
            case 2:
                caracteristica = new Tenis();
                break;
            case 3:
                caracteristica = new Croquet();
                break;
            case 4:
                caracteristica = new Musica();
                break;
            case 5:
                caracteristica = new Natacion();
                break;
            case 6:
                caracteristica = new Paracaidismo();
                break;
            default:
                caracteristica = null;
                break;
        }
        return caracteristica;
    }

    private Caracteristicas pedirHobbie(){
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        Caracteristicas caracteristica;
        System.out.println("Cual es el hobbie del criminal?\n" +
                "1- Alpinismo\n" +
                "2- Tenis\n" +
                "3- Croquet\n" +
                "4- Musica\n" +
                "5- Natacion\n" +
                "6- Paracaidismo\n" +
                "7- Volver\n");

        do {
            try {
                System.out.println("Ingrese un numero del 1 al 4");
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Este input no es valido, intente nuevamente. Debe ser un entero del 1 al 4");
            }
            scanner.nextLine();
        } while (opcion <= 0 || opcion > 7);

        caracteristica = evaluarHobbie(opcion);

        return caracteristica;
    }

    private Caracteristicas pedirPelo(){
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        Caracteristicas caracteristica = null;
        System.out.println("Como tiene el pelo el criminal?\n" +
                "1- Rubio\n" +
                "2- Negro\n" +
                "3- Rojo\n" +
                "4- Castanio\n" +
                "5- Volver");

        do {
            try {
                System.out.println("Ingrese un numero del 1 al 5");
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Este input no es valido, intente nuevamente. Debe ser un entero del 1 al 5");
            }
            scanner.nextLine();
        } while (opcion <= 0 || opcion > 5);

        if (opcion == 1)
            caracteristica = new Rubio();

        else if(opcion == 2)
            caracteristica = new Negro();

        else if(opcion == 3)
            caracteristica = new Rojo();

        else if(opcion == 4)
            caracteristica = new Castanio();

        return caracteristica;
    }

    private Caracteristicas pedirAccesorio(){
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        Caracteristicas caracteristica = null;
        System.out.println("Que accesorio lleva el criminal?\n" +
                "1- Tatuaje\n" +
                "2- Anillo\n" +
                "3- Joyas\n" +
                "4- Cicatriz\n" +
                "5- Volver");

        do {
            try {
                System.out.println("Ingrese un numero del 1 al 5");
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Este input no es valido, intente nuevamente. Debe ser un entero del 1 al 5");
            }
            scanner.nextLine();
        } while (opcion <= 0 || opcion > 5);

        if (opcion == 1)
            caracteristica = new Tatuaje();

        else if(opcion == 2)
            caracteristica = new Anillo();

        else if(opcion == 3)
            caracteristica = new Joyas();

        else if(opcion == 4)
            caracteristica = new Cicatriz();

        return caracteristica;
    }

    private Caracteristicas pedirVehiculo(){
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        Caracteristicas caracteristica = null;
        System.out.println("Vehiculo usa el criminal?\n" +
                "1- Limusina\n" +
                "2- Descapotable\n" +
                "3- Moto\n" +
                "4- Deportivo\n" +
                "5- Volver");

        do {
            try {
                System.out.println("Ingrese un numero del 1 al 4");
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Este input no es valido, intente nuevamente. Debe ser un entero del 1 al 4");
            }
            scanner.nextLine();
        } while (opcion <= 0 || opcion > 5);

        if (opcion == 1)
            caracteristica = new Limusina();

        else if(opcion == 2)
            caracteristica = new Descapotable();

        else if(opcion == 3)
            caracteristica = new Moto();

        else if(opcion == 4)
            caracteristica = new Deportivo();

        return caracteristica;
    }

    public Caracteristicas procesarInput(int input){
        Caracteristicas caracteristica = null;
        switch (input){
             case 1:
                 caracteristica = pedirSexo();
                 break;
             case 2:
                 caracteristica = pedirHobbie();
                 break;
             case 3:
                 caracteristica = pedirPelo();
                 break;
             case 4:
                 caracteristica = pedirAccesorio();
                 break;
             case 5:
                 caracteristica = pedirVehiculo();
                 break;
        }
        return caracteristica;
    }
}
