package graph;

import graph.node.Node;

/**
 * Implementacion de Grafo No Ponderado No Dirigido.
 *
 * @author David Fidgett
 */
public class SimpleGraph extends Graph{
    /**
     * Metodo constructor del Grafo.
     * @param v Numero de nodos que contendra el grafo.
     */
    public SimpleGraph(int v){
        super(v);
    }

    /**
     * Agrega una arista entre un par no ordenado de nodos.
     * Dados dos nodos ingresados, genera una conexion entre
     * estos dos, con una arista de costo cero, lo cual representa
     * que se trata de un grafo no ponderado.
     * Ademas, la conexion se genera tanto como desde el nodo origen
     * como para el nodo destino, indicando que se esta utilizando un
     * grafo no dirigido.
     * Previo a la creacion de esta conexion, se revisa que no exista
     * esta conexion previamente, para no generar redundancias en las
     * listas de adyacencias.
     * @param srcNode Nodo Origen
     * @param destNode Nodo Destino
     */
    public void addEdge(int srcNode, int destNode){
        if (!existingConnection(srcNode, destNode)){
            Node n1 = new Node(srcNode, destNode);
            Node n2 = new Node(destNode, srcNode);
            adjArray[srcNode].add(n1);
            adjArray[destNode].add(n2);
        }
    }

    /**
     * Agrega una arista entre un par no ordenado de nodos.
     * Dados dos nodos ingresados, genera una conexion entre
     * estos dos, con una arista de costo cero, lo cual representa
     * que se trata de un grafo no ponderado.
     * Ademas, la conexion se genera tanto como desde el nodo origen
     * como para el nodo destino, indicando que se esta utilizando un
     * grafo no dirigido.
     * Previo a la creacion de esta conexion, se revisa que no exista
     * esta conexion previamente, para no generar redundancias en las
     * listas de adyacencias.
     * @param src Nodo Origen
     * @param dest Nodo Destino
     */
    public void addEdge(String src, String dest){
        int srcNode = convert(src);
        int destNode = convert(dest);
        if (!existingConnection(srcNode, destNode)){
            Node n1 = new Node(srcNode, destNode);
            Node n2 = new Node(destNode, srcNode);
            adjArray[srcNode].add(n1);
            adjArray[destNode].add(n2);
        }
    }

    /**
     * Elimina una conexion entre un par de nodos no ordenados.
     * Verificando inicialmente la existencia previa de una conexion
     * entre estos dos nodos, se borrara de las listas de adyacencia
     * correspondientes la conexion bilateral que existe entre ambos
     * nodos ingresados.
     * @param srcNode Nodo Origen
     * @param destNode Nodo Destino
     */
    public void removeEdge(int srcNode, int destNode){
        int index1 = indexOfConnection(srcNode, destNode, 0);
        int index2 = indexOfConnection(destNode, srcNode, 0);
        if (index1 != -1 && index2 != -1){
            adjArray[srcNode].remove(index1);
            adjArray[destNode].remove(index2);
        }
    }

    /**
     * Elimina una conexion entre un par de nodos no ordenados.
     * Verificando inicialmente la existencia previa de una conexion
     * entre estos dos nodos, se borrara de las listas de adyacencia
     * correspondientes la conexion bilateral que existe entre ambos
     * nodos ingresados.
     * @param src Nodo Origen
     * @param dest Nodo Destino
     */
    public void removeEdge(String src, String dest){
        int srcNode = convert(src);
        int destNode = convert(dest);
        int index1 = indexOfConnection(srcNode, destNode, 0);
        int index2 = indexOfConnection(destNode, srcNode, 0);
        if (index1 != -1 && index2 != -1){
            adjArray[srcNode].remove(index1);
            adjArray[destNode].remove(index2);
        }
    }

    /**
     * Metodo verificador de conexion entre dos nodos.
     * Apoyandonos del metodo {@link #indexOfConnection(int, int, int)}
     * y considerando que este metodo retornara un -1 en caso de que al
     * momento de querer obtener el indice de una conexion no existente, podemos
     * hacer uso de este valor para determinar si es que no existe una conexion
     * entre el par de nodos no ordenados que recibe el metodo, retornando un
     * True en caso de que la conexion exista, o un False si es que no existe
     * dicha conexion.
     * @param srcNode Nodo Origen
     * @param destNode Nodo Destino
     * @return Existencia de la conexion entre los nodos
     */
    private boolean existingConnection(int srcNode, int destNode){
        int connection1 = indexOfConnection(srcNode, destNode, 0);
        int connection2 = indexOfConnection(destNode, srcNode, 0);
        return connection1 != -1 && connection2 != -1;
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
     * @return Grafo No Ponderado No Dirigido
     */
    public static SimpleGraph loadGraph(int[][] adjList){
        int n = adjList.length;
        SimpleGraph graph = new SimpleGraph(n);
        for (int i = 0; i < n; i++) {
            for (int j : adjList[i]) {
                graph.addEdge(i, j);
            }
        }
        return graph;
    }

}
