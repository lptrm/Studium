package iProgWS2022;

public class UmfuellProblem {
        public static void main (String[] args){
            Gefaess a = new Gefaess ("Eimer", 6);
            Gefaess b = new Gefaess ("Krug", 17);
            Gehilfe g = new Gehilfe (a, b, new Fass ());
            g.missAb (1);
        }
}

abstract class Behaelter {
    abstract void fuelle (Behaelter aus); // fuelle Dich
    abstract int leere (int um); // leere Dich
}
class Fass extends Behaelter { // kann beliebig befuellt
    void fuelle (Behaelter aus) // und geleert werden
    { aus.leere (Integer.MAX_VALUE); }
    int leere (int um)
    { return um; }
    public String toString ()
    { return "Fass"; }
}
class Gefaess extends Behaelter {
    private int maximum, inhalt; // Instanzprivate
    String name; // Variablen
    Gefaess (String s, int i) // Konstruktor
    { name = s; maximum = i; }
    void fuelle (Behaelter aus)
    { inhalt += aus.leere (maximum-inhalt); }
    int leere (int um) {
        int k = Math.min (um, inhalt);
        inhalt -= k;
        return k;
    }
    boolean istVoll () // bist Du voll?
    { return enthaelt (maximum); }
    boolean istLeer () // bist Du leer?
    { return enthaelt (0); }
    boolean enthaelt (int i) // ist Dein Inhalt == i
    { return inhalt == i; }
    public String toString ()
    { return name +"["+inhalt+"]"; }
}
class Gehilfe {
    private Gefaess g1, g2;
    private Behaelter f;
    private final int limit = 1000;
    Gehilfe (Gefaess a, Gefaess b, Behaelter f){ // Konstruktor
        g1 = a; g2 = b; this.f = f;
    }
    void kippeUm (Behaelter von, Behaelter nach){
        nach.fuelle (von);
        System.out.println ("Fuelle "+nach+" aus "+von);
    }
    void missAb (int ziel){
        for (int geduld = limit; geduld >= 0 ; geduld--) {
            if (g1.istLeer ()) kippeUm (f, g1);
            else if (g2.istVoll ()) kippeUm (g2, f);
            else kippeUm (g1, g2);
            if (g1.enthaelt (ziel)){
                System.out.println ("Abgemessen: " +g1);
                geduld = 0;
            } else if (g2.enthaelt (ziel)){
                System.out.println ("Abgemessen: " +g2);
                geduld = 0;
            } else if (geduld==0){
                System.out.println ("Keine Geduld mehr");
            }// if
        }// for
    }// missAb
}// class Gehilfe
