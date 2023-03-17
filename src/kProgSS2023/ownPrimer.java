package kProgSS2023;

//TODO Column in den Konstruktor packen

// Primer der "Pipe" zur Primzahlenaussiebung
public class ownPrimer extends Thread {
    private ownColumn column = null;
    private boolean calc;
    private int p; // die Primzahl dieses Primers
    private ownPrimer next; // der nächste Primer in der "Pipe"
    ownPrimer(int prime, ownColumn column) { // Konstuktor
        super ("Primer-" + prime); // Name eintragen
        p = prime; // Primzahl eintragen
        this.column = column;
        this.start(); // Thread sofort starten
    }
    public static ownPrimer primerCall (int limit, ownColumn column){
        ownPrimer first = new ownPrimer(2, column);// ersten Primer : 2
        first.column = column;
        for (int i=3; i <= limit; first.send(i++)); // weitere
        first.send (0); // Abbruchmitteilung
        return first;
    }
    // ... weitere Variablen und Methoden ...
    public void run() { // Die Arbeitsmethode des Primers
// ... ist nicht synchronisiert !
        //System.out.println (currentThread() +" Primzahl: "+p);
        while (true) { // Endlos-Schleife
            int n = receive(); // Lese-Versuch
            if (n == 0) { // wenn n=0: Ende
                if (next != null) next.send(n);// auch von next
                break; // Ende while loop
            }
            if (n%p != 0) { // vielleicht prim
                if (next != null) next.send(n);// weiter testen
                else {
                    fillIn(n);
                    next = new ownPrimer(n, column); // Primzahl!
                }
            } // sonst: n nicht prim
        }
    }
    private int buffer = -1; // Puffer zum Senden & Empfangen
    // wenn < 0: leer
    synchronized void send(int i) { // Sperre erlangen
        try {
            while (buffer >= 0) wait();// warten bis Puffer frei
            buffer = i; // Puffer füllen
            notify(); // Empfänger benachrichtigen
        } catch (InterruptedException e) {}
    }
    synchronized void fillIn(int prime){
        this.column.addE(prime);
    }
    synchronized boolean calcEnd(){
        return true;
    }
    synchronized int receive() { // Sperre erlangen
        int result = 0;
        try {
            while ((result=buffer)<0) wait(); // warten bis Puffer
// voll
            buffer = -1; // Puffer leeren
            notify(); // Sender
// benachrichtigen
        } catch (InterruptedException e) {}
        return result;
    }
}

