package training;

import java.util.HashSet;
import java.util.Set;

public class GraphOwn {
    Set<Node> nodes;
    Set<WeightedEdge> edges;
    public GraphOwn(){
        this.nodes = new HashSet<>();
        this.edges =  new HashSet<>();
    }
}
