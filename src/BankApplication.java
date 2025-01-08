
public class BankApplication {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Person p1 = new Person("Peter", "Coolman", new Date(10,10,1990));
        Person p2 = new Person("Alex", "Testman", new Date(7,12,2000));
        Person p3 = new Person("Christine", "Testfrau", new Date(11,11,2005));
        CheckingAccount chAcc1 = new CheckingAccount(new Date(10,1,2025), p1, (float) 250.0); 
        CheckingAccount chAcc2 = new CheckingAccount(new Date(9,3,2023), p2, (float) 607.0); 
        SavingsAccount sAcc1 = new SavingsAccount(new Date(3,6,1999), p3);
        
        Bank b1 = new Bank("Bank 1"); 
        b1.addAccount(chAcc1);
        b1.addAccount(chAcc2);
        b1.addAccount(sAcc1);
        System.out.println(b1.toString());
    }

}
