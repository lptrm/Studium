package iProgWS2022;

/**
 * @version 1, 11.10.2022
 * @author Jan Obernberger
 **/


public class VorstellungAufAb {
    static String mitglied1 =  "Jan Obernberger";
    static String mitglied2 =  "Kevin";
    static String mitglied3 =  "Rezo";
    static String mitglied4 =  "Karl";
    static String mitglied5 =  "Ingo";

    public static void main (String[] Args ){

        System.out.println(kamel(mitglied1));
        System.out.println(kamel(mitglied2));
        System.out.println(kamel(mitglied3));
        System.out.println(kamel(mitglied4));
        System.out.println(kamel(mitglied5));
    }

    public static String kamel(String a){



        return a.length() <= 1 ? a :
                a.substring(0, 1) + " " + kamel(a.substring(1));

    }
}