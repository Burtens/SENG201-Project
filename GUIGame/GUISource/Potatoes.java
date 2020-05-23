/**
 * Holds values for Potatoes crop. Cheep and rugged good all round crop.
 */
public class Potatoes extends Crop {

    final double VALUE = 30.00;
    final int GROWTH = 25;

    public Potatoes(Farm farm)
    {
        super.setImages("Seed Potato.png", "Half Grown Potato.png",
                "Nearly Grown Potato.png", "Fully Grown Potato.png");
        FarmType currFarmType = farm.getFarmType();
        super.setGrowthRate(GROWTH*currFarmType.getCropPercent());
        super.setValue(VALUE);
    }
}
