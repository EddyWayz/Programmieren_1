// Autor: Eduard Wayz

public class LeapYear {
    public static void main(String[] args) {
        // Fragt nach Jahr und speichert es in yearInput
        int yearInput = In.readInt("Bitte geben Sie das Jahr zur Überprüfung hier an: ");


        // Prüft, ob es durch 400 teilbar ist. Wenn nicht, prüft es ob es durch 4, aber nicht durch 100 teilbar ist.
        // Wenn die Bindingung auch nicht erfültt ist, wird kein Schaltjahr ausgeben.
        if (yearInput % 400 == 0) {
            System.out.println("Das Jahr " + yearInput + " ist ein Schaltjahr.");
        } else if ((yearInput % 4 == 0) && ((yearInput % 100) != 0)) {
            System.out.println("Das Jahr " + yearInput + " ist ein Schaltjahr.");
        } else {
            System.out.println("Das Jahr " + yearInput + " ist kein Schaltjahr.");
        }
    }
}
