
package training;

import java.util.*;

public class GraphOwn {
    Set<Node> nodes;
    Set<WeightedEdge> edges;
    Adjazenzmatrix adjazenzmatrix;

    public GraphOwn() {
        this.nodes = new HashSet<>();
        this.edges = new HashSet<>();
        this.adjazenzmatrix = null;
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
        graph.adjazenzmatrix = new Adjazenzmatrix(graph.nodes, graph.edges);
        System.out.println(graph.adjazenzmatrix);
        DijkstraTable test = graph.Dijkstra(u);
        test = graph.Dijkstra(w);
    }

    public GraphOwn addEdge(Node node1, Node node2, int costs) {
        this.edges.add(new WeightedEdge(node1, node2, costs));
        return this;
    }

    public void addNode(Node node) {
        this.nodes.add(node);
    }

    public DijkstraTable Dijkstra(Node source) {
        int matrixVectorScope;
        int currentCosts = 0;
        Node scope = source;
        Set<DijkstraTupel> reachable = new HashSet<>();
        Set<Node> visited = new HashSet<>();
        //Init
        for (Node e :
                this.nodes) {
            if (!e.equals(source)) {
                reachable.add(new DijkstraTupel(e, null, Integer.MAX_VALUE));
            }
            visited.add(e);
        }
        //Iterative Algorithm
        for (int j = 0; j < reachable.size(); j++) {
            matrixVectorScope = getVector(scope);
            for (DijkstraTupel e : reachable) {
                int matrixVectorTarget = getVector(e.destination);
                if (this.adjazenzmatrix.matrix[matrixVectorScope][matrixVectorTarget] != 0) {
                    if ((this.adjazenzmatrix.matrix[matrixVectorScope][matrixVectorTarget] + currentCosts) < e.costs) {
                        e.costs = this.adjazenzmatrix.matrix[matrixVectorScope][matrixVectorTarget] + currentCosts;
                        e.destination = this.adjazenzmatrix.nodes[matrixVectorTarget];
                        e.predecessor = scope;
                    }
                }
            }
            currentCosts = Integer.MAX_VALUE;
            visited.remove(scope);
            for (DijkstraTupel e : reachable) {
                if (visited.contains(e.destination) && e.costs < currentCosts) {
                    scope = e.destination;
                    currentCosts = e.costs;
                }
            }
        }
        reachable.forEach(System.out::println);
        return null;
    }

    public int getVector(Node source) {
        int i = 0;
        for (Node e : this.adjazenzmatrix.nodes) {
            if (source.equals(e)) break;
            i++;
        }
        return i;
    }

}


