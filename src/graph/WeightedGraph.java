package graph;

import graph.node.Node;
import graph.node.NodeComparator;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class WeightedGraph extends Graph{
    public WeightedGraph(int v) {
        super(v);
    }

    public void addEdge(int srcNode, int destNode, int weight){
        if (!existingConnection(srcNode, destNode, weight)){
            Node n1 = new Node(srcNode, destNode, weight);
            Node n2 = new Node(destNode, srcNode, weight);
            adjArray[srcNode].add(n1);
            adjArray[destNode].add(n2);
        }
    }

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

    public void removeEdge(int srcNode, int destNode, int weight){
        int index1 = indexOfConnection(srcNode, destNode, weight);
        int index2 = indexOfConnection(destNode, srcNode, weight);
        if (index1 != -1 && index2 != -1){
            adjArray[srcNode].remove(index1);
            adjArray[destNode].remove(index2);
        }
    }

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

    private boolean existingConnection(int srcNode, int destNode, int weight){
        int connection1 = indexOfConnection(srcNode, destNode, weight);
        int connection2 = indexOfConnection(destNode, srcNode, weight);
        return connection1 != -1 && connection2 != -1;
    }

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
        System.out.println(" Total Weight: " + totalWeight);
        return totalWeight;
    }

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
