package training;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Node {
    public String name;

    public Node(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node node)) return false;
        return Objects.equals(name, node.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
