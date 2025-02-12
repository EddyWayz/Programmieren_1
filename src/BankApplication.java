package Aufgabenblatt_11;

import Aufgabenblatt_07.Date;

/**
 * The BankApplication class is the main class for testing the bank application functionality.
 * It creates a bank, accounts, and persons, and performs various operations like deposits, withdrawals, and transfers.
 * The program outputs the bank's status at different stages to verify the implementation.
 *
 * This class demonstrates:
 * - Creating and managing bank accounts.
 * - Enforcing transfer rules between accounts.
 * - Testing edge cases like invalid transfers or exceeding overdraft limits.
 *
 * @author Eduard Wayz (193123)
 */
public class BankApplication {
    /**
     * The main method serves as the entry point for the application.
     * It performs the following tasks:
     * - Creates a bank object.
     * - Creates persons and their associated accounts (checking and savings).
     * - Adds accounts to the bank.
     * - Performs deposits, withdrawals, and various transfer tests.
     * - Outputs the bank's status to validate the functionality.
     *
     * @param args command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Bank erstellen
        Bank bank = new Bank("Meine Bank");

        // Personen erstellen
        Person person1 = new Person("Max", "Mustermann", new Date(4, 4, 1999));
        Person person2 = new Person("Anna", "Schmidt", new Date());

        // Konten erstellen
        Account checkingAccount1 = new CheckingAccount(new Date(13, 2, 2025), person1, 500); // Max mit Girokonto
        Account checkingAccount2 = new CheckingAccount(new Date(1, 1, 2025), person2, 1000); // Anna mit Girokonto
        Account savingsAccount1 = new SavingsAccount(new Date(13, 2, 2025), person1); // Max mit Sparkonto
        Account savingsAccount2 = new SavingsAccount(new Date(1, 1, 2025), person2); // Anna mit Sparkonto

        // Konten zur Bank hinzufügen
        bank.addAccount(checkingAccount1);
        bank.addAccount(checkingAccount2);
        bank.addAccount(savingsAccount1);
        bank.addAccount(savingsAccount2);

        // Einzahlungen auf Konten
        checkingAccount1.deposit(200);
        savingsAccount1.deposit(1000);
        checkingAccount2.deposit(500);
        savingsAccount2.deposit(2000);

        // Ausgabe der Bankdaten vor Transaktionen
        System.out.println("Bankstatus vor Transaktionen:");
        System.out.println(bank);

        // Abhebung von Konten
        System.out.println("Bankstatus nach dem Abheben:");
        checkingAccount1.withdraw(100);
        savingsAccount1.withdraw(500);
        System.out.println(bank);
        // Überweisungen
        // Gültige Überweisung von Girokonto zu Girokonto
        boolean transfer1 = bank.transfer(checkingAccount1.getAccountID(), checkingAccount2.getAccountID(), 100);
        System.out.println("Überweisung 1 erfolgreich: " + transfer1);
        System.out.println(bank);
        // Ungültige Überweisung (negativer Betrag)
        boolean transfer2 = bank.transfer(checkingAccount1.getAccountID(), savingsAccount1.getAccountID(), -50);
        System.out.println("Überweisung 2 erfolgreich: " + transfer2);
        System.out.println(bank);
        // Überweisung von Sparkonto zu Sparkonto mit gleichem Besitzer
        boolean transfer3 = bank.transfer(savingsAccount1.getAccountID(), checkingAccount1.getAccountID(), 200);
        System.out.println("Überweisung 3 erfolgreich: " + transfer3);
        System.out.println(bank);
        // Überweisung zwischen Sparkonten unterschiedlicher Besitzer (soll fehlschlagen)
        boolean transfer4 = bank.transfer(savingsAccount1.getAccountID(), savingsAccount2.getAccountID(), 100);
        System.out.println("Überweisung 4 erfolgreich: " + transfer4);
        System.out.println(bank);
        // Ausgabe der Bankdaten nach Transaktionen
        System.out.println("\nBankstatus nach Transaktionen:");
        System.out.println(bank);

        System.out.println("\nWeitere Tests:");

        boolean transferSelf = bank.transfer(checkingAccount1.getAccountID(), checkingAccount1.getAccountID(), 100);
        System.out.println("Überweisung auf dasselbe Konto erfolgreich: " + transferSelf);
        System.out.println(bank);

        boolean overdraft = bank.transfer(checkingAccount2.getAccountID(), checkingAccount1.getAccountID(), 2000);
        System.out.println("Überziehungslimit überschritten und troztdem erfolgreich: " + overdraft);
        System.out.println(bank);

        // Annahme: maxSavings wurde vor dem 1.1.2023 erstellt
        savingsAccount1 = new SavingsAccount(new Date(13, 2, 2022), person1);
        boolean earlySavingsTransfer = bank.transfer(checkingAccount1.getAccountID(), savingsAccount1.getAccountID(), 200);
        System.out.println("Überweisung zu einem Sparkonto vor 1.1.2023 erfolgreich: " + earlySavingsTransfer);
        System.out.println(bank);
    }
}


