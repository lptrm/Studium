package training;

public class MaXxDijkstraTupel {
    public MaXxNodeWrapper destination;
    public MaXxNodeWrapper predecessor;
    public double costs;
    public int step, zeile, spalte;
    public MaXxDijkstraTupel(MaXxNodeWrapper dest, MaXxNodeWrapper pre, double costs){
        this.destination = dest;
        this.predecessor = pre;
        this.costs = costs;
        this.step = -1;
        this.zeile = dest.yPos;
        this.spalte = dest.xPos;
    }
    @Override
    public String toString(){
        return "Feld[" + this.zeile + "|" + this.spalte + "] über " + "Feld[" + this.predecessor.yPos + "|" + this.predecessor.xPos + "] Kosten: " +this.costs + " in: " + this.step + " Steps";
    }
}
