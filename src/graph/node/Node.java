package graph.node;

import java.util.Comparator;

public class Node {
    public int srcNode;
    public int destNode;
    public int weight;
    Diccionario d = new Diccionario();

    public Node(int srcNode, int destNode, int weight){
        this.srcNode = srcNode;
        this.destNode = destNode;
        this.weight = weight;
    }

    public Node(char srcNode, char destNode, int weight){
        int src = Character.getNumericValue(srcNode) - 10;
        int dest = Character.getNumericValue(destNode) - 10;
        this.srcNode = src;
        this.destNode = dest;
        this.weight = weight;
    }

    public Node(int srcNode, int destNode){
        this.srcNode = srcNode;
        this.destNode = destNode;
        weight = 0;
    }

    public Node(char srcNode, char destNode){
        int src = Character.getNumericValue(srcNode) - 10;
        int dest = Character.getNumericValue(destNode) - 10;
        this.srcNode = src;
        this.destNode = dest;
        weight = 0;
    }

    public void print(){
        String dest = d.get(destNode).toString();
        if (weight > 0){
            System.out.printf(" -> [%s|%d]", dest, weight);
        } else {
            System.out.printf(" -> [%s]", dest);
        }
    }

    public void printNum(){
        if (weight > 0){
            System.out.printf(" -> [%d|%d]", destNode, weight);
        } else {
            System.out.printf(" -> [%d]", destNode);
        }
    }

    // SourceNode - Weight -> DestinationNode
    public void printSWD(){
        String src = d.get(srcNode).toString();
        String dest = d.get(destNode).toString();
        System.out.printf("[%s-|%d|->%s]", src, weight, dest);
    }

}

