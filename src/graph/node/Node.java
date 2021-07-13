package graph.node;

/**
 * Clase para guardar los valores que contiene cada nodo.
 * Esta clase guardara la informacion correspondiente a una
 * conexion entre dos nodos para poder implementar esta clase
 * en el uso de los distintos grafos.
 * Se guardara el nodo del cual se origina la direccion, el
 * nodo hacia el cual se dirige la conexion, y el costo de
 * la arista en caso de que se trate de un grafo ponderado.
 *
 * @author David Fidgett
 */
public class Node {
    /**
     * Nodo Origen
     */
    public int srcNode;
    /**
     * Nodo Destino
     */
    public int destNode;
    /**
     * Costo de la Arista
     */
    public int weight;
    Diccionario d = new Diccionario();

    /**
     * Metodo constructor de una conexion.
     * Recibe el nodo origen, el nodo destino, y el
     * costo de la arista que conextara a estos dos.
     * @param srcNode Nodo Origen
     * @param destNode Nodo Destino
     * @param weight Costo de la Arista
     */
    public Node(int srcNode, int destNode, int weight){
        this.srcNode = srcNode;
        this.destNode = destNode;
        this.weight = weight;
    }

    /**
     * Metodo constructor de una conexion.
     * Recibe el nodo origen, el nodo destino, y el
     * costo de la arista que conextara a estos dos.
     * @param srcNode Nodo Origen
     * @param destNode Nodo Destino
     * @param weight Costo de la Arista
     */
    public Node(char srcNode, char destNode, int weight){
        int src = Character.getNumericValue(srcNode) - 10;
        int dest = Character.getNumericValue(destNode) - 10;
        this.srcNode = src;
        this.destNode = dest;
        this.weight = weight;
    }

    /**
     * Metodo constructor de una conexion.
     * Recibe el nodo origen, el nodo destino, y asigna
     * un costo de la arista de 0, indicando que se esta
     * trabajando en un grafo no ponderado.
     * @param srcNode Nodo Origen
     * @param destNode Nodo Destino
     */
    public Node(int srcNode, int destNode){
        this.srcNode = srcNode;
        this.destNode = destNode;
        weight = 0;
    }

    /**
     * Metodo constructor de una conexion.
     * Recibe el nodo origen, el nodo destino, y asigna
     * un costo de la arista de 0, indicando que se esta
     * trabajando en un grafo no ponderado.
     * @param srcNode Nodo Origen
     * @param destNode Nodo Destino
     */
    public Node(char srcNode, char destNode){
        int src = Character.getNumericValue(srcNode) - 10;
        int dest = Character.getNumericValue(destNode) - 10;
        this.srcNode = src;
        this.destNode = dest;
        weight = 0;
    }

    /**
     * Imprime la informacion de la conexion.
     * Este metodo imprime el nodo destino al cual el
     * nodo origen se encuentra conectado. Si se trata de un grafo
     * ponderado, tambien mostrara el costo de la arista que conecta
     * a estos dos.
     */
    public void print(){
        String dest = d.get(destNode).toString();
        if (weight > 0){
            System.out.printf(" -> [%s|%d]", dest, weight);
        } else {
            System.out.printf(" -> [%s]", dest);
        }
    }

    /**
     * Imprime la informacion de la conexion.
     * Este metodo imprime el nodo destino al cual el
     * nodo origen se encuentra conectado. Si se trata de un grafo
     * ponderado, tambien mostrara el costo de la arista que conecta
     * a estos dos.
     */
    public void printNum(){
        if (weight > 0){
            System.out.printf(" -> [%d|%d]", destNode, weight);
        } else {
            System.out.printf(" -> [%d]", destNode);
        }
    }

    /**
     * Imprime informacion de la conexion.
     * Este metodo imprime la informacion de la conexion entre los nodos.
     * Este metodo principalmente se utiliza cuando se esta generando un
     * arbol de expansion. Imprimira el nodo origen, el costo de la arista
     * y el nodo destino.
     */
    public void printSWD(){
        String src = d.get(srcNode).toString();
        String dest = d.get(destNode).toString();
        System.out.printf("[%s-|%d|->%s]", src, weight, dest);
    }

}

