/**
 * This is the main farm class for the GUI
 * this class holds all basic information about the farm
 *
 * The Setup Screen will provide the starting values for all information stored in this class.
 *
 *
 * **/
public class GUIFarm
{

    private String farmName;
    private String farmerName;
    private FarmType farmType;
    private int days;
    private   Crop[] plots = new Crop[4];
    private  GUIAnimals[] pens = new GUIAnimals[4];



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

    public GUIAnimals[] getPens() { return this.pens; }


    public void updatePlotSize()
    {
        /*Updates size of plots array (Increases amount of plots on farm)*/
        GUIStatus.updateActions(-1);
        int plotsSize = this.plots.length;
        int newPlotsSize;
        Crop[] newplots;
        if (GUIBag.hasHoe() == true){
            newPlotsSize = plotsSize + 3;
            System.out.println("The use of a hoe made it easier to dig ground, an additional plot was created.");
        }
        else
            newPlotsSize = plotsSize + 2;

        if (newPlotsSize > 12)
            newPlotsSize = 12;

        newplots = new Crop[newPlotsSize];

        for (int i = 0; i < plotsSize; i++)
            newplots[i] = this.plots[i];
        this.plots = newplots;
    }
    
    public void updatePenSize() {
        GUIStatus.updateActions(-1);
        int penSize = this.pens.length;
        GUIAnimals[] newPens;
        int newPensSize = penSize + 1;
        if (newPensSize > 12) {
            newPensSize = 12;
        }
        newPens = new GUIAnimals[newPensSize];
        for (int i = 0; i < penSize; i++)
            newPens[i] = this.pens[i];
        this.pens = newPens;
    }
    
    public boolean newAnimal(GUIAnimals animal) {
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
            switch (seed){
                case "Corn":
                    this.plots[plotToPlant] = new Corn(this, plotToPlant);
                    break;
                case "Turnips":
                    this.plots[plotToPlant] = new Turnips(this, plotToPlant);
                    break;
                case "Grapes":
                    this.plots[plotToPlant] = new Grapes(this, plotToPlant);
                    break;
                case "Potatoes":
                    this.plots[plotToPlant] = new Potatoes(this, plotToPlant);
                    break;
                case "Strawberries":
                    this.plots[plotToPlant] = new Strawberries(this, plotToPlant);
                    break;
                case "Tomatoes":
                    this.plots[plotToPlant] = new Tomatoes(this, plotToPlant);
                    break;
            }

            System.out.println("Crop successfully planted.");
            GUIBag.seeds.get(seedNum).updateAmount(-1);
            if (GUIBag.seeds.get(seedNum).getAmount() == 0)
                GUIBag.seeds.remove(seedNum);
    }

    public void harvestCrop(int plotNum)
    {
        Crop crop = this.plots[plotNum];

        GUIStatus.updateMoney(crop.getValue());
        GUIStatus.updateActions(-1);
        this.plots[crop.getPlotPos()] = null;
    }

    public void tendCrop(String item , int plotNum)
    {
        Crop crop = this.plots[plotNum];
        GUIStatus.updateActions(-1);
        crop.tend(item);
    }
}
