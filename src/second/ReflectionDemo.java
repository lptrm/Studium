package second;
import java.io.*;
interface HelloMeth { // Interface
    public void hello();
}
class CA implements HelloMeth { // Implementierung A
    public void hello() {
        System.out.println ("hello CA");
    }
}
class CB implements HelloMeth { // Implementierung B
    public void hello() {
        System.out.println ("hello CB");
    }
}
class CC { // keine Implementierung
    public void hello() {
        System.out.println ("hello CC");
    }
}
class CD { // keine Implementierung
    public void hallo() {
        System.out.println ("hallo CD");
    }
}

public class ReflectionDemo{
    public static void main (String[] args){
        BufferedReader in = new BufferedReader (new InputStreamReader(
                new DataInputStream (System.in))); // zum Lesen von Eingaben
        while (true) {
            try {
                System.out.print ("Klassenname oder ende eingeben: ");
                String buf = in.readLine(); // eine Zeile lesen
                if (buf.toLowerCase().startsWith ("end")) { break; } // Abbruch
                Class c = Class.forName (buf); // versuche Klasse zu laden
                Object o = c.newInstance (); // versuche Objekt zu instantiieren
                ((HelloMeth)o).hello(); // Casting-Versuch und Methodenaufruf
            } catch (IOException e) {
                System.out.println(e);
            } catch (ClassNotFoundException e) { // Klasse nicht gefunden
                System.out.println ("Klasse nicht gefunden");
            } catch (ClassCastException e) { // kann nicht gecastet werden
                System.out.println (e);
            } catch (InstantiationException e) { // etwa bei abstrakter Klasse ...
                System.out.println (e);
            } catch (IllegalAccessException e) { // etwa Konstruktor nicht verfügbar
                System.out.println (e);
            }
        }
    }
}
