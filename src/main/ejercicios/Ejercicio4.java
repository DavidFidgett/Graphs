package main.ejercicios;

import graph.SimpleGraph;
import main.AdjLists;

/**
 * Clase correspondiente al Ejercicio #4
 *
 * @author David Gutierrez Marin
 */
public class Ejercicio4 {
    /**
     * Metodo correspondiente a la Clase Principal del Ejercicio #4
     * Implementacion de Breadth First Search.
     * En este ejercicio se pidio agregar a la clase
     * {@link graph.Graph} la implementacion de BFS
     * {@link graph.Graph#BFS(int)} descrita a continuacion:
     * <pre>{@code
     *     void BFS(int s) {
     *         boolean visited[] = new boolean[V];
     *
     *         LinkedList <Integer> queue = new LinkedList<Integer>();
     *
     *         visited[s] = true;
     *         queue.add(s);
     *         while (queue.size() != 0) {
     *             s = queue.poll();
     *             System.out.print(s+" ");
     *
     *             Iterator<Integer> i = adjArray[s].listIterator();
     *             while (i.hasnext()) {
     *                 int n = i.next();
     *                 if (!visited[n]) {
     *                     visited[n] = true;
     *                     queue.add(n);
     *                 }
     *             }
     *         }
     *     }
     *}</pre>
     */
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
