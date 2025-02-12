package Aufgabenblatt_06;

import Helps.In;

import java.util.Arrays;

/**
 * @author Eduard Wayz (193123)
 * @version 1.0
 *
 * Diese Klasse implementiert ein Lottospiel (6 aus 49). Der Spieler gibt einen Tipp mit sechs Zahlen ab,
 * und das Programm zieht zufaellige Lottozahlen. Anschließend wird verglichen, wie viele Zahlen uebereinstimmen.
 */
public class Lotto {
    public static void main(String[] args) {
        // Lies den Tipp des Spielers ein und speichere ihn in playerTip.
        int[] playerTip = readPlayerTip();

        // Ziehe sechs zufaellige Lottozahlen und speichere sie in ziehung.
        int[] ziehung = drawLottery();

        // Gib die getippten und die gezogenen Zahlen aus.
        System.out.println("\nDie getippten Zahlen sind: " + Arrays.toString(playerTip));
        System.out.println("Die Ziehung beinhaltet die Zahlen: " + Arrays.toString(ziehung));

        // Vergleiche den Tipp des Spielers mit den gezogenen Zahlen und gib die Anzahl der Treffer aus.
        System.out.println("Es wurden " + compareNumbers(playerTip, ziehung) + " von 6 Zahlen richtig getippt.");

        // Erzeuge so lange neue Ziehungen bis der Tipp des Spieler 6 richtige Treffer hat und
        // zaehlt dabei die Anzahl der benoetigten neuen Ziehungen.
        System.out.println("\nWie viele Ziehungen brauche ich fuer 6 richtige Treffer? Hier...");
        int drawCount = 0; // Count fuer neue Ziehungen.
        // Wenn Nummer aus Ziehung nicht im Player-Tipp vorhanden ist, erhoehe counter um eins und veraendere Ziehung.
        while(compareNumbers(playerTip, ziehung) != 6){
            drawCount++;
            ziehung = drawLottery();
        }
        // Erneute Ausgabe.
        System.out.println("Es wurden " + drawCount + " neue Ziehungen fuer 6 Trefer gebraucht.");
        System.out.println("Die getippten Zahlen sind weiterhin: " + Arrays.toString(playerTip));
        System.out.println("Die Ziehung ist jetzt: " + Arrays.toString(ziehung));

    }

    /**
     * Gibt eine Zufallszahl von 1 bis 49 zurueck.
     *
     * @return int von 1 bis 49.
     */
    static int drawOneNumber() {
        return (int) (Math.random() * 49) + 1; // Erzeugt eine Zahl im Bereich von 1 bis 49
    }

    /**
     * Erzeugt eine komplette Lottoziehung mit sechs unterschiedlichen Zufallszahlen.
     *
     * @return int[] mit sechs verschiedenen Zahlen von 1 bis 49.
     */
    static int[] drawLottery() {
        int[] lotteryNumbers = new int[6]; // Array fuer die sechs gezogenen Zahlen.
        int tmpNumber; // Hilfsvariable

        // Fuelle das Array mit sechs unterschiedlichen Zahlen.
        for (int i = 0; i < lotteryNumbers.length; i++) {
            do {
                tmpNumber = drawOneNumber(); // Ziehe eine Zufallszahl.
            } while (checkForSimilar(lotteryNumbers, tmpNumber, i, false)); // Pruefe, ob die Zahl schon vorhanden ist.
            lotteryNumbers[i] = tmpNumber; // Fuege die Zahl zum Array hinzu.
        }
        return lotteryNumbers;
    }

    /**
     * Liest den Tipp des Spielers ein und stellt dabei sicher, dass sechs unterschiedliche Zahlen von 1 bis 49 eingegeben werden.
     *
     * @return int[] mit sechs Zahlen, die der Spieler eingegeben hat.
     */
    static int[] readPlayerTip() {
        int[] eingabeArray = new int[6]; // Array fuer die Eingaben des Spielers.
        int n; // wird zu den eingegebenen Zahl.
        // Frage nach 6 unterschiedlichen Zahlen vom Spieler von 1 bis 49.
        for (int i = 0; i < eingabeArray.length; i++) {
            do {
                n = In.readInt("Geben Sie die " + (i + 1) + ". Zahl von 1 bis 49 ein: "); // Lese die vom Spieler eingegebene Zahl ein.
            } while (checkForSimilar(eingabeArray, n, i, true) || !inRange(n)); // Pruefe auf Duplikate und gueltige Eingabe. Wenn eines fehlerhaft ist, wiederhole Eingabe.
            eingabeArray[i] = n; // Fuege die gueltige Zahl zum Array hinzu.
        }
        return eingabeArray;
    }

    /**
     * Vergleicht den Tipp des Spielers mit den gezogenen Lottozahlen.
     *
     * @param tip Das Array mit den Zahlen des Spielers.
     * @param numbers Das Array mit den gezogenen Lottozahlen.
     * @return Die Anzahl der Zahlen, die der Spieler richtig getippt hat.
     */
    static int compareNumbers(int[] tip, int[] numbers) {
        int counter = 0; // Zaehlt die Treffer

        // Vergleiche jede gezogene Zahl mit dem Tipp des Spielers
        for (int i = 0; i < numbers.length; i++) {
            if (checkForSimilar(tip, numbers[i], tip.length, false)) { // Pruefe, ob die Zahl im Tipp enthalten ist. tip.length, weil das ganze tip-Array angeschaft werden muss.
                counter++; // Treffer zaehlen
            }
        }
        return counter;
    }

    /**
     * ueberprueft, ob eine Zahl bereits im Array vorhanden ist.
     *
     * @param numbers Das Array, das ueberprueft wird.
     * @param n Die zu ueberpruefende Zahl.
     * @param index Der Index, bis zu welchem im Array ueberprueft wird.
     * @param withErrorMessage Wenn true: gibt eine Meldung auf der Konsole aus, wenn die Zahl schon vorhanden ist.
     * @return true, wenn die Zahl schon vorhanden ist, sonst false.
     */
    static boolean checkForSimilar(int[] numbers, int n, int index, boolean withErrorMessage) {
        // Durchlaufe das Array bis zum angegebenen Index
        for (int i = 0; i < index; i++) {
            if (numbers[i] == n) { // Zahl ist bereits vorhanden
                // Meldung, wenn gewollt.
                if (withErrorMessage) {
                    System.out.println("Die Zahl " + n + " kam schon einmal vor. Geben Sie bitte eine neue Zahl ein.");
                }
                return true; // Zahl ist bereits vorhanden - similar gefunden.
            }
        }
        return false; // Zahl ist noch nicht vorhanden
    }

    /**
     * ueberprueft, ob eine eingegebene Zahl im gueltigen Bereich (1 bis 49) liegt.
     *
     * @param n Die zu ueberpruefende Zahl.
     * @return true, wenn die Zahl im Bereich liegt, sonst false.
     */
    static boolean inRange(int n){
        if(n < 1 || n > 49){
            System.out.println("Die eingegebene Zahl liegt nicht im Bereich von 1 bis 49.");
            return false; // Zahl ist ungueltig
        }
        return true; // Zahl ist gueltig
    }
}