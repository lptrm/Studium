package training;

public class DijkstraTupel {
    public Node destination;
    public Node predecessor;
    public int costs;
    public DijkstraTupel(Node dest, Node pre, int costs){
        this.destination = dest;
        this.predecessor = pre;
        this.costs = costs;
    }
    public String toString(){
        return this.destination + " über " + this.predecessor + " Kosten: " +this.costs;
    }
}
