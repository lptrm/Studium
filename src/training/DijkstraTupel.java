package training;

import java.util.Objects;

public class DijkstraTupel {
    public Node destination;
    public Node predecessor;
    public int costs;
    public DijkstraTupel(Node dest, Node pre, int costs){
        this.destination = dest;
        this.predecessor = pre;
        this.costs = costs;
    }
    @Override
    public String toString(){
        return this.destination + " über " + this.predecessor + " Kosten: " +this.costs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DijkstraTupel that)) return false;
        return costs == that.costs && Objects.equals(destination, that.destination) && Objects.equals(predecessor, that.predecessor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destination, predecessor, costs);
    }
}
