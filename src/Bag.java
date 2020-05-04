public class Bag {

    private static int foodAmount = 0;
    private static int toyAmount = 0;
    private static int gFertilizerAmount = 0;
    private static int vFertilizerAmount = 0;


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
            case("e"):
                break;
            default:
                throw new IllegalArgumentException("Incorrect item type given.");
        }
    }

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
        if (foodAmount > 0) {
            System.out.println("Food: " + foodAmount);
        } if (toyAmount > 0) {
            System.out.println("Toys: " + toyAmount);
        } if (gFertilizerAmount > 0) {
            System.out.println("Food: " + gFertilizerAmount);
        } if (vFertilizerAmount > 0) {
            System.out.println("Value fertilizer: " + vFertilizerAmount);
        }
    }
}