package main.ejercicios;

import graph.WeightedGraph;

import java.util.Scanner;

public class Ejercicio3 {
    public static void run(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n Ejercicio 3.- Grafos Ponderados");
        System.out.print("\n Ingrese la cantidad de vertices que tendra el grafo: ");
        int V = sc.nextInt();
        int menu;
        WeightedGraph graph = new WeightedGraph(V);
        do {
            System.out.println("\n Menu");
            System.out.println(" 1.- Ver lista de adyacencia");
            System.out.println(" 2.- Agregar Arista");
            System.out.println(" 3.- Borrar Arista");
            System.out.println(" 4.- Salir");
            System.out.print("\n Ingrese el numero de opcion y presione ENTER: ");
            menu = sc.nextInt();
            switch (menu){
                case 1 -> graph.printNum();
                case 2 -> {
                    System.out.print("\n Ingrese el nodo origen: ");
                    int src = sc.nextInt();
                    System.out.print("\n Ingrese el nodo destino: ");
                    int dest = sc.nextInt();
                    System.out.print("\n Ingrese el costo de la arista: ");
                    int weight = sc.nextInt();
                    if (src >= V || src < 0 || dest >= V || dest < 0){
                        System.out.println("\n Nodos no validos.");
                    } else {
                        graph.addEdge(src, dest, weight);
                    }
                }
                case 3 -> {
                    System.out.print("\n Ingrese el nodo origen: ");
                    int src = sc.nextInt();
                    System.out.print("\n Ingrese el nodo destino: ");
                    int dest = sc.nextInt();
                    System.out.print("\n Ingrese el costo de la arista: ");
                    int weight = sc.nextInt();
                    if (src >= V || src < 0 || dest >= V || dest < 0){
                        System.out.println("\n Nodos no validos.");
                    } else {
                        graph.removeEdge(src, dest, weight);
                    }
                }
                case 4 -> System.out.println("\n Regresando a menu principal.");
                default -> System.out.println("\n Opcion no valida.");
            }
        } while (menu != 4);
    }
}
