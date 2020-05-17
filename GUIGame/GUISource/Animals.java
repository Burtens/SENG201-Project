import java.util.Arrays;
import java.util.Scanner;

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

    public static int getHealth() {
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

    public static int getHappiness() {
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
        GUIStatus.updateActions(-1);
    }

    public static void play() {
        updateHappiness(50);
        GUIStatus.updateActions(-1);
    }

    public static void animalMenu(Scanner scanner, int pen, GUIFarm farm) {
        System.out.println("Please select an action:\n" +
                "1: View animal stats.\n" +
                "2: Feed animal.\n" +
                "3: Play with animal.\n" +
                "E: Exit menu.");
        String item = scanner.nextLine().trim().toLowerCase();
        while (!Arrays.asList("1", "2", "3", "e").contains(item)) {
            System.out.println("Wrong item, try again.");
            item = scanner.nextLine().trim().toLowerCase();
        }
        switch (item) {
            case ("1"):
                System.out.println(farm.getPens()[pen].getClass().getSimpleName() +
                        "\nHappiness: " + getHappiness() +
                        "\nHealth: " + getHealth());
                animalMenu(scanner, pen, farm);
                break;
            case ("2"):
                if (GUIBag.getFoodAmount() > 0) {
                    feed();
                } else {
                    System.out.println("Sorry not enough food.");
                }
                animalMenu(scanner, pen, farm);
                break;
            case ("3"):
                if (GUIBag.getToyAmount() > 0) {
                    play();
                } else {
                    System.out.println("Sorry not enough toys.");
                }
                animalMenu(scanner, pen, farm);
                break;
            case ("e"):
                break;
        }
    }

    public static void chooseAnimal(Scanner scanner, GUIFarm farm) {
        System.out.println("Choose pen between 1 and " + farm.getPens().length +
                "\nOr enter E to go back");
        String item = scanner.nextLine().trim().toLowerCase();
        if (item == "e") {
            return;
        } else {
            try{
                int pen = Integer.parseInt(item) - 1;
                farm.getPens()[pen].animalMenu(scanner, pen, farm);
            } catch (NumberFormatException exception) {
                System.out.println("Sorry invalid number.");
            } catch (ArrayIndexOutOfBoundsException exception) {
                System.out.println("Sorry no such pen exists.");
            }
        }
    }
}
