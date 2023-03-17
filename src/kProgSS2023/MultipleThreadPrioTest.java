package kProgSS2023;

public class MultipleThreadPrioTest {
    public static void main ( String [] args ) {
        Thread secondThread = new Counter2 ("second");
        Thread thirdThread = new Counter2 ("third");
        thirdThread.setPriority (Integer.parseInt(args[0]));
        secondThread.start ();
        thirdThread.start ();
    }
}
