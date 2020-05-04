import java.util.ArrayList;

public class Bag {

    private static int foodAmount = 0;
    private static int toyAmount = 0;
    private static int gFertilizerAmount = 0;
    private static int vFertilizerAmount = 0;

    public static ArrayList<Seeds> seeds = new ArrayList<>();

    private static boolean hasWateringCan = true;
    private static boolean hasHoe = false;

    public static void updateItems(String newItem, int amount) {
        switch (newItem) {
            case("1"):
                foodAmount += amount;
                if (foodAmount < 0) {
                    foodAmount = 0;
                }
                break;
            case("2"):
                toyAmount += amount;
                if (toyAmount < 0) {
                    toyAmount = 0;
                }
                break;
            case("3"):
                gFertilizerAmount += amount;
                if (gFertilizerAmount < 0) {
                    gFertilizerAmount = 0;
                }
                break;
            case("4"):
                vFertilizerAmount += amount;
                if (vFertilizerAmount < 0) {
                    vFertilizerAmount = 0;
                }
                break;
            case("s1"):
                updateSeeds("Corn", amount);
                break;
            case("s2"):
                updateSeeds("Potatoes", amount);
                break;
            case("s3"):
                updateSeeds("Tomatoes", amount);
                break;
            case("s4"):
                updateSeeds("Lettuce", amount);
                break;
            case("s5"):
                updateSeeds("Carrots", amount);
                break;
            case("s6"):
                updateSeeds("Strawberries", amount);
                break;
            case("e"):
                break;
            default:
                throw new IllegalArgumentException("Incorrect item type given.");
        }
    }

    private static void updateSeeds(String type, int amount){
        boolean added = false;
        for (Seeds seed : seeds)
            if (seed.toString() == type){
                seed.updateAmount(amount);
                added = true;
            }
        if (!added)
            seeds.add(new Seeds(type, amount));
    }

    public static boolean hasHoe() {return hasHoe;}

    public static int getFoodAmount() {
        return foodAmount;
    }

    public static int getToyAmount() {
        return toyAmount;
    }

    public static int getGFertilizerAmount() {
        return gFertilizerAmount;
    }

    public static int getVFertilizerAmount() {
        return vFertilizerAmount;
    }

    public static void viewBag() {
        System.out.println("Your bag contains:");
        if (foodAmount > 0) {
            System.out.println("Food: " + foodAmount);
        } if (toyAmount > 0) {
            System.out.println("Toys: " + toyAmount);
        } if (gFertilizerAmount > 0) {
            System.out.println("Food: " + gFertilizerAmount);
        } if (vFertilizerAmount > 0) {
            System.out.println("Value fertilizer: " + vFertilizerAmount);
        }
        for (Seeds seed : seeds)
            System.out.println(seed.toString() + " seeds: " + seed.getAmount());
        System.out.println();
    }
}