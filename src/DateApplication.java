public class DateApplication {
  public static void main(String[] args){
    Date date1 = new Date(17,11,2023);
    Date date2 = new Date(29,02,2024);
    Date date3 = new Date(20,20,2020);
    Date date4 = new Date(29,02,1900);
    Date date5 = new Date(31,12,1999);
    Date birthdayDate = new Date(11,11,2005);
    System.out.println(date1.toString());
    System.out.println(date2.toString());
    System.out.println(date3.toString());
    System.out.println(date4.toString());
    System.out.println(date5.toString());
    System.out.println(birthdayDate.toString());
    /*
    Date copy = new Date(date5);
    System.out.println("The object 'copy' and the object with the date '31.12.1999' are really the same: " + copy.isEquals(date5));
    Date newYearsDay = copy.nextDay(); 
    System.out.println("The day after 'copy': " + newYearsDay.toString());
    */

    // bonus-task
    Date currentDate = new Date(3,12,2024); // I've taked the date of the next tuesday because of the possible presentation.
    System.out.println("The weekday of the current week: " + currentDate.getWeekday()); 
    System.out.println("The weekday of my birthday (november 11, 2005): " + birthdayDate.getWeekday());
    
  }
}