/**
 * Holds values for Tomatoes crop. Description: High growth and high value but comes with a cost
 */
public class Tomatoes extends Crop {

    final double VALUE = 40.00;
    final int GROWTH = 40;

    public Tomatoes(Farm farm)
    {
        super.setImages("GameResources/Seed Tomato.png", "GameResources/Half Grown Tomato.png",
                "GameResources/Nearly Grown Tomato.png", "GameResources/Fully Grown Tomato.png");
        FarmType currFarmType = farm.getFarmType();
        super.setGrowthRate(GROWTH*currFarmType.getCropPercent());
        super.setValue(VALUE);
    }
}
