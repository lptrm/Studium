package training;

import MaXx.Fraction;

import java.util.Objects;

public class MaXxNodeWrapper {
    Node node;
    Fraction value;

    @Override
    public String toString() {
        return "node" + this.node + "value: " + this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MaXxNodeWrapper that)) return false;
        return Objects.equals(node, that.node) && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(node, value);
    }

    public MaXxNodeWrapper(Node node, Fraction value) {
        this.node = node;
        this.value = value;
    }
}
