package main.ejercicios;

import graph.WeightedGraph;
import main.AdjLists;

/**
 * Clase correspondiente al Ejercicio #6
 *
 * @author David Gutierrez Marin
 */
public class Ejercicio6 {
    /**
     * Metodo correspondiente a la Clase Principal del Ejercicio #6
     * Implementacion del Algoritmo de Primm.
     * La implementacion del Algoritmo de Primm para Grafos Ponderados
     * No Dirigidos puede ser consultada en
     * {@link graph.WeightedGraph#primm(int)}.
     * Para este ejercicio se pidio implementar el siguiente grafo, cuya
     * lista de adyacencia es cargada en una nueva instancia de un
     * {@link graph.WeightedGraph} a traves del metodo
     * {@link graph.WeightedGraph#loadGraph(int[][][])} ingresando
     * como arreglo tridimensional con los valores correspondientes
     * {@link AdjLists#wg_02}.
     * <img src="doc-files/wg_02.png" alt="Grafo Ponderado">
     *
     */
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
