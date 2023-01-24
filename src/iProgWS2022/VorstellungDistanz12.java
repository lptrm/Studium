package iProgWS2022;

/**
 * @version 1, 11.10.2022
 * @author Jan Obernberger
 **/

public class VorstellungDistanz12 {
    static String mitglied1 =  "Jan Obernberger";
    static String mitglied2 =  "Kevin";
    static String mitglied3 =  "Rezo";
    static String mitglied4 =  "Karl";
    static String mitglied5 =  "Ingo";

    public static void main (String[] Args ){
        System.out.println(distanz(mitglied1));
        System.out.println(distanz(mitglied2));
        System.out.println(distanz(mitglied3));
        System.out.println(distanz(mitglied4));
        System.out.println(distanz(mitglied5));
    }

    public static String distanz(String a){




        return a.length() <= 1 ? a :
                a.substring(0, 1) + " " + a.substring(1, 2) + "  " + distanz(a.substring(2));

    }
}
