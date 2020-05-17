public abstract class Crop {

    private int growth = 0;
    private int plotPos;
    /*Public for testing purposes*/
    public int growthRate;
    private double value;
    private String seedImage;
    private String halfGrownImage;
    private String nearlyGrownImage;
    private String fullyGrownImage;



    Crop(int pos){
        this.plotPos = pos;
    }

    public void setGrowthRate(double growthRate) {
        this.growthRate = (int) growthRate;
    }

    public void setImages(String seedImage, String halfGrownImage, String nearlyGrownImage, String fullyGrownImage)
    {
        this.seedImage = seedImage;
        this.halfGrownImage = halfGrownImage;
        this.nearlyGrownImage = nearlyGrownImage;
        this.fullyGrownImage = fullyGrownImage;

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

    public String getCurrImage()
    {
        if (this.growth < 33){
            return this.seedImage;
        }
        else if (this.growth > 66 && this.growth < 100){
            return this.nearlyGrownImage;
        }
        else if (this.growth >= 100){
            return this.fullyGrownImage;
        }
        else{
            return this.halfGrownImage;
        }
    }

    public int getPlotPos() { return this.plotPos; }

    public int getGrowthRate() {return  this.growthRate; }

    public double getValue() { return this.value; }

    public String toString(){ return this.getClass().getSimpleName();}





}
