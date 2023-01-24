package iProgWS2022;
/**
 * @version 1, 08.12.2022
 * @author Jan Obernberger, Kevin Goldmann
 **/
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class EsreverLister {

    public static void main(String[] args) throws IOException {
        //Initialisierung einer Liste mit Elementen des Typs String
        List<String> list = new ArrayList<String>();
        MyIO.writeln("Ich werde einen Text einlesen und diesen gespiegelt" +
                "in umgekehrter Reihenfolge ausgeben...");
        while (true){
            System.out.print("-> ");
            String s = MyIO.readString();
            if (s == null ||s.equalsIgnoreCase("potS")) break;
            list.add(invertieren(s));
        }
        ListIterator<String> it = list.listIterator(list.size());
        while (it.hasPrevious()){
            MyIO.writeln(it.previous());
        }




    }

    public static String invertieren(String a) {
        return a.length() <= 1 ? a :
                invertieren(a.substring(1))+a.charAt(0);

    }

    public static String promptAndReadBars(String a) throws IOException {
        System.out.print(a);
        boolean b = false;
        Scanner sc = new Scanner(System.in);
        if (sc.hasNext()) b = true;


        //Promptet nach jeder Linie, ggf buffered reader benutzen oder while
        //File IO anschauen
        return sc.nextLine();
    }


}