package kProgSS2023;

class Counter2 extends Thread {
    public Counter2 (String s) { super(s);}; // Konstruktor
    public void run () {
        Thread thread = currentThread();
        for (long count = 0; count <= 1; ++count)
            System.out.println (thread + "COUNT:" + count);
    }
}
