package training;

public class MaXxDijkstraTupel {
    public MaXxNodeWrapper destination;
    public MaXxNodeWrapper predecessor;
    public double costs;
    public MaXxDijkstraTupel(MaXxNodeWrapper dest, MaXxNodeWrapper pre, double costs){
        this.destination = dest;
        this.predecessor = pre;
        this.costs = costs;
    }
    @Override
    public String toString(){
        return this.destination + " über " + this.predecessor + " Kosten: " +this.costs;
    }
}
