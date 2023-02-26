package training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class MaXxAdjazenzmatrix {
    public final double[][] matrix;
    public final MaXxNodeWrapper[] nodes;

    public MaXxAdjazenzmatrix(ArrayList<MaXxNodeWrapper> nodes1, ArrayList<MaXxDirectedWeightedEdge> edges){
        nodes = new MaXxNodeWrapper[nodes1.size()];
        matrix = new double[nodes1.size()][nodes1.size()];
        int i = 0;
        //ToDo: sortieren? https://www.baeldung.com/java-8-collectors
        for (MaXxNodeWrapper n : nodes1){
            nodes[i++] = n;
        }
        for (MaXxDirectedWeightedEdge edge : edges){
            double costs = edge.costs;
            MaXxNodeWrapper node1 = edge.src;
            int posNode1 = Arrays.binarySearch(nodes, node1);
            MaXxNodeWrapper node2 = edge.dst;
            int posNode2 = Arrays.binarySearch(nodes, node2);
            matrix[posNode1][posNode2] = costs;
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
