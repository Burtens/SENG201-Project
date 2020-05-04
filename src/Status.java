public class Status {

    private static int day = 1;
    private static double money = 500;
    private static int actions = 2;


    public static void updateMoney(double amount) {
        money += amount;
    }

    public static double getMoney() {
        return money;
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

    public static int getActions() {
        return actions;
    }

    public static void updateDay(Farm farm) {
        for (Crop crop : farm.plots) {
            if (crop != null)
                crop.updateGrowth();
        }
        for (Animals animal : farm.pens) {
            if (animal != null){
                updateMoney(animal.getValue());
                // TODO: Update Happiness and health??
            }

        }
        updateActions(2);
        day += 1;
    }

    public static int getDay() {
        return day;
    }


    public static void viewStatus() {
        System.out.println("Status\nYour name is:" + Main.getFarmerName() +
                "\nYour farm's name is: " + Farm.getFarmName() +
                "\nYou have $" + getMoney() +
                "\nIt is the day " + getDay() + " out of " + Farm.getDays() +
                "\n");
    }
}
