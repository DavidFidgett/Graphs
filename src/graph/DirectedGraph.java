package graph;

import graph.node.Node;

/**
 * Implementacion de Grafo Dirigido No Ponderado.
 *
 * @author David Gutierrez Marin
 */
public class DirectedGraph extends Graph{
    /**
     * Metodo contructor del Grafo.
     * @param v Numero de nodos que contendra el grafo.
     */
    public DirectedGraph(int v) {
        super(v);
    }

    /**
     * Crea una conexion entre un par de nodos ordenados.
     * Dado un nodo origen al que se quiere establecer una
     * conexion con el nodo destino, y considerando que esta conexion no
     * exista previamente, apoyandonos del metodo
     * {@link #indexOfConnection(int, int, int)}, agregamos el nodo
     * destino a la lista de adyacencia del nodo origen, creando asi
     * una conexion dirigida entre estos nodos.
     * @param srcNode Nodo Origen
     * @param destNode Nodo Destino
     */
    public void addEdge(int srcNode, int destNode){
        if (indexOfConnection(srcNode, destNode, 0) == -1){
            Node node = new Node(srcNode, destNode);
            adjArray[srcNode].add(node);
        }
    }

    /**
     * Crea una conexion entre un par de nodos ordenados.
     * Dado un nodo origen al que se quiere establecer una
     * conexion con el nodo destino, y considerando que esta conexion no
     * exista previamente, apoyandonos del metodo
     * {@link #indexOfConnection(int, int, int)}, agregamos el nodo
     * destino a la lista de adyacencia del nodo origen, creando asi
     * una conexion dirigida entre estos nodos.
     * @param src Nodo Origen
     * @param dest Nodo Destino
     */
    public void addEdge(String src, String dest){
        int srcNode = convert(src);
        int destNode = convert(dest);
        if (indexOfConnection(srcNode, destNode, 0) == -1){
            Node node = new Node(srcNode, destNode);
            adjArray[srcNode].add(node);
        }
    }

    /**
     * Elimina la conexion entre un par de nodos ordenados.
     * Dado un nodo origen con una conexion a un nodo destino, y
     * considerando un costo de 0 para la arista y que la
     * conexion existe mediante el uso del metodo
     * {@link #indexOfConnection(int, int, int)}, se
     * eliminara de la lista de adyacencia del nodo origen
     * la conexion que tiene establecida con el nodo destino.
     * @param srcNode Nodo Origen
     * @param destNode Nodo Destino
     */
    public void removeEdge(int srcNode, int destNode){
        int index = indexOfConnection(srcNode, destNode, 0);
        if (index != -1){
            adjArray[srcNode].remove(index);
        }
    }

    /**
     * Elimina la conexion entre un par de nodos ordenados.
     * Dado un nodo origen con una conexion a un nodo destino, y
     * considerando un costo de 0 para la arista y que la
     * conexion existe mediante el uso del metodo
     * {@link #indexOfConnection(int, int, int)}, se
     * eliminara de la lista de adyacencia del nodo origen
     * la conexion que tiene establecida con el nodo destino.
     * @param src Nodo Origen
     * @param dest Nodo Destino
     */
    public void removeEdge(String src, String dest){
        int srcNode = convert(src);
        int destNode = convert(dest);
        int index = indexOfConnection(srcNode, destNode, 0);
        if (index != -1){
            adjArray[srcNode].remove(index);
        }
    }

    /**
     * Metodo para cargar un grafo desde un arreglo bidimensional.
     * Ingresando a este metodo un arreglo bidimensional de numeros
     * enteros, este metodo utilizara los valores del arreglo para
     * generar un nuevo grafo con las conexiones ya especificadas.
     * El primer arreglo nos indicara el nodo origen al que nos estamos
     * refiriendo, mientras que su sub arreglo contendra como valores
     * los nodos que pertenecen a la lista de adyacencia de este nodo origen.
     * El tamaño del arreglo correspondera a la cantidad de nodos que se
     * tenga, mientras que el tamaño de cada subarreglo sera la cantidad
     * de nodos adyacentes con los que cuenta cada nodo del grafo.
     * @param adjList Arreglo bidimensional con los valores del grafo
     * @return Grafo Dirigido No Ponderado
     */
    public static DirectedGraph loadGraph(int[][] adjList){
        int n = adjList.length;
        DirectedGraph graph = new DirectedGraph(n);
        for (int i = 0; i < n; i++) {
            for (int j : adjList[i]) {
                graph.addEdge(i, j);
            }
        }
        return graph;
    }

}
