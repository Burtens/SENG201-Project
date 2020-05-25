/**
 * This is the main farm class for the GUI
 * this class holds all basic information about the farm
 * and methods to allow the user to preform actions on the farm
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


    /**
     * Updates size of plots array (Increases amount of plots on farm)
     */
    public void updatePlotSize()
    {
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

    /**
     * updates the size of the pens array (increases amount of pens on farm)
     */
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


    /**
     * Places new animal object into a pen and prevents to many animals from being created
     * @param animal chosen animal selected from shop screen
     * @return returns a boolean depending on weather or not the animal was
     * successfully added to a pen
     */
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


    /**
     * Allows user to plant crops on farm, creates new seed and then adds that Crop object to the
     * Array plots
     * @param seed String of the seed to be planted
     * @param seedNum Location of seed in Bag.seeds a ListArray of Seeds
     * @param plotToPlant Location in Array plots to store Crop object
     */
    public void plantCrop(String seed, int seedNum, int plotToPlant) {
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

    /**
     * Takes a specific crop  and calls the harvest method of that crop
     * decreases the amount of actions left by one
     * @param plotNum Location of Crop in Array plots
     */
    public void harvestCrop(int plotNum)
    {
        Crop crop = this.plots[plotNum];
        Status.updateMoney(crop.getValue());
        Status.updateActions(-1);
        this.plots[plotNum] = null;
    }

    /**
     * Takes a crop stored in Array plots at location plotNum and calls the tend method of that crop
     * with the chosen item, decreases the amount of actions left by one
     * @param item String representing the item to be used on crop
     * @param plotNum Location of Crop in Array plots
     */
    public void tendCrop(String item , int plotNum)
    {
        Crop crop = this.plots[plotNum];
        Status.updateActions(-1);
        crop.tend(item);
    }

}
