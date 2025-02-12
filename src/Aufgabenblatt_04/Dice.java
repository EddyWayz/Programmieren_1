package Aufgabenblatt_04;

/**
 * Die Klasse Dice enthält folgende Methoden:
 * - rollDie() simuliert einen Würfelwurf.
 * - rollDice(int n) simuliert das Werfen von n Würfel und gibt die Ergebnisse zurück.
 * - wuerfelBisZumPasch(int n) würfelt solange n Würfel bis alle Ergebnisse im Array gleich sind.
 * Die main-Methode gibt nacheinander rollDice und wuerfelBisZumPasch mit den Werten als Parametern 2 bis 6 auf der Konsole aus.
 *
 * @author Eduard Wayz (193123)
 * @version 1.0
 */
public class Dice {

    public static void main(String[] args) {
        for (int i = 2; i < 6; i++) {
            System.out.println(rollDice(i));
        }

        for (int i = 2; i < 6; i++) {
            System.out.println(wuerfelBisZumPasch(i));
        }
    }

    /**
     * Diese Methode simuliert einen Würfelwurf mit einem sechsseitigen Würfel
     *
     * @return eine ganzzahlige Zufallszahl von 1 bis 6.(int)
     */
    static int rollDie() {
        return ((int) (Math.random() * 6) + 1);
    }

    /**
     * Die Methode simuliert das Werfen von n Würfel und gibt die Ergebnisse
     * gesammelt zurück.
     *
     * @param n gibt die Anzahl der Würfe an. (int)
     * @return int[] der länge n mit den gewürfelten Zahlen. (int[])
     */
    static int[] rollDice(int n) {
        // Return ein leeres int[], wenn n < 1.
        if (n < 1) {
            return new int[0];
        }
        // Erstellt und befüllt ein int[] der Länge n mit zufälligen Zahlen von 1 bis 6.
        int[] resultArray = new int[n];
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = rollDie();
        }
        return resultArray;
    }

    /**
     * Die Methode würfelt mithilfe von rollDice(int n) so lange die Würfel, bis
     * alle Würfel des Arrays dieselbe Anzahl anzeigen (Pasch)
     *
     * @param n ist die Anzahl der zu vergleichenden Würfel-Ergebnisse.
     * @return anzahlBenötigterWuerfe - gibt die Anzahl der dabei benötigten Würfe an.
     */
    static long wuerfelBisZumPasch(int n) {
        // Gibt 0 zurück, wenn n <= 1.
        if (n <= 1) {
            return 0;
        }
        // Erstellt und befüllt mithilfe von rollDice solange ein int[] bis alle Zahlen gleich sind. 
        // Dabei wird anzahlBenötigterWuerfe immer um eins erhöht und am Ende zurückgegeben. 
        long anzahlBenoetigterWuerfe = 1;
        int[] zahlenArray = rollDice(n);
        while (!allEqual(zahlenArray)) {
            zahlenArray = rollDice(n);
            anzahlBenoetigterWuerfe++;
        }
        return anzahlBenoetigterWuerfe;
    }

    /**
     * Diese Methode überprüft ob alle Zahlen eines übergebenen int[] gleich sind
     *
     * @param zahlen ist das zu überprüfende int[] (int[])
     * @return true, wenn alle Zahlen im Array gleich sind, sonst false.
     */
    static boolean allEqual(int[] zahlen) {
        // Vergleicht immer das linke Element im Array mit dem Element rechts von ihm. 
        // Sind diese mal nicht gleich, wird sofort false zurückgegeben. 
        for (int i = 0; i < zahlen.length - 1; i++) {
            if (zahlen[i] != zahlen[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
