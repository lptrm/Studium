package iProgWS2022;

/**
 * @version 1, 11.10.2022
 * @author Jan Obernberger
 **/

public class Vorstellung {
    static String mitglied1 =  "Jan Obernberger";
    static String mitglied2 =  "Kevin";
    static String mitglied3 =  "Rezo";
    static String mitglied4 =  "Karl";
    static String mitglied5 =  "Ingo";

    public static void main (String[] Args ){

        System.out.println(invertieren(mitglied1));
    }


    public static String invertieren(String a) {
        System.out.println(a);
        return a.length() <= 1 ? a :
                invertieren(a.substring(1))+a.substring(0,1);

    }
}