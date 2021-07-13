package main.ejercicios;

import graph.SimpleGraph;

/**
 * Clase Correspondiente al Ejercicio #1
 */
public class Ejercicio1 {
    /**
     * Metodo correspondiente a la Clase Principal del Ejercicio #1
     * NOTA: Utilice una implementacion diferente para los grafos distinta
     * de la que se sugiere en la practica.
     * El siguiente codigo se refiere a la Clase Principal correspondiente
     * al Ejercicio #1 de la practica:
     * <pre>{@code
     *     package[...]
     *     public class [...] {
     *         public static void main(String[] args){
     *             int V = 5;
     *             Graph graph = new Graph(V);
     *             graph.addEdge(0, 1);
     *             graph.addEdge(0, 4);
     *             graph.addEdge(1, 2);
     *             graph.addEdge(1, 3);
     *             graph.addEdge(1, 4);
     *             graph.addEdge(2, 3);
     *             graph.addEdge(3, 4);
     *             graph.printGraph(graph);
     *         }
     *     }
     * }</pre>
     */
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
