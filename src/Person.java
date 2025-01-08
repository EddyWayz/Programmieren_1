
public class Person {
    private Date birthDate;
    private String firstName; 
    private String lastName; 
    
    public Person(String firstName, String lastName, Date birthDate) {
        this.birthDate = birthDate; 
        this.firstName = firstName; 
        this.lastName = lastName;
    }
    
    public String getFullName() {
        return firstName + " " + lastName;
    }
}
