package main.ejercicios;

import graph.DirectedGraph;

import java.util.Scanner;

/**
 * Clase correspondiente al Ejercicio #2
 *
 * @author David Gutierrez Marin
 */
public class Ejercicio2 {
    /**
     * Metodo correspondiente a la Clase Principal del Ejercicio #2
     * Implementacion de Grafos Dirigidos.
     * En este ejercicio se realizaron modificaciones a la clase
     * {@link graph.SimpleGraph} para la implementacion de grafos
     * dirigidos.
     * La principal diferencia es que, a diferencia de un grafo
     * simple donde al agregar o eliminar un arista, se debe hacer
     * la asociacion tanto para el nodo origen hacia el nodo destino
     * como para el nodo destino hacia el nodo origen, en el caso de
     * grafos dirigidos solo se debe de realizar la asociacion en la
     * lista de adyacencia para el nodo origen hacia el nodo destino.
     * Para este ejercicio, se realizo un menu para que el usuario pueda
     * crear su propio grafo dirigido, indicando al inicio el numero de
     * vertices con los que quiere que el grafo cuente, para posteriormente
     * mostrar las opciones para agregar un arista, eliminarla, ver la
     * lista de adyacencia del grafo, y terminar la ejecucion de
     * este metodo.
     */
    public static void run(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n Ejercicio 2.- Grafos Dirigidos");
        System.out.print("\n Ingrese la cantidad de vertices que tendra el grafo: ");
        int V = sc.nextInt();
        int menu;
        DirectedGraph graph = new DirectedGraph(V);
        do {
            System.out.println("\n Menu");
            System.out.println(" 1.- Ver lista de adyacencia");
            System.out.println(" 2.- Agregar arista");
            System.out.println(" 3.- Borrar arista");
            System.out.println(" 4.- Salir.");
            System.out.print("\n Ingrese numero de opcion y presione ENTER: ");
            menu = sc.nextInt();
            switch (menu){
                case 1 -> graph.printNum();
                case 2 -> {
                    System.out.print("\n Ingrese el nodo origen: ");
                    int src = sc.nextInt();
                    System.out.print("\n Ingrese el nodo destino: ");
                    int dest = sc.nextInt();
                    if (src >= V || src < 0 || dest >= V || dest < 0){
                        System.out.println("\n Nodos no validos.");
                    } else {
                        graph.addEdge(src, dest);
                    }
                }
                case 3 -> {
                    System.out.print("\n Ingrese el nodo origen: ");
                    int src = sc.nextInt();
                    System.out.print("\n Ingrese el nodo destino: ");
                    int dest = sc.nextInt();
                    if (src >= V || src < 0 || dest >= V || dest < 0){
                        System.out.println("\n Nodos no validos.");
                    } else {
                        graph.removeEdge(src, dest);
                    }
                }
                case 4 -> System.out.println("\n Regresando a menu principal.");
                default -> System.out.println("\n Opcion no valida.");
            }
        } while (menu != 4);
    }
}
