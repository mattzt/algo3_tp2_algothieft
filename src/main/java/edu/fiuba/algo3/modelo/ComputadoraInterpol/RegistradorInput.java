package edu.fiuba.algo3.modelo.ComputadoraInterpol;

import edu.fiuba.algo3.modelo.Criminales.Caracteristicas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RegistradorInput {
    private final ProcesadorInput procesadorInput;

    public RegistradorInput(){
        procesadorInput = new ProcesadorInput();
    }

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

        return procesadorInput.procesarSexo(opcion);
    }

    private Caracteristicas pedirHobbie(){
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
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

        return procesadorInput.procesarHobbie(opcion);
    }

    private Caracteristicas pedirPelo(){
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
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

        return procesadorInput.procesarPelo(opcion);
    }

    private Caracteristicas pedirAccesorio(){
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
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

        return procesadorInput.procesarAccesorio(opcion);
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

        return procesadorInput.procesarVehiculo(opcion);
    }

    public Caracteristicas mostrarOpciones(int input){
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
