package training;

public class DijkstraTableCell {
    public Node predecessor = null;
    public Node scope = null;
    public int costs = Integer.MAX_VALUE;
    public int step = 100;
    @Override
    public String toString(){
        return this.predecessor!=null? this.step + " " +this.scope.name + ": " + this.predecessor.name + this.costs : "undefined";
    }
}
