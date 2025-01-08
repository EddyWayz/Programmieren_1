
public class CheckingAccount extends Account {
    private float creditLimit; 
    
    public CheckingAccount(Date creationDate, Person owner, float creditLimit) {
        super(creationDate, owner);
        this.creditLimit = creditLimit; 
    }
    
   public String toString() {
       // TODO
       return "";
   }
    
}
