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

    /**
     * updates money prevents it going below 0
     * @param amount a double representing amount of money to be added
     */
    public static void updateMoney(double amount) {
        money += amount;
        if (money < 0) {
            money = 0;
        }
    }

    /**
     * updates actions prevents them going above 2 or below 0
     * @param amount an int representing the amount of actions added
     */
    public static void updateActions(int amount) {
        actions += amount;
        if (actions > 2) {
            actions = 2;
        }
        if (actions < 0) {
            actions = 0;
        }
    }

    /**
     * moves to the next day and update crop and animal stats
     * @param farm object Farm used in game
     */
    public static void updateDay(Farm farm) {
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