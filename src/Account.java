
public abstract class Account {
    private int accountID;
    private float balance;
    private Date creationDate;
    private Person owner; 
    
    public Account(Date creationDate, Person owner) {
        this.creationDate = creationDate; 
        this.owner = owner; 
    }
    
    public int getAccountID() {
        return accountID; 
    }
    
    public float getBalance() {
        return balance; 
    }
    
    public Date getCreationDate() {
        return creationDate; 
    }
    
    public Person getOwner() {
        return owner; 
    }
}
