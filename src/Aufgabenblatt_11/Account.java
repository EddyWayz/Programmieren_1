package Aufgabenblatt_11;

import Aufgabenblatt_07.Date;

/**
 * The Account class serves as an abstract representation of a bank account.
 * It includes basic account attributes such as ID, balance, creation date, and owner.
 * Specific account types extend this class to define their own behavior.
 *
 * This class also defines abstract methods for checking transfer rules, which must be implemented by subclasses.
 *
 * @author Eduard Wayz (193123)
 */

public abstract class Account {
    /**
     * The unique ID of the account.
     */
    private int accountID;

    /**
     * The current balance of the account.
     */
    private float balance;

    /**
     * The creation date of the account.
     */
    private Date creationDate;

    /**
     * The owner of the account.
     */
    private Person owner;

    /**
     * Static variable to collect all account IDs.
     */
    private static int accountIDs;


    /**
     * Constructs a new Account with the specified creation date and owner.
     * Initializes the balance to 0 and assigns a unique account ID.
     *
     * @param creationDate the date the account was created.
     * @param owner the owner of the account.
     */
    public Account(Date creationDate, Person owner) {
        this.creationDate = creationDate;
        this.owner = owner;
        this.balance = 0;
        this.accountID = accountIDs++;
    }

    /**
     * Returns the unique ID of the account.
     *
     * @return the account ID.
     */
    public int getAccountID() {
        return accountID;
    }

    /**
     * Returns the current balance of the account.
     *
     * @return the account balance.
     */
    public float getBalance() {
        return balance;
    }

    /**
     * Returns the creation date of the account.
     *
     * @return the creation date.
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Returns the owner of the account.
     *
     * @return the account owner.
     */
    public Person getOwner() {
        return owner;
    }

    /**
     * Deposits a specified amount into the account, increasing the balance.
     *
     * @param amount the amount to deposit.
     */
    public void deposit(float amount) {
        this.balance += amount;
    }

    /**
     * Withdraws a specified amount from the account, decreasing the balance.
     *
     * @param amount the amount to withdraw.
     */
    public void withdraw(float amount) {
        this.balance -= amount;
    }

    /**
     * Returns a string representation of the account, including its ID, balance, owner, and creation date.
     *
     * @return a string containing the account details.
     */
    @Override
    public String toString() {
        return "Account " + getAccountID() + ": Balance = " + getBalance() + " €, Owner = " + getOwner().getFullName() + ", Created = " + getCreationDate();
    }

    /**
     * Abstract method to check if a transfer from this account to a target account is allowed.
     *
     * @param target the target account for the transfer.
     * @param amount the amount to transfer.
     * @return true if the transfer is allowed, false otherwise.
     */
    protected abstract boolean checkTransferFromHere(Account target, float amount);

    /**
     * Abstract method to check if a transfer to this account from a source account is allowed.
     *
     * @param source the source account for the transfer.
     * @param amount the amount to transfer.
     * @return true if the transfer is allowed, false otherwise.
     */
    protected abstract boolean checkTransferToHere(Account source, float amount);
}
