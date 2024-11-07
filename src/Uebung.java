public class Uebung {
  public static void main(String[] args){
    CompoundInterest(In.readInt(), In.readInt(), In.readInt());
  }

  static void CompoundInterest(float zinssatz, float anfangssumme, int jahre){
    for(int i = 0; i<jahre; i++){
      anfangssumme += anfangssumme*(zinssatz/100);
      String nettoPreisString = String.format("%.02f", (float) anfangssumme);
      System.out.println(nettoPreisString);
    }
  }
} 
