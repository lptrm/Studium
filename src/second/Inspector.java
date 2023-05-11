package second;

import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;
/**
 * @author Jan Obernberger: 215470
 * @version 4.20, 11.05.2023
 **/
public class Inspector {
    public static void main(String[] args) {
        //IO-Vorbereitungen
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        String prompt = "Type the name of the class you want me to examine\nor type \"exit\" to end the program: ";
        StringBuilder stringBuilder = new StringBuilder();
        //Nutereingabe
        System.out.print(prompt);
        String target = scanner.hasNextLine() ? scanner.nextLine().trim() : null;   //Nutzereingabe einlesen
        //Schleife zum Reagieren auf die Nutzereingabe
        while (target != null && !target.equals("ende")) {
            try {
                do {    //Schleife zum Untersuchen der Klasse
                    Class<?> testClass = Class.forName(target); //Klassenobjekt zum Untersuchen
                    //Klassenuntersuchung
                    String className = testClass.getSimpleName();   //Klassenname ermitteln
                    String modifiers = Modifier.toString(testClass.getModifiers()); //Klassen-Modifier ermitteln
                    Method[] methods = testClass.getMethods();  //Klassenmethoden ermitteln

                    stringBuilder.append(String.format("""
                            --------------------------------------------------
                            --------------------------------------------------
                            Class       : %s
                            Modifier    : %s
                            """, className, modifiers));
                    //Methodenuntersuchungen
                    for (var method : methods) {
                        modifiers = Modifier.toString(method.getModifiers());   //Methoden-Modifier ermitteln
                        String returnType = method.getReturnType().getSimpleName(); //Rückgabewert ermitteln
                        Class<?>[] parameters = method.getParameterTypes(); //Methodenparameter ermitteln
                        //Parameterstring synthetisieren
                        StringBuilder parameterString = new StringBuilder();
                        for (int i = 0; i < parameters.length; i++) {
                            parameterString.append(parameters[i].getSimpleName());
                            if(i != parameters.length - 1) parameterString.append(", ");
                        }

                        stringBuilder.append(String.format("""
                                --------------------------------------------------
                                    Method      : %s
                                    Modifier    : %s
                                    Return-Type : %s
                                    Parameters  : %s
                                """, method.getName(), modifiers, returnType, parameterString));
                    }
                    stringBuilder.append("""
                                    --------------------------------------------------
                                    --------------------------------------------------
                                    """);

                    testClass = testClass.getSuperclass();  //Zur Oberklasse wechseln
                    if (testClass != null) stringBuilder.append("IS CHILD OF\n");
                    target = testClass != null ? testClass.getName() : null;    //Hierdurch kann testClass lokal deklariert werden
                } while (target != null);
                //Ausgabe der Untersuchung
                System.out.print(stringBuilder);

            } catch (ClassNotFoundException e) {
                //Fehlerbehandlung
                System.out.println("Error, please try valid class name!");
            }
            //Nutzereingabe
            System.out.print(prompt);
            target = scanner.hasNextLine() ? scanner.nextLine().trim() : null;
        }
        scanner.close();    //Der Vollständigkeit halber :D
    }
}
