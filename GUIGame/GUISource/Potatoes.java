/**
 * Holds values for Potatoes crop. Cheep and rugged good all round crop.
 */
public class Potatoes extends Crop {

    final double VALUE = 30.00;
    final int GROWTH = 25;

    public Potatoes(Farm farm)
    {
        super.setImages("GameResources/Seed Potato.png", "GameResources/Half Grown Potato.png",
                "GameResources/Nearly Grown Potato.png", "GameResources/Fully Grown Potato.png");
        FarmType currFarmType = farm.getFarmType();
        super.setGrowthRate(GROWTH*currFarmType.getCropPercent());
        super.setValue(VALUE);
    }
}
