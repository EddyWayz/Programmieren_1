public class LeapYear {

    public static void main(String[] args) {
        int yearInput = In.readInt();

        if((yearInput % 4 == 0) && ((yearInput % 100) != 0)) {
            System.out.println("Das Jahr "+ yearInput + " ist ein Schaltjahr.");
        } else if((yearInput % 400) == 0) {
            System.out.println("Das Jahr "+ yearInput + " ist ein Schaltjahr.");
        } else {
            System.out.println("Das Jahr "+ yearInput + " ist kein Schaltjahr.");
        }
    }
}