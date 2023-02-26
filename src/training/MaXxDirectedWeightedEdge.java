package training;

public class MaXxDirectedWeightedEdge extends Edge{
    double costs;
    Node predecessor;
    Node successor;
    MaXxNodeWrapper src, dst;
    public MaXxDirectedWeightedEdge(MaXxNodeWrapper nodeWrapper1, MaXxNodeWrapper nodeWrapper2, double costs) {
        super(nodeWrapper1.node, nodeWrapper2.node);
        this.src = nodeWrapper1;
        this.dst = nodeWrapper2;
        this.predecessor = node1;
        this.successor = node2;
        this.costs = costs;
    }
}
