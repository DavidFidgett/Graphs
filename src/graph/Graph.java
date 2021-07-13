package graph;

import graph.node.Diccionario;
import graph.node.Node;

import java.util.LinkedList;

/**
 * Clase para implementacion de Grafos.
 * Esta clase contiene el metodo constructor general  y los metodos
 * generales para todos los
 * diferentes tipos de grafos a implementar (grafo simple, direccionado,
 * ponderado, direccionado y ponderado).
 *
 * @author David Fidgett
 */
public class Graph {
    /**
     * Cantidad de nodos que contiene el grafo.
     */
    private final int V;
    /**
     * Arreglo de listas ligadas que contienen objetos del tipo
     * {@link Node}, las cuales contienen la lista de adyacencia de
     * cada nodo en el grafo.
     */
    protected LinkedList<Node>[] adjArray;
    /**
     * {@link Diccionario} que sirve para poder implenentar los grafos
     * ya sea mostrando numeros o letras.
     */
    private final Diccionario d;

    /**
     * Metodo constructor del grafo.
     * Crea un nuevo grafo con v cantidad de nodos, e inicializa
     * el arreglo de listas ligadas para poder utilizarlo posteriormente.
     * @param v Numero de nodos que contendra el grafo
     */
    public Graph(int v){
        V = v;
        adjArray = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adjArray[i] = new LinkedList<>();
        }
        d = new Diccionario();
    }

    /**
     * Imprime la lista de adyacencia del grafo.
     * Recorre el arreglo de listas ligadas, e imprime la lista de
     * adyacencia de cada nodo, teniendo como impresion final la lista
     * de adyacencia correspondiente al grafo en cuestion
     */
    public void print(){
        for (int i = 0; i < V; i++) {
            char c = d.get(i);
            System.out.println(" Lista de adyacencia del vertice " + c + ": ");
            System.out.print(" " + c);
            for (Node node : adjArray[i]) {
                node.print();
            }
            System.out.println();
        }
    }

    /**
     * Imprime la lista de adyacencia del grafo.
     * Recorre el arreglo de listas ligadas, e imprime la lista de
     * adyacencia de cada nodo, teniendo como impresion final la lista
     * de adyacencia correspondiente al grafo en cuestion
     */
    public void printNum(){
        for (int i = 0; i < V; i++) {
            System.out.println(" Lista de adyacencia del vertice " + i + ": ");
            System.out.print(" " + i);
            for (Node node : adjArray[i]) {
                node.printNum();
            }
            System.out.println();
        }
    }

    /**
     * Metodo para obtener el indice de una conexion entre dos nodos.
     * Este metodo toma como valores de entrada el nodo origen, el nodo destino, y
     * el costo de la arista de la conexion de la cual se quiere obtener el indice
     * en el que se encuentra esta conexion en la lista ligada correspondiente
     * al nodo origen.
     * Util para saber si ya existe esta conexion previamente, o si no existe.
     * En caso de que la conexion entre estos nodos exista, con el costo de arista
     * correspondiente, retornara el indice en el que se encuentra dicha conexion
     * entre ambos nodos en la lista ligada correspondiente al nodo origen.
     * Si la conexion no existe, se retornara un -1.
     * @param srcNode Nodo Origen
     * @param destNode Nodo Destino
     * @param weight Costo de la Arista
     * @return Indice de la conexion entre los dos nodos ingresados.
     */
    protected int indexOfConnection(int srcNode, int destNode, int weight){
        int size = adjArray[srcNode].size();
        for (int i = 0; i < size; i++) {
            Node n = adjArray[srcNode].get(i);
            if (n.srcNode == srcNode && n.destNode == destNode && n.weight == weight){
                return i;
            }
        }
        return -1;
    }

    /**
     * Convierte el primer caracter de un String a su valor numerico correspondiente.
     * @param s String a convertir
     * @return Valor numerico correspondiente
     */
    protected int convert(String s){
        char c = s.charAt(0);
        return Character.getNumericValue(c) - 10;
    }

    /**
     * Convierte el caracter ingresado a su valor numerico correspondiente.
     * @param c Caracter a convertir
     * @return Valor numerico correspondiente
     */
    protected int convert(char c){
        return Character.getNumericValue(c) - 10;
    }

    /**
     * Implementacion de Busqueda por Expansion (BFS).
     * Dado un nodo origen ingresado a la funcion, este algoritmo realizara
     * una busqueda por expansion (Breadth First Search) de todos los nodos a
     * los que se pueden llegar a partir del nodo inicial.
     * Se crea un arreglo de booleanos cuyo tamaño sera igual a la cantidad
     * de vertices que existen en el grafo.
     * Se verificara en primera instancia el nodo el cual se este revisando
     * en la iteracion. Apoyandonos en el arreglo de booleanos visited, y con
     * su correspondencia entre sus indices y el numero de nodo, verificamos
     * si este nodo ha sido "visitado". Si este nodo no ha sido
     * visitado, agregamos este nodo a un queue.
     * Para las siguientes iteraciones del algoritmo, se hara un poll al
     * queue (este proceso se repetira hasta que el queue se encuentre
     * vacio) y se recorrera la lista de adyacencia correspondiente a dicho
     * nodo. Se verificaran los nodos adyacentes a este nodo utilizando el
     * arreglo de booleanos. Si alguno de los nodos adyacentes no ha sido
     * visitado, se agregara al queue, para que posteriormente se pueda
     * repetir este proceso hasta haber recorrido todos los nodos posibles
     * a partir del nodo inicial especificado.
     * @param src Nodo inicial
     */
    public void BFS(int src){
        boolean[] visited = new boolean[V];
        StringBuilder sb = new StringBuilder(" {");
        LinkedList<Integer> queue = new LinkedList<>();
        visited[src] = true;
        queue.add(src);
        while (!queue.isEmpty()){
            src = queue.poll();
            char c = d.get(src);
            sb.append("[").append(c).append("]");
            for (Node node : adjArray[src]) {
                if (!visited[node.destNode]){
                    visited[node.destNode] = true;
                    queue.add(node.destNode);
                }
            }
        }
        sb.append("}");
        String visitedNodes = sb.toString();
        System.out.println(" BFS: ");
        System.out.println(visitedNodes);
    }

    /**
     * Implementacion de Busqueda por Expansion (BFS).
     * Dado un nodo origen ingresado a la funcion, este algoritmo realizara
     * una busqueda por expansion (Breadth First Search) de todos los nodos a
     * los que se pueden llegar a partir del nodo inicial.
     * Se crea un arreglo de booleanos cuyo tamaño sera igual a la cantidad
     * de vertices que existen en el grafo.
     * Se verificara en primera instancia el nodo el cual se este revisando
     * en la iteracion. Apoyandonos en el arreglo de booleanos visited, y con
     * su correspondencia entre sus indices y el numero de nodo, verificamos
     * si este nodo ha sido "visitado". Si este nodo no ha sido
     * visitado, agregamos este nodo a un queue.
     * Para las siguientes iteraciones del algoritmo, se hara un poll al
     * queue (este proceso se repetira hasta que el queue se encuentre
     * vacio) y se recorrera la lista de adyacencia correspondiente a dicho
     * nodo. Se verificaran los nodos adyacentes a este nodo utilizando el
     * arreglo de booleanos. Si alguno de los nodos adyacentes no ha sido
     * visitado, se agregara al queue, para que posteriormente se pueda
     * repetir este proceso hasta haber recorrido todos los nodos posibles
     * a partir del nodo inicial especificado.
     * @param s Nodo inicial
     */
    public void BFS(String s){
        int src = convert(s);
        boolean[] visited = new boolean[V];
        StringBuilder sb = new StringBuilder(" {");
        LinkedList<Integer> queue = new LinkedList<>();
        visited[src] = true;
        queue.add(src);
        while (!queue.isEmpty()){
            src = queue.poll();
            char c = d.get(src);
            sb.append("[").append(c).append("]");
            for (Node node : adjArray[src]) {
                if (!visited[node.destNode]){
                    visited[node.destNode] = true;
                    queue.add(node.destNode);
                }
            }
        }
        sb.append("}");
        String visitedNodes = sb.toString();
        System.out.println(" BFS: ");
        System.out.println(visitedNodes);
    }

    /**
     * Implementacion de Busqueda en Profundidad (DFS).
     * Partiendo del nodo v ingresado, se creara un arreglo de booleanos con un
     * tamaño V correspondiente al numero de vertices que existen en el grafo.
     * Se hace uso de la funcion recursiva
     * {@link #DFSUtil(int, boolean[], StringBuilder)} para la implementacion de
     * este tipo de busqueda.
     * @param v Nodo inicial
     */
    public void DFS(int v){
        boolean[] visited = new boolean[V];
        StringBuilder sb = new StringBuilder(" {");
        DFSUtil(v, visited, sb);
        sb.append("}");
        String visitedNodes = sb.toString();
        System.out.println(" DFS: ");
        System.out.println(visitedNodes);
    }

    /**
     * Implementacion de Busqueda en Profundidad (DFS).
     * Partiendo del nodo v ingresado, se creara un arreglo de booleanos con un
     * tamaño V correspondiente al numero de vertices que existen en el grafo.
     * Se hace uso de la funcion recursiva
     * {@link #DFSUtil(int, boolean[], StringBuilder)} para la implementacion de
     * este tipo de busqueda.
     * @param s Nodo inicial
     */
    public void DFS(String s){
        int v = convert(s);
        boolean[] visited = new boolean[V];
        StringBuilder sb = new StringBuilder(" {");
        DFSUtil(v, visited, sb);
        sb.append("}");
        String visitedNodes = sb.toString();
        System.out.println(" DFS: ");
        System.out.println(visitedNodes);
    }

    /**
     * Implementacion recursiva de DFS.
     * El nodo ingresado a esta funcion sera marcado como visitado en
     * el arreglo de booleanos creado previamente en la funcion
     * {@link #DFS(int)}, posteriormente se verificaran los nodos
     * adyacentes al nodo ingresado a la funcion. Si el nodo adyacente
     * que se esta revisando no ha sido visitado, se hace una llamada
     * recursiva a esta misma funcion, y se repite el proceso descrito
     * con anterioridad.
     * El caso base de este metodo sera cuando ya se hayan revisado todos
     * los nodos adyacentes de todos los nodos en la lista de adyacencia del
     * grafo, dandonos como resultado una lista con todos los nodos del grafo
     * visitados a partir del nodo inicial.
     * @param v Nodo a marcar como visitado.
     * @param visited Arreglo de booleanos.
     * @param sb StringBuilder para impresion de la secuencia del recorrido.
     */
    private void DFSUtil(int v, boolean[] visited, StringBuilder sb){
        visited[v] = true;
        char c = d.get(v);
        sb.append("[").append(c).append("]");
        for (Node node : adjArray[v]) {
            if (!visited[node.destNode]){
                DFSUtil(node.destNode, visited, sb);
            }
        }
    }

}
