package iProgWS2022;
/**
 * @version 1, 15.11.2022
 * @author Jan Obernberger
 **/
import java.util.Scanner;


public class Schnecke2022 {

    public static void main(String[] args) {
        int n = 0;
        System.out.print("Bitte eine Zahl für die Matrixgröße eingeben: ");
        while (true) {
            n = readInt();
            if (n < 45 && n > 0){
                break;
            }
            System.out.println("Error, bitte erneut versuchen!");
        }
        System.out.println(toString(snail("Alan_Mathison_Turing_", n)));


    }

    public static int readInt() {
        Scanner sc = new Scanner(System.in);
        //Deklarierung der Variable für Zeilen- sowie Spaltenanzahl
        int n = 0;
        //Fehlerauffangschleife
        while (true) {
            try {
                n = sc.nextInt();
                break;
            } catch (Exception e) {
                //nimmt fehlerhafte Eingabe aus dem Eingabepuffer, ansonsten Endlosschleife
                String errStr = sc.next();
                //Gibt Fehler sowie Fehlermeldung aus
                System.out.print(errStr + "Error, bitte erneut versuchen: ");
            }
        }
        return n;
    }
    public static char[][] snail(String name, int dim) {
        int n = dim;
        char[][] snail = new char[n][n];
        char[] eman =buffer(snail, name);
        //Variable für die Anzahl an Kostruktionsschritte
        int k = 0;
        //Variable, die jede Iteration zählt, sodass sie über den Buffer iterieren kann
        int l = 0;

        for (int i = 0; i < n - 1; i = i + 2) {
            if (k == n) break;
            //Konstruiert Zeile n-1 der Matrix
            //Ist nur beim ersten Durchlauf notwendig
            //Konstruiert Spalte n-1
            if (k==0){
                for (int j = n - 1 - i; j >= i; j--, l++) {
                    snail[j][n - 1 - i] = eman[l];
                }
            } else {
                //Konstruiert Spalte n-1-2*i
                for (int j = n - i; j >= i; j--, l++) {
                    snail[j][n - 1 - i] = eman[l];
                }
            }

            k++;
            if (k == n) break;
            //Konstruiert Zeile 0+i
            for (int j = i; j < n - 1 - i; j++, l++) {
                snail[i][n - 2 - j] = eman[l];
            }
            k++;
            if (k == n) break;
            //Konstruiert Spalte 0+i
            for (int j = 1 + i; j <= n - 1 - i; j++, l++) {
                snail[j][i] = eman[l];
            }
            k++;
            if (k == n) break;
            //Konstruiert Zeile n-1-i
            for (int j = i + 1; j <= n - 3 - i; j++, l++) {
                snail[n - 1 - i][j] = eman[l];

                //if (i > 2) break;
            }
            k++;
            if (k == n) break;
        }
        return snail;
    }
    public static String toString(char[][] arr){
        //Initialisierung des resultierenden Strings
        String res = "";
        //Schleife für durchlauf durch das äußere Array
        for (char[] c: arr){;
            //Schleife für Durchlauf durch das innere Array
            for (char cc: c){
                if (cc == 0) cc = ' ';
                res = res.concat(Character.toString(cc));
            }
            res = res.concat("\n");
        }
        return res;
    }
    /*
Die Methode buffer erstellt ein char Array, in dem ein als Attribut mitgegebener String
aneinandergereiht wird. Die Größe des Arrays entspricht dem Quadrat der Länge einer Seitenfläche
der als Attribut mitgegeben quadratischen Matrix.
 */
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
}