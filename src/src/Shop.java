import java.util.Arrays;
import java.util.Scanner;

public class Shop {

    public static void chooseItem(Scanner scanner) {
        System.out.println("Items:\n" +
                "1: Food: $10, Animal feed, increases animal happiness and health.\n" +
                "2: Toy: $10, Animal toy, increases animal happiness.\n" +
                "3: Growth Fertilizer: $10, This fertilizer will double the growth rate of your crops.\n" +
                "4: Value Fertilizer: $10, This fertilizer will increase the value of your crops.\n" +
                "b: View bag\n" +
                "e: Exit.\n" +
                "\nYou have $" + Status.getMoney());
        String item = scanner.nextLine();
        while (!Arrays.asList("1", "2", "3", "4", "b", "e").contains(item)) {
            System.out.println("Wrong item, try again.");
            item = scanner.nextLine();
        }
        int amount = 0;
        int cost = 0;
        if (!Arrays.asList("b", "e").contains(item)) {
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
            case ("b"):
                Bag.viewBag();
                chooseItem(scanner);
                break;
            case ("e"):
                break;
            default:
                System.out.println("Problem getting item amount");
        }
    }
}