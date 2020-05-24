import static java.lang.Math.round;

/***
 * Animals abstract superclass
 * this class contains all the methods and variables for the animals
 **/

public abstract class Animals {

    private double maxHealth;
    private double health;
    private double happiness = 100;
    private int value;

    public Animals(int animalValue, int maxHp) {
        value = animalValue;
        maxHealth = maxHp;
        health = maxHp;
    }

    /* getters */

    public int getHealth() {
        return (int) health;
    }

    public int getHappiness() {
        return (int) happiness;
    }

    public int getValue() {
        /* returns current value buy adjusting value using the value of health and happiness. */
        double currentValue = round((value / 2) * (health / maxHealth) + value / 2);
        currentValue = round((currentValue / 2) * (happiness / 100) + currentValue / 2);
        return (int) currentValue;
    }

    public int getMaxValue() {
        return value;
    }

    /* variable updaters */

    public void updateHealth(double amount) {
        health += amount;
        if (health > maxHealth) {
            health = maxHealth;
        }if (health < 0) {
            health = 0;
        }
    }

    public void updateHappiness(int amount) {
        happiness += amount;
        if (happiness > 100) {
            happiness = 100;
        }if (happiness < 0) {
            happiness = 0;
        }
    }

    public void feed() {
        /* feeds the animal increasing health and happiness at the cost of 1 action and 1 piece of food,
         food is decreased by the feed button of the animal screen.
         */
        updateHappiness(20);
        updateHealth(40);
        Status.updateActions(-1);
    }

    public void play() {
        /* plays with the animal increasing happiness at the cost of 1 action and 1 toy,
         toy amount is decreased by the toy button of the animal screen.
         */
        updateHappiness(50);
        Status.updateActions(-1);
    }
}
