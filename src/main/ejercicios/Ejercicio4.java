package main.ejercicios;

import graph.SimpleGraph;
import main.AdjLists;

public class Ejercicio4 {
    public static void run(){
        System.out.println("\n Ejercicio 4 .- BFS");
        System.out.println(" Grafo numero 1: ");
        SimpleGraph graph1 = SimpleGraph.loadGraph(AdjLists.g_01);
        System.out.println(" Lista de adyacencia: ");
        graph1.printNum();
        System.out.println(" BFS (Iniciando en nodo 4): ");
        graph1.BFS(4);
        System.out.println(" BFS (Iniciando en nodo 1): ");
        graph1.BFS(1);
        System.out.println();
        System.out.println(" Grafo numero 2:");
        SimpleGraph graph = SimpleGraph.loadGraph(AdjLists.g_02);
        System.out.println(" Lista de adyacencia: ");
        graph.printNum();
        System.out.println(" BFS (Iniciando en nodo 0): ");
        graph.BFS(0);
        System.out.println(" BFS (Iniciando en nodo 3): ");
        graph.BFS(3);
    }
}
