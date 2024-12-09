/**
 * Class representing a population of individuals.
 *
 * @author Eduard Wayz (193123)
 * @version 1.0
 */
public class Population {

    /** Initial size of the population. */
    private int startSize;

    /** The initial infection rate (probability that an individual starts infected). */
    public final double INITIAL_INFECTION_RATE = 0.001;

    /** The infection risk during a contact. */
    public final double INFECTION_RISK = 0.2;

    /** The mortality rate (probability that an infected individual dies). */
    public final double MORALITY = 0.004;

    /** Array of individuals representing the population. */
    Individual[] individuals;


    /**
     * Constructor to create a population with a given size.
     * A portion of the individuals are initially infected based on the infection rate.
     *
     * @param startSize The initial size of the population.
     */
    public Population(int startSize) {
        this.startSize = startSize;
        individuals = new Individual[startSize];
        for (int i = 0; i < individuals.length; i++) {
            if (Math.random() <= INITIAL_INFECTION_RATE) {
                individuals[i] = new Individual(true);
            } else {
                individuals[i] = new Individual(false);
            }
        }
    }

    /**
     * Getter method for the initial population size.
     *
     * @return The initial size of the population.
     */
    public int getStartSize() {
        return startSize;
    }

    /**
     * Gets the current number of living individuals in the population.
     *
     * @return The number of living individuals.
     */
    public int getCurrentSize() {
        int counter = 0;
        for (Individual individual : individuals) {
            if (individual.isAlive()) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Gets the number of currently infected and living individuals.
     *
     * @return The number of infected and living individuals.
     */
    public int getIncidence() {
        int counter = 0;
        for (Individual individual : individuals) {
            if (individual.isInfected() && individual.isAlive()) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Simulates the events of the next day:
     * - Each individual contacts one random individual.
     * - The status of each individual is updated based on mortality.
     */
    public void simulateNextDay() {
        for (Individual individual : individuals) {
            simulateContact(individual, individuals[(int)(Math.random()*startSize)]);
            individual.updateStatus(MORALITY);
            }
    }

    /**
     * Simulates a contact between two individuals. If one is infected and the other is not,
     * there is a chance of infection based on the infection risk.
     *
     * @param a The first individual in the contact.
     * @param b The second individual in the contact.
     */
    public void simulateContact(Individual a, Individual b) {
        if((a.isAlive() && b.isAlive()) && (a.isInfected() ^ b.isInfected())) {
            if(Math.random() <= INFECTION_RISK) {
                if (a.isInfected()){
                    b.setInfected();
                } else {
                    a.setInfected();
                }

            }
        }
    }
}

