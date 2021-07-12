package graph;

import graph.node.Diccionario;
import graph.node.Node;

import java.util.LinkedList;

public class Graph {
    private final int V;
    protected LinkedList<Node>[] adjArray;
    private final Diccionario d;

    public Graph(int v){
        V = v;
        adjArray = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adjArray[i] = new LinkedList<>();
        }
        d = new Diccionario();
    }

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

    protected int convert(String s){
        char c = s.charAt(0);
        return Character.getNumericValue(c) - 10;
    }

    protected int convert(char c){
        return Character.getNumericValue(c) - 10;
    }

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

    public void DFS(int v){
        boolean[] visited = new boolean[V];
        StringBuilder sb = new StringBuilder(" {");
        DFSUtil(v, visited, sb);
        sb.append("}");
        String visitedNodes = sb.toString();
        System.out.println(" DFS: ");
        System.out.println(visitedNodes);
    }

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
