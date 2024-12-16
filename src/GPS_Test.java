/**
 * @author Eduard Wayz (193123)
 * @version 1.0
 *
 * A test class for the {@link GlobalPosition} class.
 * It demonstrates the usage of various {@code GlobalPosition} instances
 * and compares them based on their geographical coordinates (latitude and longitude).
 * The program tests the methods for checking whether one position is north or east of another,
 * as well as checking for equality between different positions.
 */
public class GPS_Test {
/**
 * The main method for testing the functionality of the {@link GlobalPosition} class.
 *
 * @param args Command-line arguments (not used)
 */
    public static void main(String[] args) {
        GlobalPosition offenburg = new GlobalPosition(48.473451, 7.9498017);
        GlobalPosition sydney = new GlobalPosition(-33.867487, 151.206990);
        GlobalPosition nordpol_1 = new GlobalPosition(90.0, 0.0);
        GlobalPosition nordpol_2 = new GlobalPosition(90.0, 156.4);
        GlobalPosition p1 = new GlobalPosition(45.9, 180.0);
        GlobalPosition p2 = new GlobalPosition(45.9, -180.0);
        GlobalPosition p3 = new GlobalPosition(15.34, 180.0);
        GlobalPosition p4 = new GlobalPosition(-78.3, -180.0);
        GlobalPosition nullPunkt = new GlobalPosition(15.34, -185.0);

        System.out.println("\nDaten der Punkte:");
        System.out.println("Offenburg: " + offenburg);
        System.out.println("Sydney: " + sydney);
        System.out.println("Nordpol_1: " + nordpol_1);
        System.out.println("Nordpol_2: " + nordpol_2);
        System.out.println("P1: " + p1);
        System.out.println("P2: " + p2);
        System.out.println("P3: " + p3);
        System.out.println("P4: " + p4);
        System.out.println("Nullpunkt: " + nullPunkt);
        System.out.println("\nVergleiche Offenburg und Sydney: ");
        System.out.println("Offenburg liegt noerdlich als Sydney: " + offenburg.isNorthOf(sydney));
        System.out.println("Sydney liegt noerdlich als Offenburg: " + sydney.isNorthOf(offenburg));
        System.out.println("Offenburg liegt oestlich als Sydney: " + offenburg.isEastOf(sydney));
        System.out.println("Sydney liegt oestlich als Offenburg: " + sydney.isEastOf(offenburg));

        System.out.println("\nVergleiche weitere Punkte: ");
        System.out.println("Die Punkte 'offenburg' und 'sydney' repraesentieren den gleichen Punkt: " + offenburg.equals(sydney));
        System.out.println("Die Punkte 'nordpol_1' und 'nordpol_2' repraesentieren den gleichen Punkt: " + nordpol_1.equals(nordpol_2));
        System.out.println("Die Punkte 'p1' und 'p2' repraesentieren den gleichen Punkt: " + p1.equals(p2));
        System.out.println("Der Punkt 'p3' liegt oestlich von 'p4' : " + p3.isEastOf(p4));
        System.out.println("Der Nullpunkt liegt weiter oestlich als 'p3': " + nullPunkt.isEastOf(p4));
        System.out.println("Der Nullpunkt liegt weiter noerdlich als Sydney: " + nullPunkt.isNorthOf(sydney));
        System.out.println("Der Nullpunkt liegt weiter noerdlich als Offenburg: " + nullPunkt.isNorthOf(offenburg));
        System.out.println("\nTest mit extremen und ungültigen Eingabewerten:");
    }
}
