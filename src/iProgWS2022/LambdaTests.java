package iProgWS2022;

import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleUnaryOperator;
import java.util.function.UnaryOperator;


public class LambdaTests {
    public static void main(String[] args) {
        String s1 = "";
        plot((double x)-> Math.exp(x));
        plot(Math::exp);
        plot(Math::sqrt);
        plot((double x)-> 4.0);
        plot((double x)-> x);
        plot((double x)-> x*x);
        plot((double x)-> {double s = 0.0;

            for (int k : new int[]{5040,720,120,24,6,2,1,1}) s = s*x + 1.0/k;
            //s1 = s1.concat(Double.toString(s));
            return s;});
        System.out.println("lol");
        System.out.println("lol");
        System.out.println("rekursive Funktion zur Textinvertierung");
        // rekursive Funktion zur Textinvertierung
        class Wrapper { UnaryOperator<String> f; }
        Wrapper w = new Wrapper(){
            {f = s -> s.length() <= 1 ? s : f.apply(s.substring(1))+s.substring(0,1);}
        };
        plot(w.f);
        System.out.println("iterative Funktion zur Textinvertierung");
        // iterative Funktion zur Textinvertierung
        plot((String s)-> {String h="";
            for(int i=s.length()-1; i>=0; i--) h+=s.substring(i,i+1);
            return h;});
        System.out.println("rekursive Funktion ähnlich Fakultät");
        // rekursive Funktion ähnlich Fakultät
        plot(getfun());
        System.out.println("forEach in Listen");
        List<Double> myList = Arrays.asList(0.5, 1.0, 1.5, 2.0, 2.333, 2.7777);
        myList.forEach( d -> System.out.println(" "+d+" -> "+fac(d)) );
    } // end main
    public static double fac(double d){
        return d<=0 ? 1 : d*fac(d-1);
    }
    public static DoubleUnaryOperator getfun(){
        return LambdaTests::fac;
    }
    public static void plot (DoubleUnaryOperator f){
        System.out.println("DoublePlot " + f);
        for (double x = 0.0; x <= 4.6; x += 0.5){
            System.out.println(" " + x + " -> " + f.applyAsDouble(x));
        }
    }
    public static void plot (UnaryOperator<String> f){
        System.out.println("DoublePlot " + f);
        for (String s : new String[]{"a", "ab", "abc", "abcd", "abcde", "abcdef",
                "abcdefghijklmnopqrstuvwxyz"}){
            System.out.println(" " +s+" -> " + f.apply(s));
        }
    }
}
