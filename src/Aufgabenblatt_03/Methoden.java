package Aufgabenblatt_03;

/**
 * Folgende Classe enthählt verschiedene Methoden, die unterschiedliche Rechenoperationen durchführen. 
 * Die Main-Methode enthält ein Beispiel für die Verwendung der Methoden.
 * @author Eduard Wayz
 * @version 1.0
 */ 

public class Methoden {
  public static void main(String[] args) {
    // Printet die verschiedenen Operationen und fügt eine weitere Leerzeile ein (\n).
    System.out.println("Cubic number of 3: " + calculateCubicNumber(3));
    System.out.println("\nCubic number of 10: " + calculateCubicNumber(10));
    System.out.println("\nCubic number of 42: " + calculateCubicNumber(42));
    System.out.println("\nSum of Cube of 7: " + sumOfCubes(7));
    System.out.println("\nSquare of sum of 7: " + squareOfSum(7));

    System.out.println("\nCompare SumOfCubes and SquareOfSum from 1 to 50: ");
    for (int i = 1; i <= 50; i++) {
      System.out.println("SumOfCubes: " + sumOfCubes(i) + " SquareOfSum: " + squareOfSum(i));
    }

    System.out.println("\nThe cross sums from 99 to 110 are: ");
    for (int i = 99; i <= 110; i++) {
      System.out.println("The cross sum of " + i + " is: " + quersumme(i));
    }
  }

  // Diese Methode bekommt einen int n, potenziert diese mit 3 und gibt die Zahl
  // als long aus.
  // Datentyp long, weil die Zahlen sehr groß werden können.
  static long calculateCubicNumber(int n) {
    return n * n * n;
  }

  // Diese Methode bekommt einen int n und addiert die Cubikzahlen von 1 bis n.
  // Diese Summe wird dann als long ausgegeben.
  // Datentyp long, weil die Zahlen sehr groß werden können.
  static long sumOfCubes(int n) {
    long sum = 0;
    for (int i = 1; i <= n; i++) {
      sum += calculateCubicNumber(i);
    }
    return sum;
  }

  // Diese Methode bekommt einen integer n und gibt das Quadrat der Summe von 1
  // bis n als long aus.
  // Datentyp long, weil die Zahlen sehr groß werden können.
  static long squareOfSum(int n) {
    long sum = 0;
    for (int i = 1; i <= n; i++) {
      sum += i;
    }
    return sum * sum;
  }

  // Diese Methode bekommt einen int n und gibt die Quersumme von n als int aus.
  // Datentyp kann hier int sein, da eine Quersumme, die größer als die in Integer
  // verfügbaren Zahlen,
  // schwer zu erreichen ist bzw. eine übermäßig große Zahl braucht.
  static int quersumme(long n) {
    int sum = 0;
    do {
      sum += n % 10;
      n /= 10;
    } while (n > 0);

    return sum;
  }
}
