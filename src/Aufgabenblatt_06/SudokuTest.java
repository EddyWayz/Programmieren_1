package Aufgabenblatt_06;

/**
 * @author Eduard Wayz (193123)
 * @version 1.0
 */
public class SudokuTest {
    public static void main(String[] args) {
        SudokuField field1 = new SudokuField(0,false); // Estelle eine neue Instanz Feld 1 vom Typ SodukoField mit value == 0 und fixed == false.
        System.out.println("Nachdem ich Feld 1 erzeugt habe, ist der Wert von Feld 1 '" + field1.getValue() + "' und das Feld ist fest: " + field1.isFixed());
        field1.setValue(2); // Setze value von field1 auf 2;
        System.out.println("Nachdem ich versucht habe, den Wert von Feld 1 zu veraendern, ist der Wert von Feld 1: '" + field1.getValue() + "' und das Feld ist leer: " + field1.isEmpty());
        field1.clear(); // Setze value von field1 wieder auf 0 (leer)
        System.out.println("Nachdem ich versucht habe, den Wert von Feld 1 zu leeren, ist der Wert von Feld 1 '" + field1.getValue() + "' und das Feld ist leer: " + field1.isEmpty());

        SudokuField field2 = new SudokuField(2,true); // Estelle eine neue Instanz Feld 2 vom Typ SodukoField mit value == 2 und fixed == true.
        System.out.println("\nNachdem ich Feld 2 erzeugt habe, ist der Wert von Feld 2 '" + field2.getValue() + "' und das Feld ist fest: " + field2.isFixed());
        field2.setValue(4); // Versuche value von field2 auf 4 zu setzen
        System.out.println("Nachdem ich versucht habe, den Wert von Feld 2 zu veraendern, ist der Wert von Feld 2: '" + field2.getValue() + "' und das Feld ist leer: " + field2.isEmpty());
        field2.clear(); // Versuche value von field2 auf 0 zu setzen (leer)
        System.out.println("Nachdem ich versucht habe, den Wert von Feld 2 zu leeren, ist der Wert von Feld 2 '" + field2.getValue() + "' und das Feld ist leer: " + field2.isEmpty());
        System.out.println("\nFazit: Dadurch, dass Feld 2 fest ist, kann man die Werte, im Gegensatz zu Feld 1, nicht aendern.");
    }
}
