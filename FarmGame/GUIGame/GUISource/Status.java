/***
 * Status
 * This class contains stores and updates player/farm stats
 **/


public class Status {

    private static int day = 1;
    private static double money = 500;
    private static int actions = 2;


    public static int getActions() { return actions; }

    public static double getMoney() { return money; }

    public static int getDay() { return day; }

    public static void updateMoney(double amount) {
        money += amount;
        if (money < 0) {
            money = 0;
        }
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

    public static void updateDay(Farm farm) {
        /*moves to the next day and update crop and animal stats*/
        for (Crop crop : farm.getPlots()) {
            if (crop != null)
                crop.updateGrowth();
        }
        for (Animals animal : farm.getPens()) {
            if (animal != null){
                updateMoney(animal.getValue());
                animal.updateHealth(-animal.getHealth() * 0.1);
                if (!farm.getTended()) {
                    animal.updateHappiness((int) (-15.0 / farm.getFarmType().getAnimalPercent()));
                }
            }
        }
        farm.setTended(false);
        updateActions(2);
        day += 1;
    }
}