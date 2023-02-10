package training;

import java.util.Objects;
import java.util.Set;

public class Edge {
    public Node node1, node2;
    public Edge(Node edon1, Node edon2){
        this.node1 = edon1;
        this.node2 = edon2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Edge edge)) return false;
        return Objects.equals(node1, edge.node1) && Objects.equals(node2, edge.node2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(node1, node2);
    }
}
