package second;
import java.util.*;
public class TestHashMap {
    public static void main (String[] args) {
        Map<String,String> h = new HashMap<> (); // Leere HashMap
        h.put ("Zeit", "stellenmarkt@jobs.zeit.de"); // add Assoziationen ...
        h.put ("Together", "download.confirmation@togethersoft.com");
        h.put ("Heinz", "heinz@hs-heilbronn.de");
        h.put ("Edutech", "EDUCTECH@listserv.uh.edu");
        h.put ("Inductive", "INDUCTIVE@listserv.unb.ca");
        h.put ("Nichts", null);
        for (Map.Entry me : h.entrySet()){ // iteriere ueber me-Eintraege
            System.out.println( me.getKey() + " --> " + me.getValue() ); // Ausgabe
        }
    }
}