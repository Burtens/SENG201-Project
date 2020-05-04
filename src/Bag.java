public class Bag {

    private static int foodAmount = 0;
    private static int toyAmount = 0;
    private static int gFertilizerAmount = 0;
    private static int vFertilizerAmount = 0;
    private static int strawberrySeeds = 0;
    private static int carrotSeeds = 0;
    private static int lettuceSeeds = 0;
    private static int tomatoSeeds = 0;
    private static int potatoSeeds = 0;
    private static int cornSeeds = 0;


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
                cornSeeds += amount;
                if (cornSeeds < 0) {
                    cornSeeds = 0;
                }
                break;
            case("s2"):
                potatoSeeds += amount;
                if (potatoSeeds < 0) {
                    potatoSeeds = 0;
                }
                break;
            case("s3"):
                tomatoSeeds += amount;
                if (tomatoSeeds < 0) {
                    tomatoSeeds = 0;
                }
                break;
            case("s4"):
                lettuceSeeds += amount;
                if (lettuceSeeds < 0) {
                    lettuceSeeds = 0;
                }
                break;
            case("s5"):
                carrotSeeds += amount;
                if (carrotSeeds < 0) {
                    carrotSeeds = 0;
                }
                break;
            case("s6"):
                strawberrySeeds += amount;
                if (strawberrySeeds < 0) {
                    strawberrySeeds = 0;
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

    public static int getCornSeeds() {
        return cornSeeds;
    }

    public static int getCarrotSeeds() {
        return carrotSeeds;
    }

    public static int getLettuceSeeds() {
        return lettuceSeeds;
    }

    public static int getPotatoSeeds() {
        return potatoSeeds;
    }

    public static int getStrawberrySeeds() {
        return strawberrySeeds;
    }

    public static int getTomatoSeeds() {
        return tomatoSeeds;
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
        } if (cornSeeds > 0) {
            System.out.println("Corn seeds: " + cornSeeds);
        } if (potatoSeeds > 0) {
            System.out.println("Potato seeds: " + potatoSeeds);
        } if (tomatoSeeds > 0) {
            System.out.println("Tomato seeds: " + tomatoSeeds);
        } if (lettuceSeeds > 0) {
            System.out.println("Lettuce seeds: " + lettuceSeeds);
        } if (carrotSeeds > 0) {
            System.out.println("Carrot seeds: " + carrotSeeds);
        } if (strawberrySeeds > 0) {
            System.out.println("Strawberry seeds: " + strawberrySeeds);
        }
        System.out.println("");
    }
}