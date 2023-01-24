package iProgWS2022;
/**
 * @version 1.61, 08.12.2022
 * @author Jan Obernberger, Kevin Goldmann
 **/
public class MathPlotter {
    static String fcn = "";
    public static void main(String[] args) {

        while (!fcn.equalsIgnoreCase("stop")){
            fcn = MyIO.promptAndRead("Welche Funktion soll ich plotten? ");

            switch (fcn){
                case "stop" : break;
                case "sin" : plot(new D2Method() {
                    public double compute (double value) {
                        return Math.sin(value);
                    }
                }); break;
                case "cos" : plot(value -> Math.cos(value)); break;
                case "tan" : plot(Math::tan); break;
                case "exp" : plot(new D2Method() {
                    public double compute (double value) {
                        return Math.exp(value);
                    }
                }); break;
                case "log" : plot(new D2Method() {
                    public double compute (double value) {
                        return Math.log(value);
                    }
                }); break;
                case "square" : plot(new D2Method() {
                    public double compute (double value) {
                        return value * value;
                    }
                }); break;
                case "cube" : plot(new D2Method() {
                    public double compute (double value) {
                        return value * value * value;
                    }
                }); break;
                case "quad" : plot(new D2Method() {
                    public double compute (double value) {
                        return value * value * value * value;
                    }
                }); break;
                case "tower" : plot((double value) -> Math.pow(value, Math.pow(value, value))); break;
                default:
                    System.out.println("geht net"); break;

            }

             /*
            switch (fcn){
                case "stop" : break;
                case "sin" : plot(Math::sin); break;
                case "cos" : plot(Math::cos); break;
                case "tan" : plot(Math::tan); break;
                case "exp" : plot(Math::exp); break;
                case "log" : plot(Math::log); break;
                case "square" : plot(value -> value * value); break;
                case "cube" : plot(value -> value * value * value); break;
                case "quad" : plot(value -> value * value * value * value); break;
                case "tower" : plot(value -> Math.pow(value, Math.pow(value, value))); break;
                default:
                    System.out.println("geht net"); break;

            }
            */
        }
    }
    public static void plot(D2Method meth){
        System.out.println("Plot" + meth);
        double start = MyIO.readDbl("Bitte Start eingeben");
        double stopp = MyIO.readDbl("Bitte Stopp eingeben");
        double sw = MyIO.readDbl("Bitte Schrittweite eingeben");
        for (double x = start; x <= stopp; x += sw){
            System.out.println(fcn + ": von  " + x + " ist " + meth.compute(x));

        }

    }
}
