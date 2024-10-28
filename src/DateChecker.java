//@author: Eduard Wayz

public class DateChecker {
  public static void main(String[] args){
      int day = In.readInt("Bitte geben Sie hier den Tag des zu prüfenden Tags ein: ");
      int month = In.readInt( "Bitte geben Sie hier den Monat des zu prüfenden Tags ein: ");
      int year = In.readInt( "Bitte geben Sie hier das Jahr des zu prüfenden Tags ein: ");
      System.out.println("Das eingegebene Datum ist: " + isValidDate(day, month, year));
  }

    /**
     * Überprüft, ob das übergebene Jahr ein Schaltjahr ist.
     * Ein Jahr ist ein Schaltjahr, wenn es durch 400 teilbar ist.
     * Oder wenn es durch 4, aber nicht durch 100 teilbar ist. 
     * 
     * @param year Das zu überprüfende Jahr (int).
     * @return true, wenn das Jahr ein Schaltjahr ist, sonst false (boolean).
     */
  static boolean isLeapYear(int year){
    if (((year % 400) == 0) || (((year % 4) == 0) && ((year % 100) != 0))) {
        return true; 
    } else {
        return false;
    }
  }
  /**
   * Gibt die Anzahl der Tage des übergebenen Monats unter Berücksichtigung eines möglichen Schaltjahres zurück.
   * @param month Der Monat, von welchem die Anzahl der Tage zurückgegeben werden soll. (int)
   * @param year Das Jahr, aus welchem month ist (nötig für Schaltjahr-Überprüfung). (int)
   * @return die Anzahl der Tage des eigegeben Monats. (int)
   */
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
              return -99; //Fehlerhafte Eingabe!
      }
  }
/**
 * Überprüft, ob das eingegebene Datum ein gültiges Datum ist.
 * Folgende Überprüfungen werden durchgeführt: 
 * - Ist das Jahr gültig? Es sollen nur positive Jahreszahlen zugelassen sein.
 * - Ist der Monat gültig? Die Zahl muss zwischen 1 und 12 liegen.
 * - Ist der Tag gültig? Die Zahl muss zwischen 1 und Anzahl der Tage des entsprechenden Monats (im entsprechenden Jahr) liegen. 
 * @param day
 * @param month
 * @param year
 * @return true, wenn es sich beim eingegebenen Datum, um ein gültiges Datum handelt, sonst false (boolean)
 */
  static boolean isValidDate(int day, int month, int year) {
      if (year < 0 ) {
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
}