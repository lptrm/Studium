package kProgSS2023;

public class ownSevenColumnPrimes extends Thread{
    ownColumn[] columns = new ownColumn[7];
    public ownSevenColumnPrimes(){
        for (int i = 1; i <= columns.length; i++){
            columns[i-1] = new ownColumn(7351);
            columns[i-1].run();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ownSevenColumnPrimes sevenColumnPrimes = new ownSevenColumnPrimes();

            try {
                sevenColumnPrimes.columns[0].primer.join();
                sevenColumnPrimes.columns[1].primer.join();
                sevenColumnPrimes.columns[2].primer.join();
                sevenColumnPrimes.columns[3].primer.join();
                sevenColumnPrimes.columns[4].primer.join();
                sevenColumnPrimes.columns[5].primer.join();
                sevenColumnPrimes.columns[6].primer.join();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }

        for (ownColumn e:
                sevenColumnPrimes.columns) {
            e.printE();
        }
    }
}
