package iProgWS2022;
/**
 * @version 1, 15.11.2022
 * @author Jan Obernberger
 **/
public class Schnecke {

    public static void main(String[] args) {
        int n = 0;
        boolean error = false;
        while (true) {
            try {
                n = Integer.parseInt(args[0]);
                if (n <= 45 && n >= 0) {
                    break;
                } else {
                    error = true;
                    break;
                }
            } catch (Exception e) {
                error = true;
                break;
            }
        }
        if (!error) {
            System.out.println(toString(snail("Jan_Obernberger_", n)));
        } else {
            System.out.println("Error, bitte Programm mit einem Aufruparameter\n" +
                    "Zwischen 0 und 45 erneut starten!");
        }

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
            //Abbruchbedingung wird nach jeden Schritt abgefragt
            //Die Schnecke ist immer n Konstruktionsschritte lang
            if (k == n) break;
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
    //ToDo mit Modulo length ersetzen
    //ni = (ni + 1) % name.length;
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
