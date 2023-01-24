package iProgWS2022;

/**
 * @version 1, 11.10.2022
 * @author Jan Obernberger
 **/

public class VorstellungGesperrt {

    static String mitglied1 =  "Jan Obernberger";
    static String mitglied2 =  "Kevin";
    static String mitglied3 =  "Rezo";
    static String mitglied4 =  "Karl";
    static String mitglied5 =  "Ingo";

            public static void main (String[] Args ){

                System.out.println(gesperrt(mitglied1));
                System.out.println(gesperrt(mitglied2));
                System.out.println(gesperrt(mitglied3));
                System.out.println(gesperrt(mitglied4));
                System.out.println(gesperrt(mitglied5));
            }

            public static String gesperrt(String a){
                System.out.println("test");
                System.out.println(a);



                return a.length() <= 1 ? a :
                        a.substring(0,1) + " " + a.substring(1,2).toLowerCase() + gesperrt(a.substring(2));

            }
        }

