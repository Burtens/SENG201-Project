/**
 * Corn Grows Fast but has low value
 *
 */
public class Corn extends Crop{

    final double VALUE = 10.00;
    final int GROWTH = 50;

    public Corn(GUIFarm farm)
    {

        super.setImages("GameResources/Seed Corn.png", "GameResources/Half Grown Corn.png",
                "GameResources/Nearly Grown Corn.png", "GameResources/Fully Grown Corn.png");
        FarmType currFarmType = farm.getFarmType();
        super.setGrowthRate(GROWTH*currFarmType.getCropPercent());
        super.setValue(VALUE);
    }
}
