/**
 * Holds values for Grape crop. Description: Slow Growing but with a high value.
 */
public class Grapes extends Crop{

    final double VALUE = 100.00;
    final int GROWTH = 10;

    public Grapes(Farm farm)
    {
        super.setImages("Seed Grape.png", "Half Grown Grape.png",
                "Nearly Grown Grape.png", "Fully Grown Grape.png");
        FarmType currFarmType = farm.getFarmType();
        super.setGrowthRate(GROWTH*currFarmType.getCropPercent());
        super.setValue(VALUE);
    }
}
