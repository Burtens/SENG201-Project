public abstract class Crop {

    private int growth = 0;
    /*Public for testing purposes*/
    public int growthRate;
    private double value;
    // TODO: Not sure about this implementation yet
    private int amount;


    public void setGrowthRate(double growthRate) {
        this.growthRate = (int) growthRate;
    }

    public void setValue(double value) { this.value = value; }

    public int getGrowth() { return this.growth; }

    public void plant()
        {
            // TODO: When Plots class is implemented
        }

    public void tend(Item item)
        {
            if (item.getType() == "Watering Can")
                // TODO: Not to sure what to do here but will look into later when items have been implemented
                updateGrowth();
            else
            {
                /*Do something base on item*/
            }
        }

    public void updateGrowth() {this.growth += growthRate;}

    public void harvest()
    {
        if (this.growth == 100)
            // TODO: Once Plots class is implemented add here
            Status.updateMoney(this.value);
        else
            System.out.println("Sorry these crops are not ready!!!");
    }




}
