package main.ejercicios;

import graph.SimpleGraph;

public class Ejercicio1 {
    public static void run(){
        System.out.println("\n Ejercicio 1.- Implementacion de Grafos en Java.");
        int V = 5;
        SimpleGraph graph = new SimpleGraph(V);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        System.out.println();
        graph.printNum();
    }
}
