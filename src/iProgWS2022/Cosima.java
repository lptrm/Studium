package iProgWS2022;
/**
 * @version 42, 08.12.2022
 * @author Jan Obernberger, Kevin Goldmann
 **/
public class Cosima {
    public static void main(String[] args) {
        int n = MyIO.readInt("Gib mir eine Zahl");
        for (int i = 0; i < n; i++){
            if (!(i%2==0) && !(i%3==0) && !(i%5==0)) {
                System.out.print(i);
            }

            if (i%2==0 && !(i%3==0) && !(i%5==0)) {
                System.out.print("Cos");
            }
            if (!(i%2==0) && i%3==0 && !(i%5==0)) {
                System.out.print("Sin");
            }
            if (!(i%2==0) && !(i%3==0) && i%5==0) {
                System.out.print("Math");
            }
            if (i%2 == 0 && i % 3 == 0 && i % 5 == 0){
                System.out.print("Cyber");}
            else if ((i % 2 == 0 && i % 3 == 0) ^ (i%2 == 0 && i % 5 == 0) ^ (i % 3 == 0 && i % 5 == 0)){
                System.out.print("Secans");
            }
            }
        }
    }

