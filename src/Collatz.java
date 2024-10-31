//@author: Eduard Wayz

public class Collatz {
    public static void main(String[] args) {
        // Long Variablen n und zaehler werden erstellt.
        // Datentyp long wird benötigt, weil die Zahlen, aber auch die Zahlenfolge über den Speicher von Integer hinaus gehen können.  
        long n;
        long zaehler = 0;

        // Frägt und überprüft, ob eine Zahl größer 1 eingegeben wird.
        do {
            n = In.readLong("Geben Sie bitte eine positve Zahl, größer 1 für die Collatz'sche Zahlenfolge ein: ");
        } while (n <= 1);

        // Solange n größer 1 ist, wird folgendes überprüft und ausgeführt:
        // Wenn n gerade ist, halbiere n und speichere neuen Wert in n.
        // Wenn n ungerade ist, rechne n * 3 + 1 und speichere in n.
        // Jedes neue n wird in einer neuen Zeile ausgegeben, bis am Ende eine 1 geprintet wird (also n == 1).
        // Bonus: Gleichzeitig zählt ein Zähler jede Runde hoch und bricht die While-Schleife mit einer Ausgabe auf der Konsole ab, 
        // wenn zaehler > 500 ist.  
        // Sonst wird unter der 1 noch die Länge der Folge geprintet. 
        while (n > 1) {
            System.out.println(n + " " +zaehler);
            zaehler++;
            if (zaehler > 2) {
                break;
            }
            if ((n % 2) == 0) {
                n = n / 2;
            } else if ((n % 2) != 0) {
                n = 3 * n + 1;
            }
        }
        
        if (zaehler == 3) {
            System.out.println("Die Folge wurde unterbrochen, weil die Folge jetzt länger als 500 ist.");
        } else {
            System.out.println(n);
            System.out.println("Die Länge der Folge ist: " + zaehler);

        }
    }
}
