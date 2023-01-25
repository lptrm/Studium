package training;

import java.util.*;

public class Graph {
    private Map<Vertex, HashMap<Vertex, Integer>> adjVertices;

    public Graph() {
        this.adjVertices = new HashMap<>();
    }

    public Map<Vertex, HashMap<Vertex, Integer>> getAdjVertices() {
        return adjVertices;
    }

    public void setAdjVertices(Map<Vertex, HashMap<Vertex, Integer>> adjVertices) {
        this.adjVertices = adjVertices;
    }
    void addVertex(String name){
        adjVertices.putIfAbsent(new Vertex(name), new HashMap<>());
    }
    void removeVertex(String name){
        Vertex v = new Vertex(name);
        adjVertices.values().stream().forEach(e -> e.remove(v));
        adjVertices.remove(new Vertex(name));
    }
    void addEdge(String name1, String name2, int costs) {
        Vertex v1 = new Vertex(name1);
        Vertex v2 = new Vertex(name2);
        adjVertices.get(v1).putIfAbsent(v2, costs);
        adjVertices.get(v2).putIfAbsent(v1, costs);
    }
    void removeEdge(String name1, String name2){
        Vertex v1 = new Vertex(name1);
        Vertex v2 = new Vertex(name2);
        HashMap<Vertex, Integer> eV1 = adjVertices.get(v1);
        HashMap<Vertex, Integer> eV2 = adjVertices.get(v2);
        if (eV1 != null) eV1.remove(v2);
        if (eV2 != null) eV2.remove(v1);
    }
    HashMap<Vertex, Integer> getAdjVertices(String name){
        return adjVertices.get(new Vertex(name));
    }
    public static Set<String> depthFirstTraversal(Graph graph, String root) {
        Set<String> visited = new LinkedHashSet<String>();
        Stack<String> stack = new Stack<String>();
        stack.push(root);
        while (!stack.isEmpty()) {
            String vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                HashMap<Vertex, Integer> hm = graph.getAdjVertices(vertex);
                hm.keySet().forEach(k -> stack.push(k.name));
            }
        }
        return visited;
    }
    public static Set<String> breadthFirstTraversal(Graph graph, String root) {
        Set<String> visited = new LinkedHashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.add(root);
        visited.add(root);
        while (!queue.isEmpty()) {
            String vertex = queue.poll();
            HashMap<Vertex, Integer> hm = graph.getAdjVertices(vertex);
            hm.keySet().forEach(k ->{
                if (!visited.contains(k.name)){
                    queue.add(k.name);
                    visited.add(k.name);
                }

            });
            }
        return visited;
    }

    /*
    public  HashMap<Vertex, HashMap<Vertex, Integer>> dijkstra(Vertex vertex){
        Set<String> visited = new LinkedHashSet<String>();
        Set<HashMap<Vertex, Integer>> reachable = new LinkedHashSet<>();
        Vertex scope = vertex;
        this.getAdjVertices().forEach((node, reachables) -> {
            if (reachables.containsKey(scope)) reachable.add();
        });
        this.getAdjVertices(vertex).forEach();
   }

     */


    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("U");
        graph.addVertex("V");
        graph.addVertex("W");
        graph.addVertex("X");
        graph.addVertex("Y");
        graph.addVertex("Z");
        graph.addEdge("U", "V", 2);
        graph.addEdge("U", "W", 5);
        graph.addEdge("U", "X", 1);
        graph.addEdge("V", "W", 3);
        graph.addEdge("V", "X", 2);
        graph.addEdge("W", "X", 3);
        graph.addEdge("W", "Y", 1);
        graph.addEdge("W", "Z", 5);
        graph.addEdge("X", "Y", 1);
        graph.addEdge("Y", "Z", 1);
        System.out.println(depthFirstTraversal(graph, "U").toString());
        System.out.println(breadthFirstTraversal(graph, "U").toString());

    }
}
