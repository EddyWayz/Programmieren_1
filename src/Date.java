/**
 * This class represents a date in the Gregorian calendar.
 * It provides methods to create and manipulate date objects.
 * Valid dates only include positive years and correct day-month combinations.
 *
 * @author Eduard Wayz (193123)
 * @version 1.0
 */
public class Date {
    /**
     * Day of the date
     */
    private int day;
    /**
     * Month of the date
     */
    private int month;
    /**
     * Year of the date
     */
    private int year;


    /**
     * default constructor that sets the date to 01.01.2024.
     */
    public Date() {
        this.day = 1;
        this.month = 1;
        this.year = 2024;
    }

    /**
     * Constructor with specified day, month, and year.
     * If the provided date is invalid, the default date (01.01.2024) is set.
     *
     * @param day   The day of the date.
     * @param month The month of the date.
     * @param year  The year of the date.
     */
    public Date(int day, int month, int year) {
        if (isValidDate(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        } else {
            this.day = 1;
            this.month = 1;
            this.year = 2024;
        }
    }

    /**
     * Copy constructor that creates a new Date object with the same values as another Date object.
     *
     * @param other The Date object to copy.
     */
    public Date(Date other) {
        this(other.day, other.month, other.year);
    }

    /**
     * Gets the day of the date.
     *
     * @return The day of the date.
     */
    public int getDay() {
        return day;
    }

    /**
     * Gets the month of the date.
     *
     * @return The month of the date.
     */
    public int getMonth() {
        return month;
    }

    /**
     * Gets the year of the date.
     *
     * @return The year of the date.
     */
    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        String dayString = String.format("%02d", day);
        String monthString = String.format("%02d", month);
        String yearString = String.format("%04d", year);
        return dayString + "." + monthString + "." + yearString;
    }

    /**
     * Sets the date to new values if they form a valid date.
     *
     * @param newDay   The new day.
     * @param newMonth The new month.
     * @param newYear  The new year.
     * @return true if the date was successfully set, false if the date was invalid.
     */
    public boolean setDate(int newDay, int newMonth, int newYear) {
        if (isValidDate(newDay, newMonth, newYear)) {
            day = newDay;
            month = newMonth;
            year = newYear;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if a given date is valid, considering leap years and month lengths.
     *
     * @param day   The day to check.
     * @param month The month to check.
     * @param year  The year to check.
     * @return true if the date is valid, false otherwise.
     */
    public boolean isValidDate(int day, int month, int year) {
        if (year < 0) {
            return false;
        }
        if ((month < 1) || (month > 12)) {
            return false;
        }
        if (day < 1 || day > numberOfDays(month, year)) {
            return false;
        }
        return true;
    }


    /**
     * Returns the number of days in a given month, considering leap years.
     *
     * @param month The month.
     * @param year  The year (to check for leap years).
     * @return The number of days in the month.
     */
    private int numberOfDays(int month, int year) {
        switch (month) {
            case 2:
                if (isLeapYear(year)) {
                    return 29;
                } else {
                    return 28;
                }
            case 1, 3, 5, 7, 8, 10, 12:
                return 31;
            case 4, 6, 9, 11:
                return 30;
            default:
                return -1; //error
        }
    }

    /**
     * Determines if a year is a leap year.
     *
     * @param year The year to check.
     * @return true if the year is a leap year, false otherwise.
     */
    private boolean isLeapYear(int year) {
        if (((year % 400) == 0) || (((year % 4) == 0) && ((year % 100) != 0))) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if this date is equal to another date.
     *
     * @param other The date to compare with.
     * @return true if both dates are equal, false otherwise.
     */
    public boolean isEquals(Date other) {
        return this.day == other.day && this.month == other.month && this.year == other.year;
    }

    /**
     * Checks if this date is before another date.
     *
     * @param other The date to compare with.
     * @return true if this date is before the other date, false otherwise.
     */
    public boolean isBefore(Date other) {
        if (this.year < other.year) {
            return true;
        } else if (this.year > other.year) {
            return false;
        } else {
            if (this.month < other.month) {
                return true;
            } else if (this.month > other.month) {
                return false;
            } else {
                if (this.day < other.day) {
                    return true;
                } else if (this.day > other.day) {
                    return false;
                } else {
                    return false;
                }
            }
        }
    }

    /**
     * Returns a new Date object representing the next day.
     *
     * @return The next day's Date object.
     */
    public Date nextDay() {
        Date nextDay = new Date(this);
        if (isValidDate(nextDay.day + 1, nextDay.month, nextDay.year)) {
            nextDay.setDate(nextDay.day + 1, nextDay.month, nextDay.year);
            return nextDay;
        } else if (isValidDate(1, nextDay.month + 1, nextDay.year)) {
            nextDay.setDate(1, nextDay.month + 1, nextDay.year);
            return nextDay;
        } else {
            nextDay.setDate(1, 1, nextDay.year + 1);
            return nextDay;
        }
    }
    // Bonus task
    /**
     * Returns a new Date object representing the next day.
     *
     * @return The next day's Date object.
     */
    public String getWeekday() {
        int h; //weekday index (0 = saturday, 1 = sunday, ... , 6 = friday)
        int q; // day of the month 
        int m; // month (3 = march, 4 = april, ... , 12 = december, januar = 13 and februar = 14 of the last year!)
        int year = this.year;
        int j; // century (the first two digits of a year)
        int k; // year of the century (the last two digits of a year)

        q = this.day;
        if (this.month == 1) {
            m = 13;
            year--;
        } else if (this.month == 2) {
            m = 14;
            year--;
        } else {
            m = this.month;
        }
        j = year / 100;
        k = year % 100;

        // Zettel's algorithm
        h = (q + ((13 * (m + 1)) / 5) + k + (k / 4) + (j / 4) - 2 * j) % 7;

        switch (h) {

            case 0:
                return "Saturday";
            case 1:
                return "Sunday";
            case 2:
                return "Monday";
            case 3:
                return "Tuesday";
            case 4:
                return "Wednesday";
            case 5:
                return "Thursday";
            case 6:
                return "Friday";
            default:
                return "Fail";
        }
    }
}