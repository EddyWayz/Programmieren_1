package Aufgabenblatt_06;

/**
 * @author Eduard Wayz (193123)
 * @version 1.0
 */
public class Handshake {
    public static void main(String[] args) {
        // Berechnet die Zahl der Handschlaege von 8 Personen und gibt es auf der Konsole aus.
        System.out.println("Zahl der Handshakes: " + numberOfHandshakes(8));
    }

    /**
     * Brechnet die Anzahl der Handschlaege von n Personen rekursiv.
     *
     * @param n ist die Anzahl der Personen. (int)
     * @return die Anzahl der Handschlaege von n.
     */
    static int numberOfHandshakes(int n){
        // Base case für eine Person.
        if (n == 1) {
            return 0;
        }
        // Zahl der Handschlaege von n + die Handschlaege die davor schon waren. -> Rekursiver Aufruf.
        return (n-1) + numberOfHandshakes(n - 1);
    }
}
