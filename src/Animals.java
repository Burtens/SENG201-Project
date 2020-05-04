import Items.Items;

import static java.lang.Math.round;

public abstract class Animals {

    private static double maxHealth;
    private static double health;
    private static int happiness = 100;
    private int value;

    public Animals(int animalValue, int maxHp) {
        value = animalValue;
        maxHealth = maxHp;
        health = maxHp;
    }

    public int getHealth() {
        return (int) health;
    }

    public static void updateHealth(double amount) {
        health += amount;
        if (health > maxHealth) {
            health = maxHealth;
        }if (health < 0) {
            health = 0;
        }
    }

    public int getHappiness() {
        return happiness;
    }

    public static void updateHappiness(int amount) {
        happiness += amount;
        if (happiness > 100) {
            happiness = 100;
        }if (happiness < 0) {
            happiness = 0;
        }
    }

    public int getValue() {
        double currentValue = round((value / 2) * (health / maxHealth) + value / 2);
        return (int) currentValue;
    }

    public static void feed() {
        updateHappiness(20);
        updateHealth(40);
    }

    public void play(Items item) {
        updateHappiness(50);
    }

    public String toString(){ return this.getClass().getSimpleName();}
}
