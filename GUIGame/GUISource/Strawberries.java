/**
 * Holds values for Strawberries crop. Description: Grows slower than most crops but value a lot higher
 */
public class Strawberries extends Crop{

    final double VALUE = 80.00;
    final int GROWTH = 20;

    public Strawberries(Farm farm)
    {
        super.setImages("Seed Strawberry.png", "Half Grown Strawberry.png",
                "Nearly Grown Strawberry.png", "Fully Grown Strawberry.png");
        FarmType currFarmType = farm.getFarmType();
        super.setGrowthRate(GROWTH*currFarmType.getCropPercent());
        super.setValue(VALUE);
    }
}
