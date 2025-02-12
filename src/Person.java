package Aufgabenblatt_12;


/**
 * The Person class represents a person with a first name, last name, and birth date.
 * It includes methods to compare, check equality, retrieve the full name, and generate a string representation.
 * This class implements the {@link Comparable} interface for comparing Person objects.
 *
 * @author Eduard Wayz (193123)
 * @version 1.0
 */
public class Person implements Comparable<Person> {

    /**
     * The birth date of the person.
     */
    private Date birthDate;

    /**
     * The first name of the person.
     */
    private String firstName;

    /**
     * The last name of the person.
     */
    private String lastName;

    /**
     * Constructs a new Person with the specified first name, last name, and birth date.
     *
     * @param firstName the first name of the person
     * @param lastName  the last name of the person
     * @param birthDate the birth date of the person
     */
    public Person(String firstName, String lastName, Date birthDate) {
        this.birthDate = birthDate;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Retrieves the birth date of the person.
     *
     * @return the birth date of the person
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * Compares this person to another object for equality.
     * Two persons are considered equal if they have the same first name, last name, and birth date.
     *
     * @param other the object to compare with
     * @return true if the other object is a Person with the same attributes, false otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (other instanceof Person) {
            Person otherPerson = (Person) other;
            return compareTo(otherPerson) == 0;
        }
        return false;
    }

    /**
     * Returns a string representation of the person, including their birth date, first name, and last name.
     *
     * @return a string containing the person's details
     */
    @Override
    public String toString() {
        return "Birthday: " + birthDate + ", First Name: " + firstName + ", Last Name: " + lastName;
    }

    /**
     * Returns the full name of the person, combining their first name and last name.
     *
     * @return the full name of the person
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }

    /**
     * Compares this person with another Person object.
     * The comparison is based on birth date, last name, and first name, in that order.
     *
     * @param other the other Person to compare with
     * @return a negative integer, zero, or a positive integer as this person is less than, equal to, or greater than the specified person
     */
    @Override
    public int compareTo(Person other) {
        if ((this.birthDate.getDay() == other.birthDate.getDay()) &&
                (this.birthDate.getMonth() == other.birthDate.getMonth()) &&
                (this.birthDate.getYear() == other.birthDate.getYear()) &&
                (this.firstName.equals(other.firstName)) &&
                (this.lastName.equals(other.lastName))) {
            return 0;
        }
        if (birthDate.getDay() == other.birthDate.getDay() && birthDate.getMonth() == other.birthDate.getMonth()) {
            if (this.lastName.compareTo(other.lastName) == 0) {
                if (this.firstName.compareTo(other.firstName) == 0) {
                    return this.birthDate.getYear() - other.birthDate.getYear();
                } else {
                    return this.firstName.compareTo(other.firstName);
                }
            } else {
                return this.lastName.compareTo(other.lastName);
            }
        } else {
            if (this.birthDate.getMonth() - other.birthDate.getMonth() == 0) {
                return this.birthDate.getDay() - other.birthDate.getDay();
            } else {
                return this.birthDate.getMonth() - other.birthDate.getMonth();
            }
        }
    }
}