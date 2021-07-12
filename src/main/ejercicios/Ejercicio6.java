package main.ejercicios;

import graph.WeightedGraph;
import main.AdjLists;

public class Ejercicio6 {
    public static void run(){
        System.out.println("\n Ejercicio 6.- Algoritmo de Primm");
        System.out.println(" Grafo de la practica 6: ");
        WeightedGraph graph = WeightedGraph.loadGraph(AdjLists.wg_02);
        System.out.println("\n Lista de adyacencia: ");
        graph.print();
        System.out.println("\n Algoritmo de Primm: ");
        System.out.println("\n Empezando en nodo D: ");
        int weight = graph.primm("D");
        System.out.println(" Total Weight: " + weight);
        System.out.println("\n Empezando en nodo B: ");
        weight = graph.primm("B");
        System.out.println(" Total Weight: " + weight);
        System.out.println("\n Empezando en nodo H: ");
        weight = graph.primm("H");
        System.out.println(" Total Weight: " + weight);

        System.out.println("\n ************ ");

        System.out.println("\n Probando con otro grafo: ");
        WeightedGraph graph1 = WeightedGraph.loadGraph(AdjLists.wg_01);
        System.out.println("\n Lista de adyacencia: ");
        graph1.print();
        System.out.println("\n Algoritmo de Primm: ");
        System.out.println("\n Empezando en nodo A: ");
        weight = graph1.primm("A");
        System.out.println(" Total Weight: " + weight);
        System.out.println("\n Empezando en nodo C: ");
        weight = graph1.primm("C");
        System.out.println(" Total Weight: " + weight);
        System.out.println("\n Empezando en nodo D: ");
        weight = graph1.primm("D");
        System.out.println(" Total Weight: " + weight);

        System.out.println("\n ************ ");

        System.out.println("\n Probando con otro grafo: ");
        WeightedGraph graph2 = WeightedGraph.loadGraph(AdjLists.wg_03);
        System.out.println("\n Lista de adyacencia: ");
        graph2.print();
        System.out.println("\n Algoritmo de Primm: ");
        System.out.println("\n Empezando en nodo C: ");
        weight = graph2.primm("C");
        System.out.println(" Total Weight: " + weight);
        System.out.println("\n Empezando en nodo E: ");
        weight = graph2.primm("E");
        System.out.println(" Total Weight: " + weight);
        System.out.println("\n Empezando en nodo F: ");
        weight = graph2.primm("F");
        System.out.println(" Total Weight: " + weight);

    }
}
