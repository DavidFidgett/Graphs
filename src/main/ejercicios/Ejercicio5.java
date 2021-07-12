package main.ejercicios;

import graph.SimpleGraph;
import main.AdjLists;

public class Ejercicio5 {
    public static void run(){
        System.out.println(" Ejercicio 5.- DFS");
        System.out.println(" Grafo propuesto: ");
        SimpleGraph graph = SimpleGraph.loadGraph(AdjLists.g_02);
        System.out.println(" Lista de adyacencia: ");
        graph.printNum();
        System.out.println(" Aplicando DFS sobre el grafo.");
        System.out.println("\n Iniciando en nodo 4: ");
        graph.DFS(4);
        System.out.println("\n Iniciando en nodo 0: ");
        graph.DFS(0);
        System.out.println("\n Iniciando en nodo 7: ");
        graph.DFS(7);
    }
}
