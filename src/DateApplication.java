/**
 * This class is a test application for the Date class.
 * It demonstrates the creation and manipulation of Date objects
 * and displays the results to the terminal.
 *
 * @author Eduard Wayz (193123)
 * @version 1.0
 */
public class DateApplication {
  /**
   * The main method creates Date objects and calls various methods from the Date class.
   * It prints the results of these operations to the terminal.
   *
   * @param args Command-line arguments (not used).
   */
  public static void main(String[] args){
    Date date1 = new Date(17,11,2023);
    Date date2 = new Date(29,2,2024);
    Date date3 = new Date(20,20,2020);
    Date date4 = new Date(29,2,1900);
    Date date5 = new Date(31,12,1999);
    Date birthdayDate = new Date(11,11,2005);
    System.out.println("Date 1: " + date1.toString());
    System.out.println("Date 2: " + date2.toString());
    System.out.println("Date 3: " + date3.toString());
    System.out.println("Date 4: " + date4.toString());
    System.out.println("Date 5: " + date5.toString());
    System.out.println("Birthday date: " + birthdayDate.toString());
    Date copy = new Date(date5);
    System.out.println("Copy of date 5: " + copy.toString());
    System.out.println("The object 'copy' and the object with the date '31.12.1999' are really the same: " + copy.isEquals(date5));
    Date newYearsDay = copy.nextDay(); 
    System.out.println("The day after 'copy': " + newYearsDay.toString());

    // bonus-task
    Date currentDate = new Date(3,12,2024); // I've taked the date of the next tuesday because of a possible presentation.
    System.out.println("The weekday of the current week: " + currentDate.getWeekday()); 
    System.out.println("The weekday of my birthday (november 11, 2005): " + birthdayDate.getWeekday());
    
  }
}