public class Status {

    private static int day = 1;
    private static double money = 0.00;
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

    public static String getInfo() { return "Today is day " + day + " on the farm.\nYour farm has $" +  String.format("%.2f", money) + " available.";}
}
