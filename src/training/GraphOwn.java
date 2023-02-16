
package training;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class GraphOwn {
    Set<Node> nodes;
    Set<WeightedEdge> edges;
    public GraphOwn(){
        this.nodes = new HashSet<>();
        this.edges =  new HashSet<>();
    }

    public static void main(String[] args) {
        Node u = new Node("U");
        Node v = new Node("V");
        Node w = new Node("W");
        Node x = new Node("X");
        Node y = new Node("Y");
        Node z = new Node("Z");
        GraphOwn graph = new GraphOwn();
        graph.addNode(u);
        graph.addNode(v);
        graph.addNode(w);
        graph.addNode(x);
        graph.addNode(y);
        graph.addNode(z);
        graph.addEdge(u, v, 2).addEdge(u, w, 5).addEdge(u, x, 1).addEdge(v, w, 3)
                .addEdge(v, x, 2).addEdge(w, x, 3).addEdge(w, y, 1).addEdge(w, z, 5)
                .addEdge(x, y, 1).addEdge(y, z, 2);
        Adjazenzmatrix adjazenzmatrix = new Adjazenzmatrix(graph.nodes, graph.edges);
        System.out.println(adjazenzmatrix);
    }

public GraphOwn addEdge(Node node1, Node node2, int costs){
        this.edges.add(new WeightedEdge(node1, node2, costs));
        return this;
}
    public void addNode(Node node){
        this.nodes.add(node);
    }

/*
    public HashMap<Node,String> dijkstra(Node source){
        HashMap<Node, String> res = new HashMap<>();
        Set<Node> visited;
        Node current = source;
        for (Node node : this.nodes){

        }

    }

 */
}


