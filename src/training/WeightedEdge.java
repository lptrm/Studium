package training;

public class WeightedEdge extends Edge{
        public int costs;
    public WeightedEdge(Node edon1, Node edon2, int costs) {
        super(edon1, edon2);
        this.costs = costs;
    }

}
