package training;

import java.util.HashSet;
import java.util.Set;

public class Node {
    public String name;
    public Set<Edge> edges;

    public Node(String name) {
        this.name = name;
        this.edges = new HashSet<>();
    }
    public Node addEdges(Edge edge){
        this.edges.add(edge);
        return this;
    }
    public void addEdge(Edge edge){
        this.edges.add(edge);
    }
}
