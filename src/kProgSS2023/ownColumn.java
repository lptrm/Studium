package kProgSS2023;

import java.util.ArrayList;

public class ownColumn {
    ownPrimer primer = null;
    int limit;
    private ArrayList<Integer> data;
    boolean threadFlag = false;
    ownColumn(int limit){
        this.limit = limit;
        this.data = new ArrayList<>();
    }

    public void run() {
        this.primer = ownPrimer.primerCall(limit, this);
        //threadFlag = this.primer
    }
    public synchronized void addE(Integer prime){
        this.data.add(prime);
    }
    public synchronized void printE(){
        this.data.forEach(System.out::println);
    }
}
