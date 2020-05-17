public class Tomatoes extends Crop {

    final double VALUE = 5.00;
    final int GROWTH = 10;

    public Tomatoes(GUIFarm farm, int pos)
    {
        super(pos);

        super.setImages("GameResources/Seed Tomato.png", "GameResources/Half Grown Tomato.png",
                "GameResources/Nearly Grown Tomato.png", "GameResources/Fully Grown Tomato.png");

        FarmType currFarmType = farm.getFarmType();
        // TODO: Update bass growth rates to be unique
        super.setGrowthRate(GROWTH*currFarmType.getCropPercent());
        super.setValue(VALUE);
    }
}