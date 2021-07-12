package main;

import main.ejercicios.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int menu;
        do {
            System.out.println("\n Practica 6-7: ");
            System.out.println(" David Gutierrez Marin");
            System.out.println();
            System.out.println("\n Menu: ");
            System.out.println(" 1.- Ejercicio 1: Implementacion de Grafos");
            System.out.println(" 2.- Ejercicio 2: Grafos Dirigidos");
            System.out.println(" 3.- Ejercicio 3: Grafos Ponderados");
            System.out.println(" 4.- Ejercicio 4: BFS");
            System.out.println(" 5.- Ejercicio 5: DFS");
            System.out.println(" 6.- Ejercicio 6: Algoritmo de Primm");
            System.out.println(" 7.- Salir");
            System.out.print("\n Ingrese el numero de opcion y presione ENTER: ");
            menu = sc.nextInt();
            switch (menu){
                case 1 -> Ejercicio1.run();
                case 2 -> Ejercicio2.run();
                case 3 -> Ejercicio3.run();
                case 4 -> Ejercicio4.run();
                case 5 -> Ejercicio5.run();
                case 6 -> Ejercicio6.run();
                case 7 -> System.out.println(" Adios! (::");
                default -> System.out.println(" Opcion no valida");
            }
        } while (menu != 7);
    }
}
