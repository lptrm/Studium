package training;

public class DirectedWeightedEdge extends WeightedEdge {
    Node predecessor;
    Node successor;

    public DirectedWeightedEdge(Node node1, Node node2, int costs) {
        super(node1, node2, costs);
        this.predecessor = node1;
        this.successor = node2;
    }
}
