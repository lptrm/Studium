package second;

import java.lang.reflect.*;
class PrintableObject { // Druckbares Objekt
    public String toString() { // liefert String zum Ausgeben
        String s = ""; // s: anfangs leerer String
        Class clazz = getClass(); // ermittelt echte eigene (Sub-) Klasse
        while (clazz != null) { // betrachtet Klasse und Superklassen
            Field[] fields = clazz.getDeclaredFields(); // besorgt Felder
            for (Field f : fields) { // fuer jedes Feld:
                s += f.getName() + " = "; // Feldnamen an s haengen
                try { Object obj = f.get(this); // Wert des Feldes lesen
                    if (obj.getClass().isArray()) { // Test auf Array
                        s += "[ "; // Arraybeschreibung an s haengen
                        for (Object ob : (Object[])obj) // fuer jedes Array-Element:
                        { s += ob + " "; } // an s haengen
                        s += "]\n"; // Array-Ende
                    } else { s += obj + "\n"; // Nicht-Array an s haengen
                    }
                } catch (IllegalAccessException e) {
                    s += e + "\n"; // Fehlerbeschreibubg an s haengen
                } // end try
            } // end for
            clazz = clazz.getSuperclass(); // weiter mit Superklasse
        } // end while
        return s; // Ergebnis s liefern
    } // end toString()
} // end class PrintableObject ...
class Employee extends PrintableObject { // Angestellter
    public String name;
    public String department;
    public int age;
} // end class Employee
class Programmer extends Employee { // Programmierer
    public String[] languages;
    public int linesofcode;
} // end class Programmer
class JavaProgrammer extends Programmer { // Java-Programmierer
    public boolean jdbc;
    public boolean swing;
} // end class JavaProgrammer
public class ListFields { // Testprogramm
    public static void main (String[] args) {
        JavaProgrammer klaus = new JavaProgrammer(); // Default-Konstruktor
        klaus.name = "Klaus Meier"; // Belegung der Felder "von aussen"
        klaus.department = "Betriebssysteme";
        klaus.age = 49;
        klaus.languages = new String[] {"C", "Pascal", "PERL", "Java"};
        klaus.linesofcode = 55000;
        klaus.jdbc = false;
        klaus.swing = true;
        System.out.println (klaus); // Ausgabe mit saemtlichen Feldern ...
    } // end main
} // end public class ListFields