package iProgWS2022;

/**
 * @version 1, 11.10.2022
 * @author Jan Obernberger
 **/

public class Zip {

    static String text1 =  "Hallo" ;
    static String text2 =  "Java" ;

    public static void main (String[] Args ){
        System.out.println(text1);
        System.out.println(text2);
        System.out.println(reissverschluss(text1, text2));
    }

    public static String reissverschluss(String a, String b){



        return a.length() == 0 ? b : b.length() == 0 ? a :
                a.substring(0, 1) + b.substring(0, 1) + reissverschluss(a.substring(1), b.substring(1));

    }

}
