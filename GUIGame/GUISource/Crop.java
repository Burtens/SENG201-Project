/**
 * Crops Abstract SuperClass
 * This class contains the necessary methods and variables to create crops on the farm
 *
 * Variables:
 * growth : crops total growth
 * growthRate : the current growth-rate of the crop, this is effected by the specific crop
 * value : the current value of the crop, is added to the farms money on harvest
 * seedImage : file path of the crops specific seed image
 * halfGrownImage : file path of the crops specific half grown image
 * nearlyGrownImage : file path of the crops specific nearly grown image
 * fullyGrownImage : file path of the crops specific fully grown image
 *
 * Methods:
 * setGrowthRate : Sets growth rate of crop from selected crop subtype
 * setImages : Sets all specific images from selected crop subtype
 * setValue : Sets value of crop from selected crop subtype
 * getGrowth : Returns value of growth
 * getGrowthRate : Returns value of growthRate
 * getValue : Returns crop's value
 *
 * tend : Takes a string "tool" and updates values of crop relating to which tool was used
 * if "Watering Can" the updateGrowth method is called
 * if "growth" relating to growth fertilizer the current growth rate of the crop is doubled
 * if "value" relating to value fertilizer the current value of the crop is increased 25%
 *
 * updateGrowth : Adds current growthRate to growth if current growth is less than 100%
 * daysTillHarvistable : Returns the amount of days till crop is ready to be harvested
 * getCurrImage : Returns the current image file string based on the current growth of the crop
 * toString : Returns a string representation of this crop
 *
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

    public void tend(String item)
        {
            if (item.equals("Watering Can"))
                updateGrowth();
            else
            {
                switch (item)
                {
                    case "growth": setGrowthRate(this.growthRate * 2);
                    break;
                    case "value": setValue(this.value * 1.25);
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
