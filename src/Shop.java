import java.util.Arrays;
import java.util.Scanner;

public class Shop {

    public static void chooseItem(Scanner scanner) {
        System.out.println("Items:\n" +
                "1: Food: $10, Animal feed, increases animal happiness and health.\n" +
                "2: Toy: $10, Animal toy, increases animal happiness.\n" +
                "3: Growth Fertilizer: $10, This fertilizer will double the growth rate of your crops.\n" +
                "4: Value Fertilizer: $10, This fertilizer will increase the value of your crops.\n" +
                "A: Buy animals.\n" +
                "S: Buy seeds.\n" +
                "B: View bag.\n" +
                "E: Exit.\n" +
                "\nYou have $" + Status.getMoney());
        String item = scanner.nextLine().trim().toLowerCase();
        while (!Arrays.asList("1", "2", "3", "4", "b", "e", "a", "s").contains(item)) {
            System.out.println("Wrong item, try again.");
            item = scanner.nextLine().trim().toLowerCase();
        }
        int amount = 0;
        int cost = 0;
        if (!Arrays.asList("b", "e", "a", "s").contains(item)) {
            try {
                System.out.println("Please enter the amount of items you wish to buy.\n" +
                        "Enter anything else to cancel.");
                amount = Integer.parseInt(scanner.nextLine());
                if (amount < 1) {
                    System.out.println("Stop being silly you can't buy less than 1.");
                    chooseItem(scanner); return;
                }
                cost = 10 * amount;
                if (cost > Status.getMoney()) {
                    System.out.println("Sorry you don't have enough money for that.\nAnything else?");
                    chooseItem(scanner); return;
                } else {
                    Status.updateMoney(-cost);
                    Bag.updateItems(item, amount);
                }
            }catch (IllegalArgumentException exception) {
                chooseItem(scanner);
                return;
            }
        }
        switch (item) {
            case ("1"):
                System.out.println("You purchased " + amount + " pieces of food for $" + cost +
                        "\nYou now have " + Bag.getFoodAmount() + " pieces of food\n" +
                        "Anything else?");
                chooseItem(scanner);
                break;
            case ("2"):
                System.out.println("You purchased " + amount + " toys for $" + cost +
                        "\nYou now have " + Bag.getToyAmount() + " toys\n" +
                        "Anything else?");
                chooseItem(scanner);
                break;
            case ("3"):
                System.out.println("You purchased " + amount + " bags of growth fertilizer for $" + cost +
                        "\nYou now have " + Bag.getGFertilizerAmount() + " bags of growth fertilizer\n" +
                        "Anything else?");
                chooseItem(scanner);
                break;
            case ("4"):
                System.out.println("You purchased " + amount + " bags of value fertilizer for $" + cost +
                        "\nYou now have " + Bag.getVFertilizerAmount() + " bags of growth fertilizer\n" +
                        "Anything else?");
                chooseItem(scanner);
                break;
            case ("a"):
                animalMenu(scanner);
                chooseItem(scanner);
                break;
            case ("s"):
                seedMenu(scanner);
                chooseItem(scanner);
                break;
            case ("b"):
                Bag.viewBag();
                chooseItem(scanner);
                break;
            case ("e"):
                System.out.println("Goodbye, come back soon!");
                break;
            default:
                System.out.println("Problem getting item amount");
        }
    }

    public static void animalMenu(Scanner scanner) {
        System.out.println("What animal are you looking at buying? we have:\n" +
                "1: Chickens\n" +
                "2: Sheep\n" +
                "3: Cows\n" +
                "4: Pigs\n" +
                "E: back to main store.\n" +
                "When you buy an animal well put it in an open pen for you.");
        String item = scanner.nextLine().trim().toLowerCase();
        while (!Arrays.asList("1", "2", "3", "4", "e").contains(item)) {
            System.out.println("Sorry, try something on the list.");
            item = scanner.nextLine().trim().toLowerCase();
        }
        switch (item) {
            case ("1"):
                Farm.newAnimal(new Chicken());
                System.out.println("Thanks for buying a chicken\n" +
                        "Anything else?");
                break;
            case ("2"):
                Farm.newAnimal(new Sheep());
                System.out.println("Thanks for buying a sheep\n" +
                        "Anything else?");
                break;
            case ("3"):
                Farm.newAnimal(new Cow());
                System.out.println("Thanks for buying a cow\n" +
                        "Anything else?");
                break;
            case ("4"):
                Farm.newAnimal(new Pig());
                System.out.println("Thanks for buying a pig\n" +
                        "Anything else?");
                break;
            case ("e"):
                System.out.println("Sorry we didn't have anything to your liking\n" +
                        "is there anything else you want?");
                break;
        }
    }

    public static void seedMenu(Scanner scanner) {
        System.out.println("What seeds are you looking to buy? We have:\n" +
                "1: Corn $10\n" +
                "2: Potatoes $10\n" +
                "3: Tomatoes $10\n" +
                "4: Lettuce $10\n" +
                "5: Carrots $10\n" +
                "6: Strawberries $10\n" +
                "E: Back to the main store");
        String item = scanner.nextLine().trim().toLowerCase();
        while (!Arrays.asList("1", "2", "3", "4", "5", "6", "e").contains(item)) {
            System.out.println("Sorry, try something on the list.");
            item = scanner.nextLine().trim().toLowerCase();
        }
        int amount = 0;
        int cost = 0;
        if (!item.equals("e")) {
            try {
                System.out.println("Please enter the amount of items you wish to buy.\n" +
                        "Enter anything else to cancel.");
                amount = Integer.parseInt(scanner.nextLine());
                if (amount < 1) {
                    System.out.println("Stop being silly you can't buy less than 1.");
                    chooseItem(scanner);
                    return;
                }
                cost = 10 * amount;
                if (cost > Status.getMoney()) {
                    System.out.println("Sorry you don't have enough money for that.\nAnything else?");
                    seedMenu(scanner);
                    return;
                } else {
                    Status.updateMoney(-cost);
                    Bag.updateItems("s" + item, amount);
                }
            } catch (IllegalArgumentException exception) {
                chooseItem(scanner);
                return;
            }
        }
        switch (item) {
            case ("1"):
                System.out.println("You purchased " + amount + " corn seeds for $" + cost +
                        "\nYou now have " + Bag.getCornSeeds() + " corn seeds\n" +
                        "Anything else?");
                break;
            case ("2"):
                System.out.println("You purchased " + amount + " potato seeds for $" + cost +
                        "\nYou now have " + Bag.getPotatoSeeds() + " potato seeds\n" +
                        "Anything else?");
                break;
            case ("3"):
                System.out.println("You purchased " + amount + " tomato seeds for $" + cost +
                        "\nYou now have " + Bag.getTomatoSeeds() + " tomato seeds\n" +
                        "Anything else?");
                break;
            case ("4"):
                System.out.println("You purchased " + amount + " lettuce seeds for $" + cost +
                        "\nYou now have " + Bag.getLettuceSeeds() + " lettuce seeds\n" +
                        "Anything else?");
                break;
            case ("5"):
                System.out.println("You purchased " + amount + " carrot seeds for $" + cost +
                        "\nYou now have " + Bag.getCarrotSeeds() + " carrot seeds\n" +
                        "Anything else?");
                break;
            case ("6"):
                System.out.println("You purchased " + amount + " strawberry seeds for $" + cost +
                        "\nYou now have " + Bag.getStrawberrySeeds() + " strawberry seeds\n" +
                        "Anything else?");
                break;
            case ("e"):
                System.out.println("Sorry we didn't have anything to your liking\n" +
                        "is there anything else you want?");
                break;
        }
    }
}