package second;
import java.lang.reflect.*; // Importieren der Reflection-Klassen
public class PlotDoubleMethods {
    public static void printTables (String name){
        try {
            Class testclass = Class.forName (name); // Klasse laden
            Method[] methods = testclass.getMethods(); // Methoden laden
            for (Method m : methods) { // fuer alle Methoden:
                Class[] paras = m.getParameterTypes(); // formale Parameter besorgen
                if (paras.length != 1 || paras[0] != Double.TYPE) { // Test ob ein double-Param.
                    continue; // wenn nicht: naechste Methode
                }
                if (m.getReturnType() != Double.TYPE) { // Test auf Return-Wert double
                    continue; // wenn nicht: naechste Methode
                }
                if (!Modifier.isStatic(m.getModifiers())){ // Test auf statische Methode
                    continue;
                }
                System.out.println ("Wertetabelle fuer " + m.getName());
                Object[] actargs = new Object[1];
                for (int j=-10; j<=10; j+=2) { // fuer j in –10 .. 10
                    double x = (double)j/10; // x in –1.0 .. 1.0
                    actargs[0] = new Double (x); // belege aktuelle Param.
                    System.out.println(" " + x + " -> " + // Ausgabe
                            m.invoke (null, actargs)); // Aufruf der Methode
                } // end for j
            } // end for m : methods
        } catch (Exception e) {
            System.err.println(e);
        }
    } // end printTables
    public static void main (String[] args) {
        printTables (args[0]);
    }
} // end class PlotDoubleMethods