/**
 *@author Eduard Wayz (193123)
 *@version 1.0 
*/

public class Date {
  /** Day of the date */
  private int day;
  /** Month of the date */
  private int month;
  /** Year of the date */
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
    * constructor with individuel day, month and year.
    
    *@param day is the date
    *@param month of the date
    *@param year of the date
    */
  public Date(int day, int month, int year) {
    if(isValidDate(day, month, year)){
        this.day = day; 
        this.month = month;
        this.year = year; 
    } else {
        this.day = 1; 
        this.month = 1; 
        this.year = 2024; 
    }
  }

    public Date(Date other) {
        this(other.day, other.month, other.year); 
    }

    public int getDay(){
        return day; 
    }

    public int getMonth(){
        return month; 
    }

    public int getYear(){
        return year; 
    }

    @Override
    public String toString(){
        String dayString = String.format("%02d", day);
        String monthString = String.format("%02d", month);
        String yearString = String.format("%04d", year);
        return dayString + "." + monthString + "." + yearString;
    }

    /**
    * Change the date if the iput is a valid date
    *
    */
    public boolean setDate(int newDay, int newMonth, int newYear){
        if(isValidDate(newDay, newMonth, newYear)){
            day= newDay; 
            month = newMonth; 
            year = newYear;
            return true; 
        } else {
            return false; 
        }
    }
  /**
   * ueberprueft, ob das eingegebene Datum ein gueltiges Datum ist.
   * Folgende ueberpruefungen werden durchgefuehrt: 
   * - Ist das Jahr gueltig? Es sollen nur positive Jahreszahlen zugelassen sein.
   * - Ist der Monat gueltig? Die Zahl muss zwischen 1 und 12 liegen.
   * - Ist der Tag gueltig? Die Zahl muss zwischen 1 und Anzahl der Tage des entsprechenden Monats (im entsprechenden Jahr) liegen. 
   * @param day ist der zu ueberpruefende Tag
   * @param month ist der zu ueberpruefende Monat
   * @param year ist das zu ueberpruefende Jahr
   * @return true, wenn es sich um ein gueltiges Datum handelt, sonst false (boolean)
   */
    static boolean isValidDate(int day, int month, int year) {
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
   * Gibt die Anzahl der Tage des uebergebenen Monats unter Beruecksichtigung eines moeglichen Schaltjahres zurueck.
   * @param month Der Monat, von welchem die Anzahl der Tage zurueckgegeben werden soll. (int)
   * @param year Das Jahr, aus welchem month ist (noetig fuer Schaltjahr-ueberpruefung). (int)
   * @return die Anzahl der Tage des eigegeben Monats. (int)
   */
  static int numberOfDays(int month, int year) {
      switch (month) {
          case 2: 
              if (isLeapYear(year)) {
                  return 29;
              } else {
                  return 28; 
              }
          case 1,3,5,7,8,10,12: 
              return 31; 
          case 4,6,9,11:
              return 30; 
          default:
            return -1; //Fehlerhafte Eingabe!
      }
  }
      /**
       * ueberprueft, ob das uebergebene Jahr ein Schaltjahr ist.
       * Ein Jahr ist ein Schaltjahr, wenn es durch 400 teilbar ist.
       * Oder wenn es durch 4, aber nicht durch 100 teilbar ist. 
       * 
       * @param year Das zu ueberpruefende Jahr (int).
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
    *
    *
    */
    boolean isEquals(Date other){
        return this.day == other.day && this.month == other.month && this.year == other.year;
    }

    boolean isBefore(Date other){
        if(this.year < other.year){
            return true; 
        } else if (this.year > other.year) {
            return false; 
        } else {
                if(this.month < other.month){
                    return true; 
                } else if (this.month > other.month) {
                    return false; 
                } else {
                    if(this.day < other.day){
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
     * Create a new Date-object that is one day after the momentanly Date
     *
     */
    Date nextDay(){
        Date nextDay = new Date(this); 
        if(isValidDate(nextDay.day + 1,nextDay.month, nextDay.year)){
            nextDay.setDate(nextDay.day + 1,nextDay.month, nextDay.year); 
            return nextDay; 
        } else if(isValidDate(1, nextDay.month + 1, nextDay.year)){
            nextDay.setDate(1,nextDay.month + 1, nextDay.year); 
            return nextDay; 
        } else {
            nextDay.setDate(1,1,nextDay.year+1);
            return nextDay;
        }
    }

    /** 
    * Gives the weeday of a date that is after October 15, 1582.
    *@return weekday of the day ("monday", "tuesday", ... , "sunday")
    */
    public String getWeekday(){
        int h; //weekday index (0 = saturday, 1 = sunday, ... , 6 = friday)
        int q; // day of the month 
        int m; // month (3 = march, 4 = april, ... , 12 = december, januar = 13 and februar = 14 of the last year!)
        int year = this.year;
        int j; // century (the first two digits of a year)
        int k; // year of the century (the last two digits of a year)
        
        q = this.day; 
        if(this.month == 1){
            m = 13; 
            year--; 
        } else if(this.month == 2){
            m = 14;
            year--; 
        } else {
            m = this.month; 
        }
        j = year / 100; 
        k = year % 100; 
        
        // Zettel's algorithm
        h = (q + ((13*(m+1))/5) + k + (k/4) + (j/4) - 2*j) % 7;
        
        switch (h){
            case 0: 
                return "saturday";
            case 1: 
                return "sunday";
            case 2: 
                return "monday";
            case 3: 
                return "tuesday";
            case 4: 
                return "wednesday";
            case 5: 
                return "thursday";
            case 6: 
                return "friday";
            default: 
                return "fail";
        }
    }
}