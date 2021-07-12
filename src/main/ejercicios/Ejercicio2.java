package main.ejercicios;

import graph.DirectedGraph;

import java.util.Scanner;

public class Ejercicio2 {
    public static void run(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n Ejercicio 2.- Grafos Dirigidos");
        System.out.print("\n Ingrese la cantidad de vertices que tendra el grafo: ");
        int V = sc.nextInt();
        int menu;
        DirectedGraph graph = new DirectedGraph(V);
        do {
            System.out.println("\n Menu");
            System.out.println(" 1.- Ver lista de adyacencia");
            System.out.println(" 2.- Agregar arista");
            System.out.println(" 3.- Borrar arista");
            System.out.println(" 4.- Salir.");
            System.out.print("\n Ingrese numero de opcion y presione ENTER: ");
            menu = sc.nextInt();
            switch (menu){
                case 1 -> graph.printNum();
                case 2 -> {
                    System.out.print("\n Ingrese el nodo origen: ");
                    int src = sc.nextInt();
                    System.out.print("\n Ingrese el nodo destino: ");
                    int dest = sc.nextInt();
                    if (src >= V || src < 0 || dest >= V || dest < 0){
                        System.out.println("\n Nodos no validos.");
                    } else {
                        graph.addEdge(src, dest);
                    }
                }
                case 3 -> {
                    System.out.print("\n Ingrese el nodo origen: ");
                    int src = sc.nextInt();
                    System.out.print("\n Ingrese el nodo destino: ");
                    int dest = sc.nextInt();
                    if (src >= V || src < 0 || dest >= V || dest < 0){
                        System.out.println("\n Nodos no validos.");
                    } else {
                        graph.removeEdge(src, dest);
                    }
                }
                case 4 -> System.out.println("\n Regresando a menu principal.");
                default -> System.out.println("\n Opcion no valida.");
            }
        } while (menu != 4);
    }
}
