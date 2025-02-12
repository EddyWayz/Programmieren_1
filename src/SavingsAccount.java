package Aufgabenblatt_11;

import Aufgabenblatt_07.Date;

/**
 * The SavingsAccount class represents a savings account.
 * Savings accounts have specific transfer rules and an end date that is set to 5 years from the creation date.
 *
 * This class extends the abstract Account class and provides implementations for the transfer rules.
 *
 * @author Eduard Wayz (193123)
 */
public class SavingsAccount extends Account {
    /**
     * The end date of the savings account. Automatically set to 5 years from the account creation date.
     */
    private Date endDate;

    /**
     * Constructs a new SavingsAccount with the given creation date and owner.
     * The end date is automatically set to 5 years from the creation date.
     *
     * @param creationDate the date the account was created.
     * @param owner        the owner of the account.
     */
    public SavingsAccount(Date creationDate, Person owner) {
        super(creationDate, owner);
        endDate = new Date(creationDate.getDay(), creationDate.getMonth(), creationDate.getYear()+5);
    }

    /**
     * Checks whether a transfer from this savings account to the target account is allowed.
     * A transfer is allowed if:
     * - The target account has the same owner as this account.
     * - The transfer does not result in a negative balance for this account.
     *
     * @param target the target account for the transfer.
     * @param amount the amount to transfer.
     * @return true if the transfer is allowed, false otherwise.
     */
    @Override
    protected boolean checkTransferFromHere(Account target, float amount) {
        return (this.getOwner().equals(target.getOwner())) && (getBalance() - amount >= 0);
    }

    /**
     * Checks whether a transfer to this savings account from the source account is allowed.
     * A transfer is allowed if:
     * - The source account has the same owner as this account.
     * - The savings account was created on or after January 1, 2023.
     *
     * @param source the source account for the transfer.
     * @param amount the amount to transfer.
     * @return true if the transfer is allowed, false otherwise.
     */
    @Override
    protected boolean checkTransferToHere(Account source, float amount) {
        return (this.getOwner().equals(source.getOwner())) && !(this.getCreationDate().isBefore(new Date(1,1,2023)));
    }


    /**
     * Returns a string representation of the savings account.
     *
     * @return a string containing the account details.
     */
    @Override
    public String toString() {
        // TODO
       return super.toString();
    }
}
