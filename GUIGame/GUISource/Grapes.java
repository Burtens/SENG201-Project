public class Grapes extends Crop{

    final double VALUE = 5.00;
    final int GROWTH = 10;

    public Grapes(GUIFarm farm, int pos)
    {
        super(pos);
        super.setImages("GameResources/Seed Grape.png", "GameResources/Half Grown Grape.png",
                "GameResources/Nearly Grown Grape.png", "GameResources/Fully Grown Grape.png");
        FarmType currFarmType = farm.getFarmType();
        // TODO: Update bass growth rates to be unique
        super.setGrowthRate(GROWTH*currFarmType.getCropPercent());
        super.setValue(VALUE);
    }
}