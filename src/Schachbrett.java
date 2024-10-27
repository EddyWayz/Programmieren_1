// Autor: Eduard Wayz

// Die Klasse Schachbrett erzeugt ein Schachbrett auf der Konsole mit
// variabler Größe der Quadratfelder und dem dabei verwendeten Zeichen
public class Schachbrett {
    static final int k = 4;
    static final char c = '*';
    // Bei folgenden Konstanten stimmt die Anzahl an Leerzeichen beim MacBook, um Quadrate zu erzeugen, 
    // am iPad brauche ich jedoch jeweils ein Leerzeichen weniger. Um das flexibel anpassen zu können, 
    // habe ich das in Konstanten gespeichert. 
    static final String CHARWITHSPACE = c + "  ";
    static final String SPACE = "   ";

    public static void main(String[] args) {
        // Einstellen der Variablen k und c:
        // k ist die Größe des einzelnen Quadratfeldes
        // c ist das verwendete Zeichen

        // Folgende For-Schleife sorgt dafür, dass der Wechsel von Quadrat mit und Quadrat ohne Zeichen in der Senkrechten
        // so oft geschieht, dass am Ende 8 Felder nach unten entstehen. Hier geht i nur bis 4, weil immer ein Quadrat
        // mit und ein Quadrat ohne gebündelt geprintet wird.
        for (int i = 0; i < 4; i++) {
            // Diese For-Schleife sorgt dafür, dass die Funktion, welche die "Linien erzeugen" (lineStartsWithChar) genau
            // so oft untereinander ausgeführt wird, dass die Quadrate entstehen. Hier in Abhängigkeit von k.
            for (int j = 0; j < k; j++) {
                // Die nächste For-Schleife sorgt dafür, dass der Wechsel von Linie mit und Linie ohne Zeichen 4 Mal passiert.
                // Sorgt also für die 8 Felder zur Seite.
                for (int m = 0; m < 4; m++) {
                    lineStartsWithChar();
                }
                System.out.println();
            }
            // Funktion oben bereits genannt - hier nur Start mit der Linie ohne Zeichen für Schachbrettmuster.
            for (int j = 0; j < k; j++) {
                for (int m = 0; m < 4; m++) {
                    lineStartsWithSpace();
                }
                System.out.println();
            }
        }
    }

    // Diese Methoden erstellen abhängig von der eingestellten Größe k und dem Zeichen c zwei waagerechte Linien.
    // Eine Linie besteht aus Zeichen und Leerfeldern und die zweite Linie rechts davon besteht nur aus Leerzeichen.
    // Die erste Methode beginnt mit der Linie, wo auch Zeichen dabei sind. Die zweite Methode bekommt mit der ohne Zeichen.
    static void lineStartsWithChar() {
            for (int j = 0; j < k; j++) {
                System.out.print(CHARWITHSPACE);
            }
            for (int j = 0; j < k; j++) {
                System.out.print(SPACE);
            }
    }
    static void lineStartsWithSpace() {
            for (int j = 0; j < k; j++) {
                System.out.print(SPACE);
            }
            for (int j = 0; j < k; j++) {
                System.out.print(CHARWITHSPACE);
            }
    }
}