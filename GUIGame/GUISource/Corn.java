public class Corn extends Crop{

    final double VALUE = 5.00;
    final int GROWTH = 10;

    public Corn(GUIFarm farm, int pos)
    {
        super(pos);
        super.setImages("GameResources/Seed Corn.png", "GameResources/Half Grown Corn.png",
                "GameResources/Nearly Grown Corn.png", "GameResources/Fully Grown Corn.png");
        FarmType currFarmType = farm.getFarmType();
        // TODO: Update bass growth rates to be unique
        super.setGrowthRate(GROWTH*currFarmType.getCropPercent());
        super.setValue(VALUE);
    }
}
