//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        berechneDivision(2,3);
    }
    public static void berechneDivision(int a, int b) {
        try {
            // Code, der potenziell Exceptions auslöst
            int[] zahlen = new int[2];
            zahlen[2] = 5; // Löst ArrayIndexOutOfBoundsException aus
            int ergebnis = 10 / 0; // Löst ArithmeticException aus
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Fehler: Array-Index außerhalb des gültigen Bereichs.");
        } catch (ArithmeticException e) {
            System.out.println("Fehler: Division durch Null.");
        } catch (Exception e) {
            System.out.println("Allgemeiner Fehler: " + e.getMessage());
        }
    }
}