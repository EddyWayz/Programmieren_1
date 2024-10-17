// Autor: Eduard Wayz


public class Mehrwertsteuer {

    public static void main(String[] args) {
        double nettoPreis = In.readDouble("Geben Sie hier den Nettopreis ein (in Euro): ");
        double mehrwertsteuer = (nettoPreis/100) * 19;
        double bruttobetrag = nettoPreis + mehrwertsteuer;
        String nettoString = String.format("%.02f", nettoPreis);
        String mehrwertsteuerString = String.format("%.02f", mehrwertsteuer);
        String bruttobetragString = String.format("%.02f", bruttobetrag);
        System.out.printf("Bei einem Nettobetrag von " + nettoString + " Euro liegt die Mehrwertsteuer bei " + mehrwertsteuerString + " Euro. \n"+"Deshalb liegt der Bruttobetrag bei: " + bruttobetragString + " Euro.");
    }
}