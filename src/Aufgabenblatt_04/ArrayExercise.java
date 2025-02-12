package Aufgabenblatt_04;

/**
 * Die Klasse führt verschiedene Operationen mit einem eindimensionalen Array aus.
 *
 * @author Eduard Wayz (193123)
 * @version 1.0
 */

public class ArrayExercise {
    public static void main(String[] args) {
        // (a) Legt ein leeres int-Array der Länge 17 an und gibt die Werte aus.
        int[] intArray = new int[17];
        for (int i : intArray) {
            System.out.print(i + " ");
        }
        System.out.println();
        int geradeZahl = 16;
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = geradeZahl;
            geradeZahl -= 2;
        }

        // (b) Befüllt das Array von links nach rechts mit allen geraden Zahlen von 17 bis 1 und gibt die Werte aus.
        int ungeradeZahl = 18; // ungeradeZahl fängt bei 18 an, weil ich in der Schleife zuerst -2 rechne und der Index 0 16 sein muss.
        for (int i = 0; i < intArray.length; i++) {
            ungeradeZahl -= 2;
            // if-Bedingung, damit es keine negativen Zahlen hereinschreibt. Der Wert des Restes bleibt 0.
            if (ungeradeZahl > 1) {
                intArray[i] = ungeradeZahl;
            }
        }
        for (int i : intArray) {
            System.out.print(i + " ");
        }
        System.out.println();

        // (c) Füllt die restlichen freien Plätze mit zufälligen Zahlen von 1 bis 20 auf und gibt das Array erneut aus. 
        for (int i = 8; i < intArray.length; i++) {
            intArray[i] = (int) (Math.random() * 20) + 1;
        }
        for (int i : intArray) {
            System.out.print(i + " ");
        }
        System.out.println();

        // (d) Ersetzt jede Zahl durch ihren rechten Nachbarn. Die Zahl ganz rechts soll durch den Wert der ursprüngliche ganz linken Zahl ersetzt werden. Zudem wird das Array wieder ausgegeben
        for (int i = 0; i < intArray.length - 1; i++) {
            intArray[i] = intArray[i + 1];
        }
        intArray[intArray.length - 1] = 16; // Ersetzt die leutzte Zahl mit der ursprünglichen Ersten
        for (int i : intArray) {
            System.out.print(i + " ");
        }
        System.out.println();

        // (e) Ermittelt die größte Zahl des Arrays und gibt diese mit der Position im Array aus
        int maxIndex = 0;
        for (int i = 1; i < intArray.length; i++) {
            if (intArray[i] > intArray[maxIndex]) {
                maxIndex = i;
            }
        }
        System.out.println("Der Index des höchsten Wertes ist " + maxIndex + " (Postion " + (maxIndex + 1) + ") mit dem Wert: " + intArray[maxIndex]);
    }
}
