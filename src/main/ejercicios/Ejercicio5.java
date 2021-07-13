package main.ejercicios;

import graph.SimpleGraph;
import main.AdjLists;

/**
 * Clase correspondiente al Ejercicio #5
 */
public class Ejercicio5 {
    /**
     * Metodo correspondiente a la Clase Principal del ejercicio #5
     * Implementacion de Depth First Search.
     * En este ejercicio se pidio agregar a la clase
     * {@link graph.Graph} la implementacion de DFS
     * {@link graph.Graph#DFS(int)} descrita a continuacion:
     * <pre>{@code
     *
     *     void DFSUtil (int v,boolean visited[]) {
     *         visited[v] = true;
     *         System.out.print(v+" ");
     *
     *         Iterator<Integer> i = adjArray[v].listIterator();
     *         while (i.hasNext()) {
     *             int n = i.next();
     *             if (!visited[n]) {
     *                 DFSUtil(n, visited);
     *             }
     *         }
     *     }
     *     @code
     *     void DFS(int v) {
     *         boolean visited[] = new Boolean[V];
     *         DFSUtil (v, visited);
     *     }
     * }</pre>
     */
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
