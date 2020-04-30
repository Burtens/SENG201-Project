public class Status {

    private static int day = 0;
    private static double money = 0;
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

    public static void updateDay() {
        day += 1;
    }

    public static int getDay() {
        return day;
    }
}
