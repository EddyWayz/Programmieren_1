//@author: Eduard Wayz

public class DateChecker {
  public static void main(String[] args){
      int day = In.readInt("Bitte geben Sie hier den Tag des zu prüfenden Tags ein: ");
      int month = In.readInt( "Bitte geben Sie hier den Monat des zu prüfenden Tags ein: ");
      int year = In.readInt( "Bitte geben Sie hier das Jahr des zu prüfenden Tags ein: ");
      System.out.println(isValidDate(day, month, year));
  }

  static boolean isLeapYear(int year){
    if (((year % 400) == 0) || (((year % 4) == 0) && ((year % 100) != 0))) {
        return true; 
    } else {
        return false;
    }
  }

  static int numberOfDays(int month, int year) {
      switch (month) {
          case 1:
              return 31;
          case 2:
              if (isLeapYear(year)) {
                  return 29;
              } else {
                  return 28;
              }
          case 3:
              return 31;
          case 4:
              return 30;
          case 5:
              return 31;
          case 6:
              return 30;
          case 7:
              return 31;
          case 8:
              return 31;
          case 9:
              return 30;
          case 10:
              return 31;
          case 11:
              return 30;
          case 12:
              return 31;
          default:
              return -99;
      }
  }

  static boolean isValidDate(int day, int month, int year) {
      if (year < 0 ) {
          System.out.println("Fehler 1");
          return false;
      }
      if ((month < 1) || (month > 12)) {
          System.out.println("Fehler 2");
          return false;
      }
      if (day < 1 || day > numberOfDays(month, year)) {
          return false;
      }
      return true;
  }
}