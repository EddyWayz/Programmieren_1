/**
 * Class representing an individual in the population.
 * An individual can be infected, recover, or die.
 *
 * @author Eduard Wayz (193123)
 * @version 1.0
 */
public class Individual {

    /** Whether the individual is alive. */
    private boolean alive;

    /** Whether the individual is infected. */
    private boolean infected;

    /** The remaining days the individual will be infectious. */
    private int remainingDaysOfInfection;


    /**
     * Constructor to create an individual with a specified infection status.
     *
     * @param infected True if the individual starts infected, false otherwise.
     */
    public Individual(boolean infected){
        alive = true;
        if(!infected) {
            infected = false;
        } else {
            setInfected();
        }
        }


    /**
     * Checks if the individual is alive.
     *
     * @return True if the individual is alive, false otherwise.
     */
    public boolean isAlive() {
        return alive;
    }


    /**
     * Checks if the individual is infected.
     *
     * @return True if the individual is infected, false otherwise.
     */
    public boolean isInfected() {
        return infected;
    }

    /**
     * Sets the individual to be infected and assigns a random infection duration between 5 and 9 days.
     */
    public void setInfected(){
         infected = true;
         remainingDaysOfInfection = (int) (Math.random() * 5) + 5;
    }

    /**
     * Updates the status of the individual based on the mortality rate.
     * The individual may die or recover depending on the infection duration.
     *
     * @param mortality The probability that the individual dies if infected.
     */
    public void updateStatus(double mortality){
        if (Math.random() < mortality){
            alive = false;
        } else {
            if (remainingDaysOfInfection > 0){
                remainingDaysOfInfection--;
            }else {
                remainingDaysOfInfection = 0;
                infected = false;
            }

        }
    }
}
