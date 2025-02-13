package Aufgabenblatt_11;

import Aufgabenblatt_07.Date;

/**
 * The Person class represents a person with a first name, last name, and birth date.
 * This class includes methods to check equality, generate a string representation, and retrieve the full name.
 *
 * @author Eduard Wayz (193123)
 */

 public class Person {
    /**
     * The birthdate of the person.
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
     * @param firstName the first name of the person.
     * @param lastName  the last name of the person.
     * @param birthDate the birthdate of the person.
     */
    public Person(String firstName, String lastName, Date birthDate) {
        this.birthDate = birthDate; 
        this.firstName = firstName; 
        this.lastName = lastName;
    }

    /**
     * Compares this person to another object for equality.
     * Two persons are considered equal if they have the same first name, last name, and birthdate.
     *
     * @param other the object to compare with.
     * @return true if the other object is a Person with the same first name, last name, and birthdate, false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if (other instanceof Person) {
            Person otherPerson = (Person) other;
            return this.firstName.equals(otherPerson.firstName) && this.lastName.equals(otherPerson.lastName) && this.birthDate.isEquals(otherPerson.birthDate);
        }
        return false;
    }

    /**
     * Returns a string representation of the person, including their birthdate, first name, and last name.
     *
     * @return a string containing the person's details.
     */
    @Override
    public String toString() {
        return "Birthday: " + birthDate + ", First Name: " + firstName + ", Last Name: " + lastName;
    }


    /**
     * Returns the full name of the person, combining their first name and last name.
     *
     * @return the full name of the person.
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }
}
