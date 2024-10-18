// Autor: Eduard Wayz

public class RollerCoaster {
    public static void main(String[] args) {

        // Frägt nach Eingabe und Speicherung von Alter, Größe und in Begleitung
        int age = In.readInteger("Alter: ");
        int heightInCm = In.readInteger("Größe in cm: ");
        boolean withParent = In.readBoolean("Mit Eltern? ");


        // Prüft als erstes, ob der Fahrgast mindestens 10 Jahre alt ist oder ob er mindestens 8 und in Begleitung seiner Eltern ist.
        // Wenn eines der beiden Fälle eintrifft und er dann noch zwischen 130 cm und 210 cm groß ist, darf er mitfahren. Sonst darf er nicht mitfahren.
        // Das Ergebnis wird in der Konsole ausgeben.

        if((age >= 10) || ((age >= 8) && (withParent == true))){
            if((130 <= heightInCm) && (heightInCm <= 210)){
                System.out.println("Du darfst mitfahren. Viel Spaß! ;)");
            } else {
                System.out.println("Du darfst nicht mitfahren, weil du nicht die passende Größe hast.");
            }
        } else {
            System.out.println("Du darfst nicht mitfahren, weil du nicht alt genug bist.");
        }
    }
}
