/**
 * This is the main farm class for the GUI
 * this class holds all basic information about the farm
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
        /*updates the size of the pens array (increases amount of pens on farm)*/
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
        /*Places new animal object into a pen
         and prevents to many animals from being created*/
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
