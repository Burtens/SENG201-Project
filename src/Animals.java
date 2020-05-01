import static java.lang.Math.round;

public abstract class Animals {

    private double maxHealth;
    private double health;
    private int happiness = 100;
    private int value;

    public Animals(int animalValue, int maxHp) {
        value = animalValue;
        maxHealth = maxHp;
        health = maxHp;
    }

    public int getHealth() {
        return (int) health;
    }

    public void updateHealth(double amount) {
        health += amount;
    }

    public int getHappiness() {
        return happiness;
    }

    public void updateHappiness(int amount) {
        happiness += amount;
    }

    public int getValue() {
        double currentValue = round((value / 2) * (health / maxHealth) + value / 2);
        return (int) currentValue;
    }

    public void feed() {
        /* based on food item */
    }

    public void play() {
        happiness += 0;
        /* use item */
    }
}
