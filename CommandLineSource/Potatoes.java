public class Potatoes extends Crop {

    final double VALUE = 5.00;
    final int GROWTH = 10;

    public Potatoes(Farm farm, int pos)
    {
        super(pos);
        FarmType currFarmType = farm.getFarmType();
        // TODO: Update bass growth rates to be unique
        super.setGrowthRate(GROWTH*currFarmType.getCropPercent());
        super.setValue(VALUE);
    }
}
