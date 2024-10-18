// Autor: Eduard Wayz

public class Mehrwertsteuer {
    public static void main(String[] args) {

        // Eingabe und Speicherung vom Nettopreis in Euro.
        // Hierfür habe ich den Datentyp double verwendet, da sehr große Kommazahlen eingegeben werden sollten können
        double nettoPreis = In.readDouble("Geben Sie hier den Nettopreis ein (in Euro): ");

        // Initialisierung und Berechnung der Mehrwertsteuern und des Bruttobetrages.
        // Da die Eingabe ein Double ist, sind folgende Variablen auch Double
        double mehrwertsteuer = (nettoPreis/100) * 19;
        double bruttobetrag = nettoPreis + mehrwertsteuer;

        // Formatierung für ausgeben mit 2 Nachkommastellen und Ausgabe der drei Variablen
        String nettoPreisString = String.format("%.02f", nettoPreis);
        String mehrwertsteuerString = String.format("%.02f", mehrwertsteuer);
        String bruttobetragString = String.format("%.02f", bruttobetrag);


        /* Zweite Option ohne Sting.format -> Gerundet auf zwei Nachkommastellen.
        nettoPreis *= 100;
        nettoPreis = Math.round(nettoPreis);
        nettoPreis /= 100;

        mehrwertsteuer *= 100;
        mehrwertsteuer = Math.round(mehrwertsteuer);
        mehrwertsteuer /= 100;

        bruttobetrag *= 100;
        bruttobetrag = Math.round(bruttobetrag);
        bruttobetrag /= 100;
        */

        System.out.printf("Bei einem Nettobetrag von " + nettoPreisString + " Euro liegt die Mehrwertsteuer bei " + mehrwertsteuerString + " Euro. \n"+"Deshalb liegt der Bruttobetrag bei: " + bruttobetragString + " Euro.");
        // System.out.printf("Bei einem Nettobetrag von " + nettoPreis + " Euro liegt die Mehrwertsteuer bei " + mehrwertsteuer + " Euro. \n"+"Deshalb liegt der Bruttobetrag bei: " + bruttobetrag + " Euro.");
    }
}