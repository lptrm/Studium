package training;

public class MaXxDirectedWeightedEdge extends Edge{
    double costs;
    Node predecessor;
    Node successor;
    public MaXxDirectedWeightedEdge(Node edon1, Node edon2, double costs) {
        super(edon1, edon2);
        this.predecessor = node1;
        this.successor = node2;
        this.costs = costs;
    }
}
