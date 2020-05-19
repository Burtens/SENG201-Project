import static java.lang.Math.round;

/***
 * Animals abstract superclass
 * this class contains all the methods and variables for the animals
 *
 * variables:
 * maxHealth: int, stores max health for the animal type
 * health: int, stores current health of the animal
 * happiness: int, stores current happiness of the animal
 * value: int, stores max value of the animal
 *
 * methods:
 * GUIAnimals: assigns initial value of variables
 * getHealth: returns the int current health value
 * updateHealth: adjust health buy the given amount
 * getHappiness: returns the int current happiness value
 * updateHappiness: updates current happiness by the given value
 * getValue: returns the value of the animal based on value health and happiness
 * feed: increases health and happiness of the animal. costs 1 actions
 * play: increases happiness of the animal. cost 1 action
 */

public abstract class GUIAnimals {

    private double maxHealth;
    private double health;
    private int happiness = 100;
    private int value;

    public GUIAnimals(int animalValue, int maxHp) {
        value = animalValue;
        maxHealth = maxHp;
        health = maxHp;
    }

    /* getters */

    public int getHealth() {
        return (int) health;
    }

    public int getHappiness() {
        return happiness;
    }

    public int getValue() {
        /* returns current value buy adjusting value using the value of health and happiness. */
        double currentValue = round((value / 2) * (health / maxHealth) + value / 2);
        currentValue = round((currentValue / 2) * (happiness / 100) + currentValue / 2);
        return (int) currentValue;
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
        GUIStatus.updateActions(-1);
    }

    public void play() {
        /* plays with the animal increasing happiness at the cost of 1 action and 1 toy,
         toy amount is decreased by the toy button of the animal screen.
         */
        updateHappiness(50);
        GUIStatus.updateActions(-1);
    }
}
