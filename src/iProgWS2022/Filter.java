package iProgWS2022;

/**
 * @version 1, 18.10.2022
 * @author Jan Obernberger
 **/


import java.io.BufferedReader;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Filter {

    public static void main(String Args[]) throws IOException {

        System.out.println("Lass mich dir die Zeilen eines Website-Quelltextes zeigen,");
        System.out.println("die eine von dir eingegebene Zeichenfolge enthalten!");
        System.out.println("Gib hierzu bitte zuerst eine URL sowie eine Zeichenfolge ein.");
        System.out.println("(Hierbei ist Groß- und Kleinschreibung unerheblich)");
        System.out.println("Bestätige die Eingabe jeweils mit der Enter-Taste.");
        BufferedReader k1FBr = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader k2FBr = new BufferedReader(new InputStreamReader(System.in));

        String adresse = k1FBr.readLine();
        String ziel = k2FBr.readLine();

        URL u = new URL(adresse);
        FilterInputStream ins = (FilterInputStream) u.openStream();
        BufferedReader whitehouse = new BufferedReader(new InputStreamReader(ins));

        String foo = whitehouse.readLine();

        while (foo != null){

            while (foo.toLowerCase().contains(ziel.toLowerCase())) {

                System.out.println(foo);
                foo = whitehouse.readLine();
            }
                foo = whitehouse.readLine();


         /*
         System.out.println(foo.toLowerCase().contains("joe")
                 ? whitehouse.readLine()
                 : );




            whitehouse.readLine().toLowerCase().contains("jill")
                    ? System.out.println(whitehouse.readLine())
                    : whitehouse.readLine();

           */
        }


    }

}
