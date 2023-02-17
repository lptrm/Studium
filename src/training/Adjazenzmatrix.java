package training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class Adjazenzmatrix {
    public final int[][] matrix;
    public final Node[] nodes;

    public Adjazenzmatrix(Set<Node> nodes1, Set<WeightedEdge> edges){
        nodes = new Node[nodes1.size()];
        matrix = new int[nodes1.size()][nodes1.size()];
        int i = 0;
        //ToDo: sortieren? https://www.baeldung.com/java-8-collectors
        for (Node n : nodes1){
            nodes[i++] = n;
        }
        for (WeightedEdge edge : edges){
            int costs = edge.costs;
            Node node1 = edge.node1;
            int posNode1 = Arrays.binarySearch(nodes, node1);
            Node node2 = edge.node2;
            int posNode2 = Arrays.binarySearch(nodes, node2);
            matrix[posNode1][posNode2] = costs;
            matrix[posNode2][posNode1] = costs;
        }
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(Arrays.toString(this.nodes)).append("\n");
        for (int i = 0; i < nodes.length; i++){
            res.append(Arrays.toString(matrix[i])).append(" [").append(this.nodes[i]).append("]\n");
        }
        return res.toString();
    }
}
