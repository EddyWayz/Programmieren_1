package Aufgabenblatt_11;

import Aufgabenblatt_07.Date;

/**
 * The CheckingAccount class represents a checking account with a credit limit.
 * Checking accounts allow overdrafts up to the specified credit limit.
 *
 * This class extends the abstract Account class and provides implementations for its specific transfer rules.
 *
 * @author Eduard Wayz (193123)
 */
public class CheckingAccount extends Account {
    /**
     * The credit limit of the checking account, allowing overdrafts up to this amount.
     */
    private float creditLimit;

    /**
     * Constructs a new CheckingAccount with the given creation date, owner, and credit limit.
     *
     * @param creationDate the date the account was created.
     * @param owner        the owner of the account.
     * @param creditLimit  the overdraft limit for this account.
     */
    public CheckingAccount(Date creationDate, Person owner, float creditLimit) {
        super(creationDate, owner);
        this.creditLimit = creditLimit; 
    }

    /**
     * Checks whether a transfer from this checking account to the target account is allowed.
     * A transfer is allowed if:
     * - The resulting balance after the transfer does not exceed the overdraft limit.
     *
     * @param target the target account for the transfer.
     * @param amount the amount to transfer.
     * @return true if the transfer is allowed, false otherwise.
     */
    @Override
    protected boolean checkTransferFromHere(Account target, float amount) {
        return this.getBalance() - amount > 0 - this.creditLimit;
    }

    /**
     * Always allows transfers to this checking account.
     *
     * @param source the source account for the transfer.
     * @param amount the amount to transfer.
     * @return true, as all incoming transfers are allowed.
     */
    @Override
    protected boolean checkTransferToHere(Account source, float amount) {
        return true;
    }

    /**
     * Returns a string representation of the checking account.
     *
     * @return a string containing the checking account details.
     */
    @Override
   public String toString() {
       // TODO
       return super.toString();
   }

}
