package graph;

import graph.node.Node;

public class DirectedGraph extends Graph{
    public DirectedGraph(int v) {
        super(v);
    }

    public void addEdge(int srcNode, int destNode){
        if (indexOfConnection(srcNode, destNode, 0) == -1){
            Node node = new Node(srcNode, destNode);
            adjArray[srcNode].add(node);
        }
    }

    public void addEdge(String src, String dest){
        int srcNode = convert(src);
        int destNode = convert(dest);
        if (indexOfConnection(srcNode, destNode, 0) == -1){
            Node node = new Node(srcNode, destNode);
            adjArray[srcNode].add(node);
        }
    }

    public void removeEdge(int srcNode, int destNode){
        int index = indexOfConnection(srcNode, destNode, 0);
        if (index != -1){
            adjArray[srcNode].remove(index);
        }
    }

    public void removeEdge(String src, String dest){
        int srcNode = convert(src);
        int destNode = convert(dest);
        int index = indexOfConnection(srcNode, destNode, 0);
        if (index != -1){
            adjArray[srcNode].remove(index);
        }
    }

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
