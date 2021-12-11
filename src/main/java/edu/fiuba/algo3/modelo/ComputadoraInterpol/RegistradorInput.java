package edu.fiuba.algo3.modelo.ComputadoraInterpol;

import edu.fiuba.algo3.modelo.Accesorios.*;
import edu.fiuba.algo3.modelo.Criminales.Caracteristicas;
import edu.fiuba.algo3.modelo.Hobbies.*;
import edu.fiuba.algo3.modelo.Pelo.*;
import edu.fiuba.algo3.modelo.Sexo.*;

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
        } while (opcion <= 0 || opcion > 5);

        if (opcion == 1)
            caracteristica = new SexoMasculino();

        else if(opcion == 2)
            caracteristica = new SexoFemenino();

        return caracteristica;
    }

    private Caracteristicas pedirHobbie(){
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        Caracteristicas caracteristica = null;
        System.out.println("Cual es el hobbie del criminal?\n" +
                "1- Mountain Climbing\n" +
                "2- Tennis\n" +
                "3- Croquett\n" +
                "4- Volver\n");

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
            caracteristica = new MountainClimbing();

        else if(opcion == 2)
            caracteristica = new Tennis();

        else if(opcion == 3)
            caracteristica = new Croquet();

        return caracteristica;
    }

    private Caracteristicas pedirPelo(){
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        Caracteristicas caracteristica = null;
        System.out.println("Como tiene el pelo el criminal?\n" +
                "1- Blond\n" +
                "2- Black\n" +
                "3- Red\n" +
                "4- Volver\n");

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
            caracteristica = new Blond();

        else if(opcion == 2)
            caracteristica = new Black();

        else if(opcion == 3)
            caracteristica = new Red();

        return caracteristica;
    }

    private Caracteristicas pedirAccesorio(){
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        Caracteristicas caracteristica = null;
        System.out.println("Que accesorio lleva el criminal?\n" +
                "1- Tattoo\n" +
                "2- Ring\n" +
                "3- Jewelry\n" +
                "4- Volver\n");

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
            caracteristica = new Tattoo();

        else if(opcion == 2)
            caracteristica = new Ring();

        else if(opcion == 3)
            caracteristica = new Jewelry();

        return caracteristica;
    }

    private Caracteristicas pedirVehiculo(){
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        Caracteristicas caracteristica = null;
        System.out.println("Vehiculo usa el criminal?\n" +
                "1- Limousine\n" +
                "2- Convertible\n" +
                "3- Motorcycle\n" +
                "4- Volver\n");

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
            caracteristica = new Blond();

        else if(opcion == 2)
            caracteristica = new Black();

        else if(opcion == 3)
            caracteristica = new Red();

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
