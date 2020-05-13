import Items.Items;

public abstract class Crop {

    private int growth = 0;
    private int plotPos;
    /*Public for testing purposes*/
    public int growthRate;
    private double value;

    Crop(int pos){
        this.plotPos = pos;
    }

    public void setGrowthRate(double growthRate) {
        this.growthRate = (int) growthRate;
    }

    public void setValue(double value) { this.value = value; }

    public int getGrowth() { return this.growth; }

    public void tend(String item)
        {
            if (item == "wateringCan")
                updateGrowth();
            else
            {
                switch (item)
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

    public int getPlotPos() { return this.plotPos; }

    public double getValue() { return this.value; }

    public String toString(){ return this.getClass().getSimpleName();}





}
