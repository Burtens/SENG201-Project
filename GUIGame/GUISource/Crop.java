/**
 * Crops Abstract SuperClass
 * This class contains the necessary methods and variables to create crops on the farm
 */
public abstract class Crop {

    private double growth = 0;
    private double growthRate;
    private double value;
    private String seedImage;
    private String halfGrownImage;
    private String nearlyGrownImage;
    private String fullyGrownImage;

    public void setGrowthRate(double growthRate) {
        this.growthRate = growthRate;
    }

    public void setImages(String seedImage, String halfGrownImage, String nearlyGrownImage, String fullyGrownImage)
    {
        this.seedImage = seedImage;
        this.halfGrownImage = halfGrownImage;
        this.nearlyGrownImage = nearlyGrownImage;
        this.fullyGrownImage = fullyGrownImage;

    }

    public void setValue(double value) { this.value = value; }

    public double getGrowth() { return this.growth; }

    public double getGrowthRate() {return this.growthRate; }

    public double getValue() { return this.value; }


    /**
     * Takes an item stored as a string and updates values of crops based on item used
     */
    public void tend(String item)
        {
            switch (item)
            {
                case "Watering Can": updateGrowth();
                break;
                case "Growth Fertilizer": setGrowthRate(this.growthRate * 2);
                Bag.updateGFertilizerAmount(-1);
                break;
                case "Value Fertilizer": setValue(Math.round(this.value * 1.25));
                Bag.updateVFertilizerAmount(-1);
                break;
                case "Bonemeal": updateGrowth();
                setValue(Math.round(this.value * 1.10));
                Bag.updateBonemealAmount(-1);
                break;
                default: System.out.println("You are unable to use this item here!");
                break;
            }
        }

    public void updateGrowth() {
        this.growth += growthRate;
        if (this.growth > 100)
            this.growth = 100;

    }

    /**
     * Returns a string stating how many days till a crop is harvistable
     */
    public String daysTillHarvistable(){

        if (this.growth == 100)
            return "Crop is Ready";
        else{
            int totalDays = (int) Math.floor((100 - this.growth)/this.growthRate);
            if (totalDays <= 1)
                return "1 day";
            else
                return totalDays + " days";
        }
    }

    /**
     * Depending on the current Growth of a crop returns the file location of specific crop image
     */
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

    public String toString(){ return this.getClass().getSimpleName();}





}
