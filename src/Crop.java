import Items.Items;

public abstract class Crop {

    private int growth = 0;
    /*Public for testing purposes*/
    public int growthRate;
    private double value;


    public void setGrowthRate(double growthRate) {
        this.growthRate = (int) growthRate;
    }

    public void setValue(double value) { this.value = value; }

    public int getGrowth() { return this.growth; }

    public void tend(Items item)
        {
            if (item.getType() == "Watering Can")
                updateGrowth();
            else
            {
                String itemType = item.getType();
                switch (itemType)
                {
                    case "growth": setGrowthRate(this.growthRate * 2);
                    break;
                    case "value": setValue(this.value + 1.00);
                    break;
                    default: System.out.println("You are unable to use this item here!");
                    break;
                }
            }
        }

    public void updateGrowth() {
        this.growth += growthRate;
        if (this.growth > 100)
            this.growth = 100;

    }

    public double getValue() { return this.value; }

    public String toString(){ return this.getClass().getSimpleName();}





}
