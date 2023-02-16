package training;

import java.util.Objects;

public class Node implements Comparable<Node>{
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
    @Override
    public String toString(){
        return this.name;
    }
    @Override
    public int compareTo(Node other) {
        return this.name.compareTo(other.name);
    }
}
