// Autor: Eduard Wayz

public class MehrwertsteuerCent {

    public static void main(String[] args) {
        int nettoPreis = In.readInt("Geben Sie hier den Nettopreis ein (in Cent): ");
        int bruttobetrag = (int) (nettoPreis * 1.19);
        int mehrwertsteuer = bruttobetrag - nettoPreis;
        System.out.println("Bei einem Nettobetrag von " + (double) (nettoPreis)/100 + " Euro, liegt die Mehrwertsteuer bei " + (double) (mehrwertsteuer)/100 + " Euro. \n"+"Deshalb liegt der Bruttobetrag bei: " + (double) (bruttobetrag)/100 + " Euro.");
    }
}