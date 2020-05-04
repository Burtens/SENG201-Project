import java.util.Arrays;
import java.util.Scanner;

public class Shop {

    public void chooseItem(Scanner scanner) {
        System.out.println("Please enter chosen item number.\n" +
                "Items:\n" +
                "1: Food: Animal feed, increases animal happiness and health.\n" +
                "2: Toy: Animal toy, increases animal happiness.\n" +
                "3: Growth Fertilizer: This fertilizer will double the growth rate of your crops.\n" +
                "4: Value Fertilizer: This fertilizer will increase the value of your crops.\n" +
                "b: View bag\n" +
                "e: Exit.");
        String item = scanner.nextLine();
        while (!Arrays.asList("1", "2", "3", "4", "b", "e").contains(item)) {
            System.out.println("Wrong item, try again.");
            item = scanner.nextLine();
        }
        try {
            if (!item.equals("b")) {
                System.out.println("Please enter the amount of items you wish to buy.\n" +
                        "Enter anything else to cancel.");
                int amount = Integer.parseInt(scanner.nextLine());
                Bag.updateItems(item, amount);
            }
        }
        catch (IllegalArgumentException exception) {
            chooseItem(scanner);
            return;
        }
        switch (item) {
            case ("1"):
                System.out.println("You have " + Bag.getFoodAmount() + " pieces of food");
                break;
            case ("2"):
                System.out.println("You have " + Bag.getToyAmount() + " toys");
                break;
            case ("3"):
                System.out.println("You have " + Bag.getGFertilizerAmount() + " bags of growth fertilizer");
                break;
            case ("4"):
                System.out.println("You have " + Bag.getVFertilizerAmount() + " bags of growth fertilizer");
                break;
            case ("b"):
                Bag.viewBag();
                break;
            case ("e"):
                break;
            default:
                System.out.println("Problem getting item amount");
        }
    }
}