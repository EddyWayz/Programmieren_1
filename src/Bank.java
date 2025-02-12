package Aufgabenblatt_11;
/**
 * The Bank class represents a bank that manages a list of accounts and facilitates transactions between them.
 * @author Eduard Wayz (193123)
 */

public class Bank {
    /**
     * The name of the bank.
     */
    private String name;
    /**
     * The array of accounts managed by the bank. The array has a fixed size of 100.
     */
    private Account[] accounts;

    /**
     * Creates a new Bank with the given name.
     *
     * @param name the name of the bank.
     */
    public Bank(String name) {
        this.name = name;
        accounts = new Account[100];
    }

    /**
     * Adds a new account to the bank if it is not already present and not null.
     *
     * @param newAccount the account to add.
     */
    public void addAccount(Account newAccount) {
        if(newAccount == null) return;
        
        for(int i = 0; i<accounts.length; i++) {
            if(accounts[i] == null) {
                accounts[i] = newAccount;
                return;
            }
            
            if (findAccount(newAccount.getAccountID()) != null) return;
        }
    }

    /**
     * Transfers an amount from one account to another if the transfer conditions are met.
     *
     * @param sourceID the ID of the source account.
     * @param targetID the ID of the target account.
     * @param amount   the amount to transfer.
     * @return true if the transfer is successful, false otherwise.
     */
    public boolean transfer(int sourceID, int targetID, float amount) {
        Account source = findAccount(sourceID);
        Account target = findAccount(targetID);
        if(checkTransfer(source, target, amount)){
            source.withdraw(amount);
            target.deposit(amount);
            return true;
        }
        return false;
    }

    /**
     * Returns a string representation of all accounts managed by the bank.
     *
     * @return a string containing account information.
     */

    @Override
    public String toString() {
        String s = "";
        for(Account acc : accounts) {
            if(acc == null) return s;
            s += acc.toString() + "\n";
        }
        return s;
    }

    /**
     * Finds and returns an account by its ID.
     *
     * @param accountID the ID of the account to find.
     * @return the account with the matching ID, or null if no such account exists.
     */
    private Account findAccount(int accountID) {
        for(Account acc : accounts) {
            if(acc == null) return null; 
            if (acc.getAccountID() == accountID) return acc;
        }
        return null; 
    }

    /**
     * Checks whether a transfer between two accounts is valid based on specific conditions.
     *
     * @param source the source account.
     * @param target the target account.
     * @param amount the amount to transfer.
     * @return true if the transfer is valid, false otherwise.
     */
    private boolean checkTransfer(Account source, Account target, float amount){
        if (source == null) return false;
        if (target == null) return false;
        if(amount < 0) return false;
        return source.checkTransferFromHere(target, amount) && target.checkTransferToHere(source, amount);
    }
    

}
