package Aufgabenblatt_01;// Autor: Eduard Wayz

import Helps.In;

public class MehrwertsteuerCent {
    public static void main(String[] args) {

        // Eingabe und Speicherung vom Nettopreis in Cent als Integer
        int nettoPreis = In.readInt("Geben Sie hier bitte den Nettopreis ein (in Cent): ");

        // Berechnung des Bruttobetrags und der Mehrwertsteuer
        int bruttobetrag = Math.round( (float) (nettoPreis * 1.19));
        int mehrwertsteuer = bruttobetrag - nettoPreis;

        // Ausgabe der Werte mit 2 Nachkommastellen
        System.out.println("Bei einem Nettobetrag von " + (double) (nettoPreis)/100 + " Euro, liegt die Mehrwertsteuer bei " + (double) (mehrwertsteuer)/100 + " Euro. \n"+"Deshalb liegt der Bruttobetrag bei: " + (double) (bruttobetrag)/100 + " Euro.");
    }
}