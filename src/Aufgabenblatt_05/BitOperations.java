/**
 * @author Eduard Wayz (193123)
 * @version 1.0
 */

public class BitOperations {

    public static void main(String[] args) {
        System.out.println("dreimalXOR 1: ");
        dreimalXOR(3, 4);
        System.out.println("\ndreimalXOR 2: ");
        dreimalXOR(3, 1);
        System.out.println("\ndreimalXOR 3: ");
        dreimalXOR(12345, 67890);
    }

    /**
     * List das Bit Nr. 11 (gezaelt von rechts, bei 0 beginnend) einer uebergeben int-Zahl aus und printet es auf die Konsole.
     *
     * @param num ist die zu uebergebene int zahl. (int)
     */
    static void printBit(int num) {
        int bitmaske = 0b100000000000; // Bitmaske mit gesetztem Bit Nr. 11
        int bitAtIndex11 = (bitmaske & num) >> 11; // AND-Operation und Verschieben des Bits
        System.out.println(bitAtIndex11); // Direkte Ausgabe des Bits (0 oder 1)
    }

    static void printBit(int num, int k) {
        if (k >= 0 && k <= 31) { // pruefe ob k zwischen 0 und 31. Wenn ja, fahre Operation fort. Wenn nein gib Fehler aus.
            int bitmaske = createBitmask(k);
            int bitAtIndexK = (bitmaske & num) >> k;
            System.out.println("Das Bit an Position " + k + " ist: " + bitAtIndexK);
        } else {
            System.out.println("Fehler: k ist nicht zwischen 0 und 31");
        }

    }

    /**
     * Erzeugt eine Bitmaske mit einer 1 an der k-ten Stelle (von rechts, mit 0 beginnend)
     *
     * @param k
     * @return int als eine Bitmaske, die als k-tes Bit eine 1 und sonst nur Nullen enthaelt.
     * Oder -999999999 bei einer fehlerhaften Eingabe.
     */
    static int createBitmask(int k) {
        if (k >= 0 && k <= 31) { // k muss zwischen 0 und 31 liegen.
            return 1 << k;
        }
        return -999999999; // Fehlermeldung, da noch keine throw-Fehlermeldung in der Vorlesung.
    }

    /**
     * Setzt das k-te Bit der übergebenen int-Zahl auf 1. Die restlichen Bits bleiben unveraendert.
     *
     * @param number ist die zu veraendernde Zahl. (int)
     * @param k      ist das zu veraendernde Bit. (0 -> 1) (int)
     * @return int, was die Zahl mit dem veraenderten Bit ist. Oder -999999999 bei einer fehlerhaften Eingabe.
     */
    static int setBit(int number, int k) {
        if (k >= 0 && k <= 31) { // k muss zwischen 0 und 31 liegen.
            int bitmask = createBitmask(k);
            return (number | bitmask);
        } else {
            return -999999999; // Fehlermeldung, da noch keine throw-Fehlermeldung in der Vorlesung.
        }
    }

    /**
     * Setzt das k-te Bit der übergebenen int-Zahl auf 0. Die restlichen Bits bleiben unveraendert.
     *
     * @param number ist die zu veraendernde Zahl. (int)
     * @param k      ist das zu veraendernde Bit. (1 -> 0) (int)
     * @return int, was die Zahl mit dem veraenderten Bit ist. Oder -999999999 bei einer fehlerhaften Eingabe.
     */
    static int unsetBit(int number, int k) {
        if (k >= 0 && k <= 31) { // k muss zwischen 0 und 31 liegen.
            int bitmask = ~createBitmask(k); // umgekehrte Bitmaske
            return (number & bitmask);
        } else {
            return -999999999; // Fehlermeldung, da noch keine throw-Fehlermeldung in der Vorlesung.
        }
    }

    /**
     * Vertauscht durch drei aufeinanderfolgenden XOR-Operationen die Werte x und y ohne dabei einen zusätzlichen Speicher zu gebrauchen.
     * Zusaetzlich gibt sie einmal im Original und einem im vertauschten Zustand x und y auf der Konsole aus.
     * Beispiel x = 1 und y = 2 wird zu x = 2 und y = 1.
     *
     * @param x ist der erste Wert
     * @param y ist der zweite Wert
     */
    static void dreimalXOR(int x, int y) {
        System.out.println("x=" + x + " y=" + y);
        x = x ^ y; // erstes Mal x XOR y
        y = x ^ y; // zweites Mal x XOR y
        x = x ^ y; // drittes Mal x XOR y
        System.out.println("x=" + x + " y=" + y);
    }
}