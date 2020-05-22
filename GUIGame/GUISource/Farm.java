/**
 * This is the main farm class for the GUI
 * this class holds all basic information about the farm
 *
 * Variables:
 * farmName : Name of the farm
 * farmerName : Name of the farmer
 * farmType : The farms selected farmtype, this is selected from the Enum FarmType
 * days : Total days on farm, this is how long the game will last
 * plots : An Array for holding the crops stored on the farm, this is initially set at 4
 * pens : An Array for holding the animals stored on the farm, this is initially set at 4
 * tended :
 *
 * Methods:
 * setFarmName : Takes a String "farmName" and sets the this.farmName to farmName
 * setFarmerName : Takes String "farmerName" and sets this.farmerName to farmerName
 * setDays : Takes an int "farmDays" and sets the amount of days on the farm to farmDays
 * setFarmType : Takes a FarmType "farmType" and sets the farm type of the farm to FarmType
 * getFarmType : Returns the farm type of this farm String
 * getFarmName : Returns the name of the farm as a String
 * getDays : Returns the amount of days on the farm as an int
 * getFarmerName : Returns the farmers name as a string
 * getPlots : Returns plots
 * getPens : Returns pens
 * setTended : Takes a boolean value and sets the state of tended
 * getTended : Returns the value of tended
 *
 * updatePlotSize : Increases the length of the plots Array, this then allows more crops to be planted on the farm
 * The maximum amount of plots that it allows is 12, it will also use up one of the users actions
 *
 * updatePenSize : Similar to updatePlotSize but instead updates the pens Array
 *
 * newAnimal :
 *
 * plantCrop : Takes a String "seed" (which specifies the type of crop to plant), an int "seedNum"
 * (the location of the seed stored in the bag) and an int "plotToPlant" (the specified location to store the crop in plots)
 * Using this data the method creates a crop and stores it in plots
 *
 * harvestCrop : Takes an int "plotNum" and removes the crop from plots. In doing so it also updates the total amount
 * of money that the farm has by that crops value. This also updated the amount of actions the user has by -1
 *
 * tendCrop : Takes an int "plotNum" and a String "item" and calls the tend method of the crop
 * stored in plots at index plotNum. This also updates the amount of actions the user has by -1
 * **/
public class Farm
{

    private String farmName;
    private String farmerName;
    private FarmType farmType;
    private int days;
    private Crop[] plots = new Crop[4];
    private Animals[] pens = new Animals[4];
    private boolean tended = false;



    /*Setters and Getters*/

    public void setFarmName(String farmName){ this.farmName = farmName; }

    public void setFarmerName(String farmerName) {this.farmerName = farmerName; }

    public void setDays(int farmDays) { this.days = farmDays; }

    public void setFarmType(FarmType farmType) {this.farmType = farmType; }

    public FarmType getFarmType(){ return this.farmType; }

    public int getDays() { return this.days; }

    public String getFarmName() { return this.farmName; }

    public String getFarmerName() {return this.farmerName; }

    public Crop[] getPlots() { return this.plots; }

    public Animals[] getPens() { return this.pens; }

    public void setTended(boolean state) { tended = state; }

    public boolean getTended() { return tended; }


    public void updatePlotSize()
    {
        /*Updates size of plots array (Increases amount of plots on farm)*/
        Status.updateActions(-1);
        int plotsSize = this.plots.length;
        int newPlotsSize;
        Crop[] newplots;
        if (Bag.hasHoe()){
            newPlotsSize = plotsSize + 3;
        }
        else
            newPlotsSize = plotsSize + 2;

        if (newPlotsSize > 12)
            newPlotsSize = 12;

        newplots = new Crop[newPlotsSize];

        System.arraycopy(this.plots, 0, newplots, 0, plotsSize);
        this.plots = newplots;
    }
    
    public void updatePenSize() {
        int penSize = this.pens.length;
        Animals[] newPens;
        int newPensSize = penSize + 1;
        if (Bag.hasHoe()) {
            newPensSize ++;
        }
        if (newPensSize > 12) {
            newPensSize = 12;
        }
        newPens = new Animals[newPensSize];
        System.arraycopy(this.pens, 0, newPens, 0, penSize);
        this.pens = newPens;
    }
    
    public boolean newAnimal(Animals animal) {
        boolean inPen = false;
        int numPens = this.pens.length;
        for (int i = 0; i < numPens; i++) {
            if (this.pens[i] == null) {
                this.pens[i] = animal;
                inPen = true;
                break;
            }
        }
        if (inPen) {
            return true;
        } else
            return false;
    }

    public void plantCrop(String seed, int seedNum, int plotToPlant) {
        /*Allows user to plant crops on farm*/

            /*Creates plant based on seed*/
        try {
            switch (seed) {
                case "Corn":
                    this.plots[plotToPlant] = new Corn(this);
                    break;
                case "Turnips":
                    this.plots[plotToPlant] = new Turnips(this);
                    break;
                case "Grapes":
                    this.plots[plotToPlant] = new Grapes(this);
                    break;
                case "Potatoes":
                    this.plots[plotToPlant] = new Potatoes(this);
                    break;
                case "Strawberries":
                    this.plots[plotToPlant] = new Strawberries(this);
                    break;
                case "Tomatoes":
                    this.plots[plotToPlant] = new Tomatoes(this);
                    break;
            }

            Bag.seeds.get(seedNum).updateAmount(-1);
            if (Bag.seeds.get(seedNum).getAmount() == 0)
                Bag.seeds.remove(seedNum);
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("This won't happen in game, error occurred due to invalid input during testing");
        }
    }

    public void harvestCrop(int plotNum)
    {
        Crop crop = this.plots[plotNum];
        Status.updateMoney(crop.getValue());
        Status.updateActions(-1);
        this.plots[plotNum] = null;
    }

    public void tendCrop(String item , int plotNum)
    {
        Crop crop = this.plots[plotNum];
        Status.updateActions(-1);
        crop.tend(item);
    }

}
