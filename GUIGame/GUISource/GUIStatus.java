import java.text.Format;

public class GUIStatus {

    private static int day = 1;
    private static double money = 500;
    private static int actions = 2;


    public static int getActions() { return actions; }

    public static double getMoney() { return money; }

    public static int getDay() { return day; }

    public static void updateMoney(double amount) {
        money += amount;
    }

    public static void updateActions(int amount) {
        actions += amount;
        if (actions > 2) {
            actions = 2;
        }
        if (actions < 0) {
            actions = 0;
        }
    }

    public static void updateDay(GUIFarm farm) {
        for (Crop crop : farm.getPlots()) {
            if (crop != null)
                crop.updateGrowth();
        }
        for (GUIAnimals animal : farm.getPens()) {
            if (animal != null){
                updateMoney(animal.getValue());
                animal.updateHealth(-animal.getHealth() * 0.1);
                if (!farm.getTended()) {
                    animal.updateHappiness((int) (-15.0 / farm.getFarmType().getAnimalPercent()));
                }
            }

        }
        updateActions(2);
        day += 1;
    }

    public static void viewStatus(GUIFarm farm) {
        System.out.println("Your farm's name is: " + farm.getFarmName() +
                "\nYou have $" + getMoney() +
                "\nIt is the day " + getDay() + " out of " + farm.getDays() +
                "\n");
    }
}