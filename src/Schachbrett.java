// Autor: Edaurd Wayz

// Die Klasse Schachbrett erzeugt ein Schachbrett auf der Konsole mit
// variabler Größe der Quadratfelder und dem dabei verwendeten Zeichen
public class Schachbrett {
    public static void main(String[] args) {
        // Einstellen der Variablen:
        // k ist die Größe des einzelnen Quadratfeldes
        // c ist das Verwendete Zeichen
        int k = 7;
        char c = '*';

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < k; j++) {
                for (int m = 0; m < 4; m++) {
                    quadratStartWithChar(k, c);
                }
                System.out.println();
            }
            for (int j = 0; j < k; j++) {
                for (int m = 0; m < 4; m++) {
                    quadratStartWithSpace(k, c);
                }
                System.out.println();
            }
        }
    }

    static void quadratStartWithChar(int k, char c) {
            for (int j = 0; j < k; j++) {
                System.out.print(c + "  ");
            }
            for (int j = 0; j < k; j++) {
                System.out.print("   ");
            }
    }
    static void quadratStartWithSpace(int k, char c) {
            for (int j = 0; j < k; j++) {
                System.out.print("   ");
            }
            for (int j = 0; j < k; j++) {
                System.out.print(c + "  ");
            }
    }
}