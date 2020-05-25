import java.util.ArrayList;

/***
 * bag class
 * contains all the methods and variables for the storage of items
 **/

public class Bag {

    private static int foodAmount = 0;
    private static int toyAmount = 0;
    private static int gFertilizerAmount = 0;
    private static int vFertilizerAmount = 0;
    private static int bonemealAmount = 0;
    public static ArrayList<Seeds> seeds = new ArrayList<>();
    private static boolean containsHoe = false;


    /**
     * updates the amount of food in the bag,
     * prevents if from dropping below 0
     */
    public static void updateFoodAmount(int amount) {
        foodAmount += amount;
        if (foodAmount < 0)
            foodAmount = 0;
    }

    /**
     * updates the amount of toys in the bag,
     * prevents if from dropping below 0
     */
    public static void updateToyAmount(int amount) {
        toyAmount += amount;
        if (toyAmount < 0)
            toyAmount = 0;
    }

    /**
     * updates the amount of growth fertilizer in the bag,
     * prevents if from dropping below 0
     */
    public static void updateGFertilizerAmount(int amount) {
        gFertilizerAmount += amount;
        if (gFertilizerAmount < 0)
            gFertilizerAmount = 0;
    }

    /**
     * updates the amount of value fertilizer in the bag,
     * prevents if from dropping below 0
     */
    public static void updateVFertilizerAmount(int amount) {
        vFertilizerAmount += amount;
        if (vFertilizerAmount < 0)
            vFertilizerAmount = 0;
    }

    /**
     * updates the amount of bonemeal in the bag,
     * prevents if from dropping below 0
     */
    public static void updateBonemealAmount(int amount) {
        bonemealAmount += amount;
        if (bonemealAmount < 0)
            bonemealAmount = 0;
    }


    /**
     * sets hasHoe to true if hoe has been bought
     */
    public static void setHasHoe(Boolean status) {
        containsHoe = status;
    }

    /**
     * Adds Seeds objects to the ListArray seeds when item is bought from the store
     */
    public static void updateSeeds(String type, int amount){
        boolean added = false;
        for (Seeds seed : seeds)
            if (seed.toString().equals(type)){
                seed.updateAmount(amount);
                added = true;
            }
        if (!added)
            seeds.add(new Seeds(type, amount));
    }

    /*getters*/

    public static int getBonemealAmount() { return bonemealAmount; }

    public static ArrayList getSeeds(){ return seeds; }

    public static boolean hasHoe() {return containsHoe;}

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
}

