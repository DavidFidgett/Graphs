package main.ejercicios;

import graph.WeightedGraph;

import java.util.Scanner;

/**
 * Clase correspondiente al Ejercicio #3
 */
public class Ejercicio3 {
    /**
     * Metodo correspondiente a la Clase Principal del Ejercicio #3
     * Implementacion de Grafos Ponderados.
     * A diferencia del {@link Ejercicio2#run()} donde
     * se tenia que implementar un grafo dirigido, en este caso
     * se implemento un Grafo Ponderado, haciendo pocas modificaciones
     * a la clase {@link graph.SimpleGraph}. Estas modificaciones consistieron
     * en simplemente agregar el parametro de weight a los metodos de
     * esta clase para que se agregara el costo de la arista a las conexiones
     * en los nodos que componen la lista de adyacencia.
     * Debido a que, en similitud con el grafo simple, en esta implementacion
     * del grafo ponderado es tambien un grafo no dirigido, se mantuvieron
     * las relaciones de los nodos de manera bilateral tanto para agregar como
     * para eliminar aristas.
     * De igual manera, en este caso se realizo un menu para que el usuario
     * ingrese la cantidad de nodos que quiere que contenga el grafo, para
     * posteriormente en el menu poder seleccionar las opciones que le permitan
     * ver la lista de adyacencia del grafo, agregar aristas con un costo, o
     * eliminar estas mismas.
     * La ultima opcion del menu es la de terminar la ejecucion de este
     * metodo.
     */
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
