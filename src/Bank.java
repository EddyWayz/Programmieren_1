
public class Bank {
    private String name; 
    private Account[] accounts;
    
    public Bank(String name) {
        this.name = name;
        accounts = new Account[100];
    }
    
    public void addAccount(Account newAccount) {
        if(newAccount == null) return;
        
        for(int i = 0; i<accounts.length; i++) {
            if(accounts[i] == null) {
                accounts[i] = newAccount; 
            }
            
            if (findAccount(newAccount.getAccountID()) == null) return;
        }
    }
    
    public Account findAccount(int accountID) {
        for(Account acc : accounts) {
            if(acc == null) return null; 
            if (acc.getAccountID() == accountID) return acc;
        }
        return null; 
    }
    
    public String toString() {
        String s = "";
        for(Account acc : accounts) {
            if(acc == null) return s; 
            s += "Account " + acc.getAccountID() + ": Balance = " + acc.getBalance() + " €, Owner = " + acc.getOwner().getFullName() + ", Created = " + acc.getCreationDate() + "\n";
        }
        return s; 
    }
}
