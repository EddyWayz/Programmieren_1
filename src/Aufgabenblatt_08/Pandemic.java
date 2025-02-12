/**
 * Klasse zum Durchführen und Testen 
 * der Simulation (Blatt 6)
 *  
 * @author Tobias Lauer
 *
 */

// Aufgabe d)
	// 1.Durchlauf: 347 Tage und 1233 Ueberlebende
	// 2.Durchlauf: 323 Tage und 1353 Ueberlebende
	// 3.Durchlauf: 343 Tage und 1283 Ueberlebende
	// 4.Durchlauf: 334 Tage und 1247 Ueberlebende
	// 5.Durchlauf: 360 Tage und 1170 Ueberlebende
// Aufgabe e)
	// Infektionsrisiko um die Haelfte reduziert:
	// 180 Tage im Durchschnitt und 2300 Ueberlebende im Durchschnitt.

	// Mortalitaetsrate auf 0.01 gestiegen:
	// 160 Tage im Durchschnitt und ca. 800 - 1000 Ueberlebende.

	// simulateNextDay() so veraendert, dass nur bei jedem zweiten ein Kontakt simuliert wird:
	// 200 Tage im Durchschnitt und 2000 Ueberlebende

public class Pandemic {

	/** Variable for the (initial) size of the population */
	static final int POPULATION_SIZE = 5000;

	/**
	 * Main method to start the simulation.
	 *
	 * @param args Command line arguments (not used).
	 */
	public static void main(String[] args) {
		// Erstelle eine Population
		Population p = new Population(POPULATION_SIZE);
				
		// Simulation
		// Starte mit Tag 0
		int day = 0;
		// Gib den aktuellen Tag, die Anzahl der Infizierten und die Anzahl der lebenden Individuen aus
		System.out.println("Tag "+day+": "+p.getIncidence()+" Faelle, Population: "+p.getCurrentSize());
		
		// Simuliere weitere Tage, solange es Infizierte und Lebendige gibt 
		while (p.getIncidence() > 0 && p.getCurrentSize() > 0) {
			// Naechsten Tag simulieren
			day++;
			p.simulateNextDay();	
			// Gib den aktuellen Tag, die Anzahl der Infizierten und die Anzahl der lebenden Individuen aus
			System.out.println("Tag "+day+": "+p.getIncidence()+" Faelle, Population: "+p.getCurrentSize());
		}
		
	}
}