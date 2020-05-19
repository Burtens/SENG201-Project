/**
 *
 */
public class Turnips extends Crop {

    final double VALUE = 40.00;
    final int GROWTH = 25;

    public Turnips(Farm farm)
    {
        super.setImages("GameResources/Seed Turnip.png", "GameResources/Half Grown Turnip.png",
                "GameResources/Nearly Grown Turnip.png", "GameResources/Fully Grown Turnip.png");
        FarmType currFarmType = farm.getFarmType();
        super.setGrowthRate(GROWTH*currFarmType.getCropPercent());
        super.setValue(VALUE);

    }
}
