import java.util.ArrayList;

public class GUIBag {

    private static int foodAmount = 0;
    private static int toyAmount = 0;
    private static int gFertilizerAmount = 0;
    private static int vFertilizerAmount = 0;

    public static ArrayList<Seeds> seeds = new ArrayList<>();

    private static boolean hasWateringCan = true;
    private static boolean hasHoe = false;

    public static void updateFoodAmount(int amount) {
        foodAmount += amount;
    }

    public static void updateToyAmount(int amount) {
        toyAmount += amount;
    }

    public static void updateGFertilizerAmount(int amount) {
        gFertilizerAmount += amount;
    }

    public static void updateVFertilizerAmount(int amount) {
        vFertilizerAmount += amount;
    }

    public static void updateSeeds(String type, int amount){
        boolean added = false;
        for (Seeds seed : seeds)
            if (seed.toString() == type){
                seed.updateAmount(amount);
                added = true;
            }
        if (!added)
            seeds.add(new Seeds(type, amount));
    }

    public static ArrayList getSeeds(){ return seeds; }

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

}

