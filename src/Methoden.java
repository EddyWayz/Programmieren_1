public class Methoden{
  public static void main(String[] args){
    System.out.println(calculateCubicNumber(3));
    System.out.println(calculateCubicNumber(10));
    System.out.println(calculateCubicNumber(42));
    System.out.println(sumOfCubes(7));
    System.out.println(squareOfSum(7));
    for(int i = 1; i <= 50; i++){
      System.out.println("SumOfCubes: " + sumOfCubes(i) + " SquareOfSum: " + squareOfSum(i));
    }
    for(int i = 99; i <= 110; i++){
      System.out.println(quersumme(i));
    }
  }
  // Folgende Methode bekommt einen int n, potenziert diese mit 3 und gibt die Zahl als long aus.
  // Datentyp long, weil die Zahlen sehr groß werden können.
  static long calculateCubicNumber(int n){
    return n*n*n;
  }

  static long sumOfCubes(int n){
    long sum = 0;
    for(int i = 1; i <= n; i++){
      sum += calculateCubicNumber(i);
    }
    return sum;
  }

  static long squareOfSum(int n){
    long sum = 0;
    for(int i = 1; i <= n; i++){
      sum += i;
    }
    return sum*sum;
  }

  static int quersumme(long n){
    int sum = 0;
    do {
      sum += n % 10;
      n /= 10;
    } while (n > 0);
      
    return sum;
  }
}

