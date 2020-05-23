/**
 * Holds values for Corn crop. Description: Corn Grows Fast but has low value
 */
public class Corn extends Crop{

    final double VALUE = 10.00;
    final int GROWTH = 50;

    public Corn(Farm farm)
    {
        super.setImages("Seed Corn.png", "Half Grown Corn.png",
                "Nearly Grown Corn.png", "Fully Grown Corn.png");
        FarmType currFarmType = farm.getFarmType();
        super.setGrowthRate(GROWTH*currFarmType.getCropPercent());
        super.setValue(VALUE);
    }
}
