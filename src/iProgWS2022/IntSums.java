package iProgWS2022;

/**
 * @version 1, 11.10.2022
 * @author Jan Obernberger
 **/

public class IntSums {

    static int[] zahlenfolge1 = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    static int[] zahlenfolge2 = {3, 5,11, 17, 31, 41, 59, 67, 83, 109};
    static int[] zahlenfolge3 = {5, 11, 31, 59, 127, 179, 277, 331, 431, 599};

    public static void main (String[] Args ){

        int hilfsVariable = 0;

        System.out.println(addAll(zahlenfolge1, hilfsVariable));
        System.out.println(addAll(zahlenfolge2, hilfsVariable));
        System.out.println(addAll(zahlenfolge3, hilfsVariable));

    }
    public static int addAll(int[] a, int b){



        return b >= a.length - 1 ? a[b]  : a[b] + addAll( a, b + 1);


        //return a.length() <= 1 ? a :
                //a.substring(0, 1) + " " + kamel(a.substring(1));

    }
}

