public class Turnips extends Crop {

    final double VALUE = 40.00;
    final int GROWTH = 25;

    public Turnips(GUIFarm farm, int pos)
    {
        super(pos);
        super.setImages("GameResources/Seed Turnip.png", "GameResources/Half Grown Turnip.png",
                "GameResources/Nearly Grown Turnip.png", "GameResources/Fully Grown Turnip.png");
        FarmType currFarmType = farm.getFarmType();
        // TODO: Update bass growth rates to be unique
        super.setGrowthRate(GROWTH*currFarmType.getCropPercent());
        super.setValue(VALUE);

    }
}
