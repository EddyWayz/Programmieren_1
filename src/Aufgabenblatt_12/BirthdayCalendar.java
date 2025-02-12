package Aufgabenblatt_12;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * The BirthdayCalendar class manages a collection of {@link Person} objects and provides functionality
 * to add, remove, and query persons based on their birthdays.
 *
 * This class uses a {@link TreeSet} to store Person objects, ensuring they are sorted and unique
 * based on their natural ordering defined in the {@link Person} class.
 *
 * Features include:
 * - Adding and removing persons
 * - Retrieving all persons
 * - Finding persons with birthdays on a specific date
 * - Determining the next birthday after a given date
 *
 * @author Eduard Wayz
 * @version 1.0
 */
public class BirthdayCalendar {

    /**
     * The collection of persons stored in a sorted TreeSet.
     */
    private TreeSet<Person> treeSet;

    /**
     * Constructs an empty BirthdayCalendar.
     */
    public BirthdayCalendar() {
        treeSet = new TreeSet<>();
    }

    /**
     * Adds a person to the calendar.
     *
     * @param p the person to be added
     * @return true if the person was successfully added, false if the person already exists
     */
    public boolean addPerson(Person p) {
        return treeSet.add(p);
    }

    /**
     * Removes a person from the calendar.
     *
     * @param p the person to be removed
     * @return true if the person was successfully removed, false if the person was not found
     */
    public boolean removePerson(Person p) {
        return treeSet.remove(p);
    }

    /**
     * Retrieves a collection of all persons in the calendar.
     *
     * @return a collection of all persons
     */
    Collection<Person> persons() {
        ArrayList<Person> list = new ArrayList<>();
        Iterator<Person> it = treeSet.iterator();
        while (it.hasNext()) {
            list.add(it.next());
        }
        return list;
    }

    /**
     * Finds all persons in the calendar whose birthdays match a specific date.
     *
     * @param date the date to check for matching birthdays
     * @return a collection of persons celebrating their birthday on the specified date
     */
    Collection<Person> celebrators(Date date) {
        ArrayList<Person> list = new ArrayList<>();
        Iterator<Person> it = treeSet.iterator();
        while (it.hasNext()) {
            Person p = it.next();
            if (p.getBirthDate().isEquals(date)) {
                list.add(p);
            }
        }
        return list;
    }

    /**
     * Finds the next person in the calendar with a birthday after the specified date.
     *
     * @param date the date to start searching from
     * @return the next person with a birthday after the specified date, or null if no such person exists
     */
    public Person nextBirthday(Date date) {
        Iterator<Person> it = treeSet.iterator();
        while (it.hasNext()) {
            Person p = it.next();
            if (!p.getBirthDate().isBeforeWithoutYear(date)) {
                return p;
            }
        }
        return null;
    }
}