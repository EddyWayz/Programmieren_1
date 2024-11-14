/**
 * @author Eduard Wayz (193123)
 * @version 1.0
 */
public class BitOperations {

    public static void main(String[] args) {
        int a = 4;
        System.out.println(Integer.toBinaryString(a));
        int b = ~a;
        System.out.println(Integer.toBinaryString(b));

        b = a >> 1;
        System.out.println(Integer.toBinaryString(b));
        System.out.println(b);
    }

}