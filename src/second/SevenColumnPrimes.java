package second;
/**
 * @version 42, 17.03.2023
 * @author Jan Obernberger
 **/
public class SevenColumnPrimes extends Thread {
    String output = "";
    String columnTemplate = "| XXXX |";
    private final int p;
    private SevenColumnPrimes next;
    private final int column;
    private double aDouble;

    SevenColumnPrimes(int prime, int column) {
        super("Primer-" + prime);
        p = prime;
        this.column = column;
        String replacement = String.valueOf(p).length() < 4 ? " ".repeat(4 - String.valueOf(p).length()) + p : String.valueOf(p);
        this.start();
        output += "|" + columnTemplate.replace("XXXX", "    ").repeat(column - 1)
                + columnTemplate.replace("XXXX", replacement)
                + columnTemplate.replace("XXXX", "    ").repeat(7 - column) + "|";
        System.out.println(output);
    }
    public SevenColumnPrimes(double d){
        this(1, 2);
        aDouble = d;
    }
    public static void main(String args[]) {
        int columns = 7;
        int limit = 7351;
        System.out.println("||  T1  ||  T2  ||  T3  ||  T4  ||  T5  ||  T6  ||  T7  ||");
        for (int i = 1; i <= columns; i++) {
            threadGen(i, limit);
        }
        SevenColumnPrimes sevenColumnPrimes = new SevenColumnPrimes(3.0);
        System.out.println(sevenColumnPrimes.aDouble);
    }

    public static void threadGen(int column, int limit) {
        new Thread(() -> {
            SevenColumnPrimes first = new SevenColumnPrimes(2, column);
            for (int i = 3; i <= limit; first.send(i++)) ;
            first.send(0);
        }).start();

    }

    public void run() {
        while (true) {
            int n = receive();
            if (n == 0) {
                if (next != null) next.send(n);
                break;
            }
            if (n % p != 0) {
                if (next != null) next.send(n);
                else next = new SevenColumnPrimes(n, this.column);
            }
        }
    }

    private int buffer = -1;

    synchronized void send(int i) {
        try {
            while (buffer >= 0) wait();
            buffer = i;
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized int receive() {
        int result = 0;
        try {
            while ((result = buffer) < 0) wait();
            buffer = -1;
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }


}