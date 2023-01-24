package iProgWS2022;
/**
 * @version 1, 15.11.2022
 * @author Jan Obernberger
 **/
import java.util.Scanner;

/*
Wenn wir die Vorgaben vonn Herrn H. zerlgen ,kommen wir auf einen Algorithmus, der eine Matrix wie folgt befüllt:
1. (n-1, 0) bis (n-1,n-1)
2. (n-1, n-1) bis (0, n-1)
3. (0, n.1) bis (0, 0)
4. (0, 0) bis (n-1-2, 0)
...
 */


public class Schnecke2021 {

    public static char[] buffer(char[][] c, String s){
        int length = c.length * c.length;
        char[] res = new char[length];

        int k = 0;
        for (int i = 0; i < length; i++){
            if (k == s.length() - 1){
                res[i] = s.charAt(k);
                k = 0;
            } else {
                res[i] = s.charAt(k);
                k++;
            }
        }
        return res;


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Deklarierung der Variable für Zeilen- sowie Spaltenanzahl
        int n;
        System.out.print("Bitte eine Zahl für die Matrixgröße eingeben: ");
        //Fehlerauffangschleife
       while (true) {
           try {
               n = sc.nextInt();
               break;
           }
           catch (Exception e){
               //nimmt fehlerhafte Eingabe aus dem Eingabepuffer, ansonsten Endlosschleife
               String errStr = sc.next();
               //Gibt Fehler sowie Fehlermeldung aus
               System.out.print(errStr + "Error, bitte erneut versuchen: ");
           }
       }

       /*
       int[] a = {1, 2, 3, 4, 5};
       int[] a;
       a = new int[5];
       a[0] = 1;
       ...
       int[] a = new int[] {9, 8, 7, 6, 5};

        */

        String name = "Jan_Obernberger_";
       //Erstellung der Matrix mit n Zeilen und Spalten
        char[][] snail = new char[n][n];
        //Erstellung eines Pufferarrays zum Konstruieren der Schnecke
        char[] eman =buffer(snail, name);

        //Variable für die Anzahl an Kostruktionsschritte
        int k = 0;
        //Variable, die jede Iteration zählt, sodass sie über den Buffer iterieren kann
        int l = 0;

        for (int i = 0; i < n - 1; i = i + 2) {  if (k == n) break;
            //Konstruiert Zeile n-1 der Matrix
            //Ist nur beim ersten Durchlauf notwendig
            if (k == 0) {
                for (int j = 0; j <= n - 1; j++, l++) {
                    snail[n - 1][j] = eman[l];

                    //if (i > 2) break;
                }
                k++;
            }
            if (k == n) break;
            //Konstruiert Spalte n-1-2*i
            for (int j = n - 2 - i; j >= 0 + i; j--, l++) {
                snail[j][n - 1 - i] = eman[l];
            }
            k++;
            if (k == n) break;
            //Konstruiert Zeile 0+i
            for (int j = 0 + i; j < n - 1 - i; j++, l++) {
                snail[i][n - 2 - j] = eman[l];
            }
            k++;
            if (k == n) break;
            //Konstruiert Spalte 0+i
            for (int j = 1 + i; j <= n - 3 - i; j++, l++) {
                snail[j][i] = eman[l];
            }
            k++;
            if (k == n) break;
            //Konstruiert Zeile n-3-i
            for (int j = i + 1; j <= n - 3 - i; j++, l++) {
                snail[n - 3 - i][j] = eman[l];

                //if (i > 2) break;
            }
            k++;
            if (k == n) break;
        }


            String res = "";

            //Iterator über die Arrays in snail
            for (char[] chars : snail) {
                //Klammer für Arraybeginn
                System.out.print("[ ");
                //Iterator für die einzelnen Arrays jedes Arrays
                for (int j = 0; j < n; j++) {
                    //Ausgabe der Werte
                    System.out.print(chars[j] + " ");
                }
                //Klammer für Arrayende
                System.out.println("]");
            }


        }

    }

