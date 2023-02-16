package training;

public class DijkstraTableCell {
    public Node predecessor = null;
    public int costs = Integer.MAX_VALUE;
    @Override
    public String toString(){
        return this.predecessor!=null? this.predecessor.name + this.costs : "undefined";
    }
}
