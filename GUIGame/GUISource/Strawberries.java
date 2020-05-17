public class Strawberries extends Crop{

    final double VALUE = 5.00;
    final int GROWTH = 10;

    public Strawberries(GUIFarm farm, int pos)
    {
        super(pos);
        super.setImages("GameResources/Seed Strawberry.png", "GameResources/Half Grown Strawberry.png",
                "GameResources/Nearly Grown Strawberry.png", "GameResources/Fully Grown Strawberry.png");
        FarmType currFarmType = farm.getFarmType();
        // TODO: Update bass growth rates to be unique
        super.setGrowthRate(GROWTH*currFarmType.getCropPercent());
        super.setValue(VALUE);
    }
}
