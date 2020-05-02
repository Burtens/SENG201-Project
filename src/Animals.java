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
        if (health > maxHealth) {
            health = maxHealth;
        }if (health < 0) {
            health = 0;
        }
    }

    public int getHappiness() {
        return happiness;
    }

    public void updateHappiness(int amount) {
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

    public void feed(Items item) {
        updateHappiness(20);
        updateHealth(40);
    }

    public void play(Items item) {
        updateHappiness(50);
    }
}
