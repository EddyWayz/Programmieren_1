//@author: Eduard Wayz

public class DateChecker {
  public static void main(String[] args){
      int day = In.readInt("Bitte geben Sie hier den Tag des zu prüfenden Tags ein: ");
      int month = In.readInt( "Bitte geben Sie hier den Monat des zu prüfenden Tags ein: ");
      int year = In.readInt( "Bitte geben Sie hier das Jahr des zu prüfenden Tags ein: ");
      System.out.print(isLeapYear(year));
  }

  static boolean isLeapYear(int year){
    if (((year % 400) == 0) || (((year % 4) == 0) && ((year % 100) != 0))) {
        return true; 
    } else {
        return false;
    }
  }
}