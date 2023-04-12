package training;

import MaXxServerClient.Fraction;

import java.util.Objects;

public class MaXxNodeWrapper implements Comparable<MaXxNodeWrapper> {
    Node node;
    Fraction value;
    int xPos, yPos;

    @Override
    public String toString() {
        return "" + this.xPos + " " + this.yPos + ". ";
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

    public MaXxNodeWrapper(Node node, Fraction value, int i) {
        this.node = node;
        this.value = value;
        this.xPos = i % 8;
        this.yPos = i / 8;
    }

    @Override
    public int compareTo(MaXxNodeWrapper o) {
        if (this.yPos != o.yPos) {
            return Integer.compare(this.yPos, o.yPos);
        } else if (this.xPos != o.xPos) {
            return Integer.compare(this.xPos, o.xPos);
        } else return 0;
    }
}
