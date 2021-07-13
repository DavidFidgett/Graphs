package graph;

import graph.node.Node;
import graph.node.NodeComparator;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Implementacion de Grafo Ponderado No Dirigido.
 */
public class WeightedGraph extends Graph{
    /**
     * Metodo contructor del Grafo.
     * @param v Numero de nodos que contendra el grafo.
     */
    public WeightedGraph(int v) {
        super(v);
    }

    /**
     * Agrega una arista entre un par no ordenado de nodos.
     * Dados dos nodos ingresados, genera una conexion entre
     * estos dos, con una arista con costo, lo cual representa
     * que se trata de un grafo ponderado.
     * Ademas, la conexion se genera tanto como desde el nodo origen
     * como para el nodo destino, indicando que se esta utilizando un
     * grafo no dirigido.
     * Previo a la creacion de esta conexion, se revisa que no exista
     * esta conexion previamente, para no generar redundancias en las
     * listas de adyacencias.
     * @param srcNode Nodo Origen
     * @param destNode Nodo Destino
     * @param weight Costo de la Arista
     */
    public void addEdge(int srcNode, int destNode, int weight){
        if (!existingConnection(srcNode, destNode, weight)){
            Node n1 = new Node(srcNode, destNode, weight);
            Node n2 = new Node(destNode, srcNode, weight);
            adjArray[srcNode].add(n1);
            adjArray[destNode].add(n2);
        }
    }

    /**
     * Agrega una arista entre un par no ordenado de nodos.
     * Dados dos nodos ingresados, genera una conexion entre
     * estos dos, con una arista con costo, lo cual representa
     * que se trata de un grafo ponderado.
     * Ademas, la conexion se genera tanto como desde el nodo origen
     * como para el nodo destino, indicando que se esta utilizando un
     * grafo no dirigido.
     * Previo a la creacion de esta conexion, se revisa que no exista
     * esta conexion previamente, para no generar redundancias en las
     * listas de adyacencias.
     * @param src Nodo Origen
     * @param dest Nodo Destino
     * @param weight Costo de la Arista
     */
    public void addEdge(String src, String dest, int weight){
        int srcNode = convert(src);
        int destNode = convert(dest);
        if (!existingConnection(srcNode, destNode, weight)){
            Node n1 = new Node(srcNode, destNode, weight);
            Node n2 = new Node(destNode, srcNode, weight);
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
     * @param weight Costo de la Arista
     */
    public void removeEdge(int srcNode, int destNode, int weight){
        int index1 = indexOfConnection(srcNode, destNode, weight);
        int index2 = indexOfConnection(destNode, srcNode, weight);
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
     * @param weight Costo de la Arista
     */
    public void removeEdge(String src, String dest, int weight){
        int srcNode = convert(src);
        int destNode = convert(dest);
        int index1 = indexOfConnection(srcNode, destNode, weight);
        int index2 = indexOfConnection(destNode, srcNode, weight);
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
     * @param weight Costo de la Arista
     * @return Existencia de la conexion entre los nodos
     */
    private boolean existingConnection(int srcNode, int destNode, int weight){
        int connection1 = indexOfConnection(srcNode, destNode, weight);
        int connection2 = indexOfConnection(destNode, srcNode, weight);
        return connection1 != -1 && connection2 != -1;
    }

    /**
     * Metodo para cargar un grafo desde un arreglo tridimensional.
     * Ingresando a este metodo un arreglo tridimensional de numeros
     * enteros, este metodo utilizara los valores del arreglo para
     * generar un nuevo grafo con las conexiones ya especificadas.
     * El primer conjunto de arreglos nos indicara el nodo origen al cual
     * nos estamos refiriendo, mientras que su subarreglo contendra la
     * informacion de los nodos adyacentes a este nodo origen.
     * Los subarreglos del subarreglo contendran en su indice "0" el
     * nodo destino correspondiente al nodo origen indicado, y en su
     * indice "1" el costo de la arista que unira a este par de nodos
     * ordenados.
     * El tamaño del arreglo correspondera a la cantidad de nodos que
     * tendra el grafo, el tamaño del subarreglo indicara la cantidad de
     * nodos adyacentes con los que cuenta cada uno de sus respectivos
     * nodos origen, mientras que el tamaño de los subsubarreglos siempre
     * sera de dos.
     * @param adjList Arreglo tridimensional con los valores del grafo
     * @return Grafo Ponderado No Dirigido
     */
    public static WeightedGraph loadGraph(int[][][] adjList){
        int n = adjList.length;
        WeightedGraph graph = new WeightedGraph(n);
        for (int i = 0; i < n; i++) {
            for (int[] j : adjList[i]) {
                graph.addEdge(i, j[0], j[1]);
            }
        }
        return graph;
    }

    /**
     * Implementacion del Algoritmo de Primm.
     * Con el objetivo de obtener un arbol de expansion minima (MST, o
     * Minimum Spanning Tree) a partir de un nodo origen v, este algoritmo
     * buscara obtener un subgrafo a partir del grafo original el cual contenga
     * un costo total de las aristas minimo, y que las aristas que conformen
     * este subgrafo no generen ningun ciclo.
     * Para esta implementacion, se utiliza un arreglo de booleanos cuyo
     * tamaño sera el mismo que el numero de vertices que conforman nuestro
     * grafo.
     * De igual manera, se crea una nueva lista ligada de nodos que contendra
     * a los nodos con sus respectivas conexiones que formaran este nuevo
     * subgrafo, y tambien se utilizara una queue de prioridad para poder
     * cumplir con el objetivo de obtener el menor costo posible dentro
     * del grafo.
     * En la implementacion de este priorityqueue, y considerando que se
     * utilizo un tipo de dato abstracto creado para esta implementacion
     * (Node), fue necesaria la creacion de un nuevo comparador
     * {@link NodeComparator#compare(Node, Node)} para poder indicar
     * de forma adecuada de que forma se manejaria la prioridad de valores
     * en el queue. En este nuevo comparador, se asigno que la comparacion
     * fuera usando el valor {@link Node#weight} de los nodos, donde a menor
     * costo de la arista, mayor seria la prioridad de este nodo en el queue, por
     * lo cual seria asignado de forma prioritaria en el conjunto de datos.
     * Utilizando estas estructuras mencionadas previamente, agregamos a nuestro
     * priorityQueue todos los nodos adyacentes del nodo inicial que asignamos como
     * valor de entrada del metodo. Estos seran acomodados en el priorityQueue de
     * acuerdo al costo de la arista de cada conexion que tengan con respecto al nodo
     * origen. El nodo inicial sera marcado como visitado en nuestro arreglo de
     * boolanos y se procedera al siguiente proceso del algoritmo.
     * Mientras el priorityQueue se encuentre vacio, iremos extrayendo los valores
     * que este contenga con el metodo poll para ir obteniendo los valores conforme
     * a su menor costo de arista correspondan.
     * Una vez obtenida esta conexion, se verificara si el nodo destino de esta
     * conexion se encuentra marcado como visitado en nuestro arreglo de booleanos.
     * En el caso de que este nodo destino ya haya sido visitado, seguiremos extrayendo
     * valores del priorityqueue hasta que obtengamos alguna conexion cuyo nodo destino
     * no este marcado como visitado, o hasta que el priorityqueue se encuentre vacio.
     * Si la conexion extraida del priorityqueue tiene como nodo destino uno que no
     * se encuentre como visitado en nuestro arreglo de booleanos, procederemos a
     * agregar esta conexion a nuestra lista ligada que contendra los valores del
     * arbol de expansion minima, agregaremos todos los nodos adyacentes a este nodo
     * destino a nuestro priorityqueue, y marcaremos dicho nodo destino como visitado
     * en nuestro arreglo de booleanos.
     * Una vez que el ciclo haya terminado, y tengamos las conexiones que conforman
     * al subgrafo correspondiente al MST en la lista ligada correspondiente, obtendremos
     * de este subgrafo la suma de los costos de todas las aristas que los conforman
     * para obtener el costo total de nuestro arbol de expansion minima.
     * Se mostrara en pantalla este conjunto de conexiones que conforman al MST, y
     * retornaremos como valor el costo total.
     * @param v Nodo Inicial
     * @return Costo Total del MST
     */
    public int primm(int v){
        boolean[] visited = new boolean[adjArray.length];
        int totalWeight = 0;
        LinkedList<Node> MST = new LinkedList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>(adjArray[v].size(), new NodeComparator());
        pq.addAll(adjArray[v]);
        visited[v] = true;
        while (!pq.isEmpty()){
            Node node = pq.poll();
            if (!visited[node.destNode]){
                MST.add(node);
                pq.addAll(adjArray[node.destNode]);
                visited[node.destNode] = true;
            }
        }
        System.out.println(" MST: ");
        System.out.print(" {");
        for (Node node : MST) {
            node.printSWD();
            totalWeight += node.weight;
        }
        System.out.println("}");
//        System.out.println(" Total Weight: " + totalWeight);
        return totalWeight;
    }

    /**
     * Implementacion del Algoritmo de Primm.
     * Con el objetivo de obtener un arbol de expansion minima (MST, o
     * Minimum Spanning Tree) a partir de un nodo origen v, este algoritmo
     * buscara obtener un subgrafo a partir del grafo original el cual contenga
     * un costo total de las aristas minimo, y que las aristas que conformen
     * este subgrafo no generen ningun ciclo.
     * Para esta implementacion, se utiliza un arreglo de booleanos cuyo
     * tamaño sera el mismo que el numero de vertices que conforman nuestro
     * grafo.
     * De igual manera, se crea una nueva lista ligada de nodos que contendra
     * a los nodos con sus respectivas conexiones que formaran este nuevo
     * subgrafo, y tambien se utilizara una queue de prioridad para poder
     * cumplir con el objetivo de obtener el menor costo posible dentro
     * del grafo.
     * En la implementacion de este priorityqueue, y considerando que se
     * utilizo un tipo de dato abstracto creado para esta implementacion
     * (Node), fue necesaria la creacion de un nuevo comparador
     * {@link NodeComparator#compare(Node, Node)} para poder indicar
     * de forma adecuada de que forma se manejaria la prioridad de valores
     * en el queue. En este nuevo comparador, se asigno que la comparacion
     * fuera usando el valor {@link Node#weight} de los nodos, donde a menor
     * costo de la arista, mayor seria la prioridad de este nodo en el queue, por
     * lo cual seria asignado de forma prioritaria en el conjunto de datos.
     * Utilizando estas estructuras mencionadas previamente, agregamos a nuestro
     * priorityQueue todos los nodos adyacentes del nodo inicial que asignamos como
     * valor de entrada del metodo. Estos seran acomodados en el priorityQueue de
     * acuerdo al costo de la arista de cada conexion que tengan con respecto al nodo
     * origen. El nodo inicial sera marcado como visitado en nuestro arreglo de
     * boolanos y se procedera al siguiente proceso del algoritmo.
     * Mientras el priorityQueue se encuentre vacio, iremos extrayendo los valores
     * que este contenga con el metodo poll para ir obteniendo los valores conforme
     * a su menor costo de arista correspondan.
     * Una vez obtenida esta conexion, se verificara si el nodo destino de esta
     * conexion se encuentra marcado como visitado en nuestro arreglo de booleanos.
     * En el caso de que este nodo destino ya haya sido visitado, seguiremos extrayendo
     * valores del priorityqueue hasta que obtengamos alguna conexion cuyo nodo destino
     * no este marcado como visitado, o hasta que el priorityqueue se encuentre vacio.
     * Si la conexion extraida del priorityqueue tiene como nodo destino uno que no
     * se encuentre como visitado en nuestro arreglo de booleanos, procederemos a
     * agregar esta conexion a nuestra lista ligada que contendra los valores del
     * arbol de expansion minima, agregaremos todos los nodos adyacentes a este nodo
     * destino a nuestro priorityqueue, y marcaremos dicho nodo destino como visitado
     * en nuestro arreglo de booleanos.
     * Una vez que el ciclo haya terminado, y tengamos las conexiones que conforman
     * al subgrafo correspondiente al MST en la lista ligada correspondiente, obtendremos
     * de este subgrafo la suma de los costos de todas las aristas que los conforman
     * para obtener el costo total de nuestro arbol de expansion minima.
     * Se mostrara en pantalla este conjunto de conexiones que conforman al MST, y
     * retornaremos como valor el costo total.
     * @param str Nodo Inicial
     * @return Costo Total del MST
     */
    public int primm(String str){
        int v = convert(str);
        boolean[] visited = new boolean[adjArray.length];
        int totalWeight = 0;
        LinkedList<Node> MST = new LinkedList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>(adjArray[v].size(), new NodeComparator());
        pq.addAll(adjArray[v]);
        visited[v] = true;
        while (!pq.isEmpty()){
            Node node = pq.poll();
            if (!visited[node.destNode]){
                MST.add(node);
                pq.addAll(adjArray[node.destNode]);
                visited[node.destNode] = true;
            }
        }
        System.out.println(" MST: ");
        System.out.print(" {");
        for (Node node : MST) {
            node.printSWD();
            totalWeight += node.weight;
        }
        System.out.println("}");
        // System.out.println(" Total Weight: " + totalWeight);
        return totalWeight;
    }

}
