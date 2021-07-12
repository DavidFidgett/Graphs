package graph;

import graph.node.Node;

public class SimpleGraph extends Graph{
    public SimpleGraph(int v){
        super(v);
    }

    public void addEdge(int srcNode, int destNode){
        if (!existingConnection(srcNode, destNode)){
            Node n1 = new Node(srcNode, destNode);
            Node n2 = new Node(destNode, srcNode);
            adjArray[srcNode].add(n1);
            adjArray[destNode].add(n2);
        }
    }

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

    public void removeEdge(int srcNode, int destNode){
        int index1 = indexOfConnection(srcNode, destNode, 0);
        int index2 = indexOfConnection(destNode, srcNode, 0);
        if (index1 != -1 && index2 != -1){
            adjArray[srcNode].remove(index1);
            adjArray[destNode].remove(index2);
        }
    }

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


    private boolean existingConnection(int srcNode, int destNode){
        int connection1 = indexOfConnection(srcNode, destNode, 0);
        int connection2 = indexOfConnection(destNode, srcNode, 0);
        return connection1 != -1 && connection2 != -1;
    }

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
