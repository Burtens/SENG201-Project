public class Tomatoes extends Crop {

    final double VALUE = 5.00;
    final int GROWTH = 10;

    public Tomatoes(Farm farm)
    {

        FarmType currFarmType = farm.getFarmType();
        // TODO: Update bass growth rates to be unique
        super.setGrowthRate(GROWTH*currFarmType.getCropPercent());
        super.setValue(VALUE);
    }

    public void plant() { super.plant(); }

    public void harvest() { super.harvest(); }

    public void tend(Item item) { super.tend(item); }


}
