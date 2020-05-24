/**
 * Holds values for Turnips crop. Description: Same growth rate as a potato but higher value and cost
 */
public class Turnips extends Crop {

    final double VALUE = 40.00;
    final int GROWTH = 25;

    public Turnips(Farm farm)
    {
        super.setImages("Seed Turnip.png", "Half Grown Turnip.png",
                "Nearly Grown Turnip.png", "Fully Grown Turnip.png");
        FarmType currFarmType = farm.getFarmType();
        super.setGrowthRate(GROWTH*currFarmType.getCropPercent());
        super.setValue(VALUE);

    }

}
