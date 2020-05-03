import java.util.Arrays;
import java.util.Scanner;

public class Shop {

    public void chooseItem(Scanner scanner) {
        System.out.println("Please enter chosen item number.\n" +
                "Items:\n" + "1: Food\n" + "2: Toy\n" + "3: Growth Fertilizer\n" + "4: Value Fertilizer\n" + "e: Exit");
        String item = scanner.nextLine();
        while (!Arrays.asList("1", "2", "3", "4", "e").contains(item)) {
            System.out.println("Wrong item, try again.");
            item = scanner.nextLine();
        }
        int amount = 0;
        try {
            amount = Integer.parseInt(scanner.nextLine());
        } catch (IllegalArgumentException exception) {
            chooseItem();
            return;
        }
        Bag.updateItems(item, amount);
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
            case ("e"):
                break;
            default:
                System.out.println("Problem getting item amount");
        }
    }
}
