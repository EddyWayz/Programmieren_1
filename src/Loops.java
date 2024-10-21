//Autor: Eduard Wayz

public class Loops {
    public static void main(String[] args) {
        // Fragt nach der Zahl n und speichert sie ab
        int n = In.readInt("Geben Sie eine Zahl ein: ");
        System.out.println(); // Eine Leerzeile

        // Gibt alle geraden Zahlen von 0 bis einschließlich n in einer Zeile aus
        System.out.println("Alle geraden Zahlen von 0 bis n:");
        for (int i = 0; i <= n; i = i+2) System.out.print(i + " ");
        System.out.println("\n");

        // Gibt alle Zahlen von n bis 0 rückwärts in einer Zeile aus
        System.out.println("Alle Zahlen von n bis 0 rückwärts:");
        for (int i = n; i >= 0; i--) System.out.print(i + " ");
        System.out.println("\n");

        // Berechnet den Kontostand eines Kontos mit anfänglichem Kontostand von 100 EUR
        // für die nächsten n Jahre mit einem Zinssatz von 2,5% und gibt diesen aus.
        // Ergebnis wird auf zwei Nachkommastellen gerundet
        System.out.println("Der Kontostand (100 EUR) nach n Jahren mit einem Zinssatz von 2,5%:");
        double kontostand = 100;
        for(int i = 1; i<=n; i++){
            kontostand = (kontostand*1.025);
        }
        System.out.println(String.format("%.02f", kontostand) + " EUR \n");

        // Schreibt alle Zahlen von 0 bis n in eine Zeile, summiert sie auf
        // und schreibt das Quadrat der Summe in die nächste Zeile
        System.out.println("Alle Zahlen von 0 bis n und die Summe darunter:");
        int summe = 0;
        for (int i = 0; i <= n; i++){
            summe += i;
            System.out.print(i + " ");
        }
        System.out.println("\n" + summe + "\n");


        // Schreibt alle Kubikzahlen von 0 bis n in eine Zeile,
        // summiert sie auf und schreibt die Summe in die nächste Zeile
        System.out.println("Alle Kubikzahlen von 0 bis n und die Summe dieser darunter: ");
        summe = 0;
        for (int i = 0; i <= n; i++){
            summe += i * i * i;
            System.out.print((int) Math.pow(i,3) + " ");
        }
        System.out.println("\n" + summe);

        // Bonus: Die ausgegebenen Summen von Aufgabe 4 und 5 hängen folgendermaßen zusammen:
        // Die Summe aus Aufgabe 5 ist die Quadratzahl der Summe aus Aufgabe 4.
        // Andersrum ist die Wurzel von der Summe aus Aufgabe 5, die Summe aus Aufgabe 4.
    }
}
