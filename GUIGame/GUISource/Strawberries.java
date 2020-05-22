/**
 * Holds values for Strawberries crop. Description: Grows slower than most crops but value a lot higher
 */
public class Strawberries extends Crop{

    final double VALUE = 80.00;
    final int GROWTH = 20;

    public Strawberries(Farm farm)
    {
        super.setImages("GameResources/Seed Strawberry.png", "GameResources/Half Grown Strawberry.png",
                "GameResources/Nearly Grown Strawberry.png", "GameResources/Fully Grown Strawberry.png");
        FarmType currFarmType = farm.getFarmType();
        super.setGrowthRate(GROWTH*currFarmType.getCropPercent());
        super.setValue(VALUE);
    }
}
