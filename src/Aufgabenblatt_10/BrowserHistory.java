package Aufgabenblatt_10;

import Helps.In;

/**
 * A program that simulates a browser history with the ability to navigate back and forward.
 * Users can input a web address, use "back" to return to the previous page,
 * or "forward" to move to the next page if available.
 *
 *
 * Input Options:
 *  - [Web address]: Adds the address to the browsing history.
 *  - "back": Moves to the previous page, if available.
 *  - "forward": Moves to the next page in history, if available.
 *
 * Output:
 *  - Displays the current page or relevant status messages.
 *
 *
 * @author Eduard Wayz (193123)
 * @version 1.0
 */
public class BrowserHistory {
    /**
     * This method is the executable part of the class that allows the user to create a simulated browserhistory
     * with the options: '[Web address]', 'back' and 'forward'.
     *
     * @param args command-line arguments (not used in this program)
     */
    public static void main(String[] args) {
        StringStack history = new ArrayStack(10);
        StringStack historyStorage = new ArrayStack(10);
        String EingabeString;

        while (true) {
            EingabeString = In.readString("Geben Sie bitte eine Web-Adresse oder das Wort 'back' ein: ");
            if (EingabeString.equals("back")) {
                String tempText = history.pop();
                historyStorage.push(tempText);
                if (tempText == null) {
                    System.out.println("Keine Historie mehr verfügbar");
                } else {
                    System.out.println("Zur Seite " + tempText + " gesprungen.");
                }
            } else if (EingabeString.equals("forward")) {

                history.push(historyStorage.pop());
                System.out.println(history.top());
            } else {
                history.push(EingabeString);
                System.out.println("Aufgerufene Seite: " + EingabeString);
            }
        }
    }
}
