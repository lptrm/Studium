package iProgWS2022;

/**
 * @version 1, 02.11.2022
 * @author Yagmur Simsek
 **/

public class Triangle {
    public static void main(String[] args) {
        int n = MyIO.readInt("Gib hier die Anzahl der Zeilen ein:");
        int h = n;
        int sternenZaehler = 0;

        for (int i = 0; i < n; i++) {



           for (int j = n; j > h; j--) {
              MyIO.write(" ");
            }
            for (int j = 0; j < h; j++) {
                    MyIO.write("* ");
                    sternenZaehler++;
                }
            MyIO.writeln("");
            h--;


            }
        MyIO.writeln(n + " Zeilen und " + sternenZaehler + " Sterne.");
        }
    }
