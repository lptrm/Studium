package iProgWS2022;

/**
 * @version 1, 11.10.2022
 * @author Jan Obernberger
 **/

public class VorstellungEinzeillig {

    static String mitglied1 =  "Jan Obernberger";
    static String mitglied2 =  "Kevin";
    static String mitglied3 =  "Rezo";
    static String mitglied4 =  "Karl";
    static String mitglied5 =  "Ingo";

    public static void main (String[] Args ){
        System.out.println(mitglied1);
        System.out.println(kamel(mitglied1, mitglied2, mitglied3, mitglied4, mitglied5));
    }

    public static String kamel(String a, String b, String c, String d, String e){



        return a.concat(b).concat(c).concat(d.concat(e));

    }
}