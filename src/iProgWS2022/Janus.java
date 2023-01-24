package iProgWS2022;

/**
 * @version 1, 18.10.2022
 * @author Jan Obernberger
 **/


import java.io.*;

public class Janus {

    public static void main (String[] Args ) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("Janus.java"))));

        String inputLine = br.readLine();
//Porgramm auch mit Scanner Methode möglich, sogar einfacher
        while (inputLine != null) {
            System.out.println(inputLine);
            inputLine = br.readLine();

        }
        br.close();
    }

}
