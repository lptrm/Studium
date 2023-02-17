
package training;

import java.util.*;

public class GraphOwn {
    Set<Node> nodes;
    Set<WeightedEdge> edges;
    Adjazenzmatrix adjazenzmatrix;
    public GraphOwn(){
        this.nodes = new HashSet<>();
        this.edges =  new HashSet<>();
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
    }

public GraphOwn addEdge(Node node1, Node node2, int costs){
        this.edges.add(new WeightedEdge(node1, node2, costs));
        return this;
}
    public void addNode(Node node){
        this.nodes.add(node);
    }
public DijkstraTable Dijkstra(Node source){
        int matrixVector;
        int currentCosts = 0;
        int[] visited = new int[this.adjazenzmatrix.nodes.length];
        DijkstraTableCell[] minCosts = new DijkstraTableCell[this.adjazenzmatrix.nodes.length-1];
        Node scope = source;
    ArrayList<DijkstraTableCell> reachables = new ArrayList<>();


    for (int j = 0; j < this.adjazenzmatrix.nodes.length; j++){


        matrixVector = getVector(scope);
        visited[j] = matrixVector;

        int[] minimalCosts = {Integer.MAX_VALUE, 0};
    for (int i = 0; i < this.adjazenzmatrix.matrix[matrixVector].length; i++){
        if (i!=matrixVector && !notVisited(visited, i)){
            if (this.adjazenzmatrix.matrix[matrixVector][i]!=0){
                DijkstraTableCell tmp = new DijkstraTableCell();
                tmp.costs = this.adjazenzmatrix.matrix[matrixVector][i] + currentCosts;
                tmp.predecessor = scope;
                tmp.scope = this.adjazenzmatrix.nodes[i];
                tmp.step = j;
                reachables.add(tmp);
                if (minimalCosts[0]>tmp.costs){
                    minimalCosts[0] = tmp.costs;
                    minimalCosts[1] = i;
                }
            } else {
                DijkstraTableCell tmp = new DijkstraTableCell();
                tmp.step = j;
                reachables.add(tmp);
            }
        }
    }
    currentCosts += (minimalCosts[0]-currentCosts);
    scope = this.adjazenzmatrix.nodes[minimalCosts[1]];
    }
    reachables.forEach(System.out::println);




    System.out.println("lol");
    return null;
}
public int getVector(Node source){
        int i = 0;
    for (Node node : this.adjazenzmatrix.nodes){
        if (source.equals(node)) break;
        i++;
    }
    return i;
}
public boolean notVisited(int[] arr, int i){
        boolean tmp = false;
        for (int j : arr){
            tmp = i==j;
            if (tmp) break;
        }
        return tmp;
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


