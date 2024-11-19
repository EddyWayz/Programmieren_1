import java.util.Arrays;

/**
 * @author Eduard Wayz (193123)
 * @version 1.0
 */
public class Lotto {
    public static void main(String[] args) {
        readPlayerTip();
    }

    /**
     * Gibt eine Zufallszahl von 1 bis 49 zurueck.
     *
     * @return Zufallszahl von 1 bis 49.
     */
    static int drawOneNumber() {
        return (int) (Math.random() * 49) + 1;
    }

    static int[] drawLottery() {
        int[] lotteryNumbers = new int[6];
        int tmpNumber;
        for (int i = 0; i < lotteryNumbers.length; i++) {
            do {
                tmpNumber = drawOneNumber();
                lotteryNumbers[i] = tmpNumber;
            } while (checkForSimilar(lotteryNumbers,tmpNumber, i));
        }
        System.out.println(Arrays.toString(lotteryNumbers));
        return lotteryNumbers;
    }

    /**
     * Ueberprueft auf gleiche Zahlen im Array von Index 0 bis index
     * @param numbers ist das Integer-Array. (int[][])
     * @param n ist die zu ueberpruefende Zahl.(int)
     * @param index ist das Index bis zu welchem die Zahl auf ein Vorkommen ueberprueft werden soll. (int)
     * @return true, wenn n schon einmal im Array vorkommt.
     */
    static boolean checkForSimilar(int[] numbers, int n, int index){
        for (int i = 0; i < index; i++) {
            if(numbers[i] == n){
                return true;
            }
        }
        return false;
    }

    static int[] readPlayerTip(){
        int[] eingabeArray = new int[6];
        int n;
        for (int i = 0; i < eingabeArray.length; i++) {
            do {
                n = In.readInt("Geben Sie eine Zahl von 1 bis 49 ein: ");
            } while (checkForSimilar(eingabeArray,n,i));
            eingabeArray[i] = n;
            System.out.println(Arrays.toString(eingabeArray));
        }
        return eingabeArray;
    }
}
